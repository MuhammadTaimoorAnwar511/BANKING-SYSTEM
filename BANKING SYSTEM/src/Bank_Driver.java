import java.util.Scanner;

public class Bank_Driver 
{

	public static void main(String[] args) 
	{
		Scanner cin = new Scanner(System.in);//for input 
		
		
Bank b1=new Bank("allied");//for bank object
int opt=1;//selection option
String name;//for name input
String address;//for address input//
String user_password;//for password input
int uni_id=-1;//university id
int search_id;//search id;
double balance;//for balance
double trans_balance;//transaction balance
int from_acc_index;//stroing index of account from which transaction happens
int n;
int account_type;//1 saving 2 current
int no_acc_creat;//no of account single user want to create taking input
int loop_for_account=1;//controll while loop for no_acc_creat
int account_ids_index=0;//for controlling input range for case 4/5
boolean result;//for comparison of password for deposit widraw transaction
while(opt!=0)
{
	do
	{
	System.out.println("\nSELECT OPTION \n1] OPEN NEW ACCOUNT FOR SINGLE PERSON\n2] OPEN NEW  DUAL CURRENT ACCOUNT\n3] Open account for EXSISTING USER \n4] Closed account\n5] Reopen Account \n6] EDIT USER DETAIL\n7] GET Specific USER DETAILS\n8] SHOW ALL USER DETAIL\n9]DEPOSIT in Account \n10]WIDRAW from Account \n11]TRANSFER MONEY\n12] SHOW TRANSACTION HISTORY \n");
	opt=cin.nextInt();//taking input
	}while(opt<=0 || opt>=13);
	
	switch(opt)
{

case 1://open new single account 
	
loop_for_account=1;//control while loop for no_acc_creat 
b1.set_total_bank_user();
System.out.print("\nENTER NAME OF USER\n");
name=cin.next();
System.out.print("\nENTER ADDRESS OF USER\n");
address=cin.next();
System.out.print("\nENTER PASSSWORD OF USER\n");
user_password=cin.next();
uni_id=uni_id+1;
b1.open_new_account(name, uni_id, address,user_password);//open new account

do
{
System.out.print("\nnumber of account you want to create 1 to 3");
no_acc_creat=cin.nextInt();
}while(no_acc_creat>=4 || no_acc_creat<=0);//controll input range

while(loop_for_account <= no_acc_creat)//creat number of account according to user choice  
{
	
do
{
System.out.print("\nWhich account you want to open \n1] SAVING\n2]CURRENT");
account_type=cin.nextInt();
}while(account_type>=3 || account_type<=0);//controll input range

if(account_type==1)//creating saving
{
	b1.set_assign_account_no();//increment account no
	do
	{
	System.out.print("\nENTER initial balance to open SAVING account Minumum required is 100 RS\n");
	balance=cin.nextDouble();//set balance//	
	}while(balance<100);
	n=(b1.get_bank_total_users());//user no according to index

	b1.get_User( n ).set_saving_account( b1.get_assign_account_no(), balance, n );//saving account open for  user 

}
else//create current
{
	b1.set_assign_account_no();//increment account no
	do
	{
	System.out.print("\nENTER initial balance to open CURRENR account Minumum required is 100 RS\n");
	balance=cin.nextDouble();//set balance//	
	}while(balance<100);
	n=(b1.get_bank_total_users());//user no according to index

	b1.get_User( n ).set_current_account( b1.get_assign_account_no(), balance, n );//current account open for  user 
	
}

loop_for_account=loop_for_account+1;
}
break;

case 2://open new dual account//
	b1.set_total_bank_user();
	System.out.print("\nENTER NAME OF USER 1\n");
	name=cin.next();
	System.out.print("\nENTER ADDRESS OF USER 1\n");
	address=cin.next();
	System.out.print("\nENTER PASSSWORD OF USER\n");
	user_password=cin.next();
	uni_id=uni_id+1;
	b1.open_new_account(name, uni_id, address,user_password);//open new account for user 1
	
	b1.set_total_bank_user();
	System.out.print("\nENTER NAME OF USER 2\n");
	name=cin.next();
	System.out.print("\nENTER ADDRESS OF USER 2\n");
	address=cin.next();
	System.out.print("\nENTER PASSSWORD OF USER\n");
	user_password=cin.next();
	uni_id=uni_id+1;
	b1.open_new_account(name, uni_id, address,user_password);//open new account for user 2
	
	b1.set_assign_account_no();//increment account no
	do
	{
	System.out.print("\nENTER initial balance to open Current DUAL account Minumum required is 100 RS\n");
	balance=cin.nextDouble();//set balance//	
	}while(balance<100);
	n=(b1.get_bank_total_users());//user no according to index
    //there are two user 
	//n-1 previous
	//n next user//
	b1.get_User( n ).set_current_account( b1.get_assign_account_no(), balance, n );//current account open for  user
	b1.get_User(n).get_Accounts()[0].set_joint_account(b1.get_User(n), b1.get_User(n-1));//store name of dual user in current class
	b1.get_User( n-1 ).set_current_account( b1.get_assign_account_no(), balance, n-1 );//current account open for  user
	b1.get_User(n).get_Accounts()[0].show_Dual_user_data();
	
	break;
	
case 3://open account for exsisting user
	System.out.print("\n ENTER USER UNIVERSITY ID/INDEX  FOR WHICH YOU WANT TO OPEN ANOTHER ACCOUNT\n");
	search_id=cin.nextInt();
	
	for(int i=0;i<=b1.get_bank_total_users();i++ )//check all user and compare
	{
		if(b1.get_User(i).getUniversity_id()==search_id && b1.get_User(i).getTotal_accounts_user_hold()<=2)//check all user and compare their each account number //
		{
			do
			{
			System.out.print("\nWhich account you want to open \n1] SAVING\n2]CURRENT");
			account_type=cin.nextInt();
			}while(account_type>=3 || account_type<=0);//controll input range
			
			if(account_type==1)//creating saving
			{
				b1.set_assign_account_no();//increment account no
				do
				{
				System.out.print("\nENTER initial balance to open SAVING account Minumum required is 100 RS\n");
				balance=cin.nextDouble();//set balance//	
				}while(balance<100);
				
				b1.get_User( i ).set_saving_account( b1.get_assign_account_no(), balance, i );//saving account open for  user 

			}
			else//create current
			{
				b1.set_assign_account_no();//increment account no
				do
				{
				System.out.print("\nENTER initial balance to open CURRENR account Minumum required is 100 RS\n");
				balance=cin.nextDouble();//set balance//	
				}while(balance<100);
				
				b1.get_User( i ).set_current_account( b1.get_assign_account_no(), balance, i );//current account open for  user 
			}
		}
		else
		{
			//System.out.print("\nENTER CORRECT ACCOUNT NO \n");	
		}
		
	}
	break;
case 4://closed account
	
	System.out.print("\n BANK TOTAL USER \n");
	System.out.print(b1.get_bank_total_users()+1);
	System.out.print("\nUSERS  UIVERSITY ID/INDEX 0 TO "+b1.get_bank_total_users());//index /id of uni ids
	System.out.print("\n TOTAL ACCOUNTS IN BANK =  "+( b1.get_assign_account_no()+1));//CHANGED
	System.out.print("\n BANK ACCOUNTS ID/INDEX 0 TO "+ (b1.get_assign_account_no()));//account ids/index numbers
	
	do
	{
	System.out.print("\n ENTER ACCOUNTS ID/INDEX \n");
	search_id=cin.nextInt();//ACCOUNT INDEX take input
	}while(search_id<=-1 || search_id > (b1.get_assign_account_no()) );//account ids/index numbers)// controling input range
	
	for(int i=0;i<=b1.get_bank_total_users();i++)//loop for bank all users
	{
		
		for(int k=0; k<b1.get_User(i).getTotal_accounts_user_hold(); k++)//loop for number of account user has
		{
		
		if(b1.get_User(i).get_Accounts()[k].getAccount_no() == search_id && b1.get_User(i).get_Accounts()[k].getStatus()=="OPEN")
		{
			//System.out.print("\n USER ACCOUNT STATUS CHANGED TO CLOSED \n");
			b1.get_User(i).get_Accounts()[k].setStatus("CLOSE");
		}
		else {}
			
		}
	}
	
	break;
	
case 5:///open account

	
	System.out.print("\n BANK TOTAL USER \n");
	System.out.print(b1.get_bank_total_users()+1);
	System.out.print("\nUSERS  UIVERSITY ID/INDEX 0 TO "+b1.get_bank_total_users());//index /id of uni ids
	System.out.print("\n TOTAL ACCOUNTS IN BANK =  "+( b1.get_assign_account_no()+1));//CHANGED
	System.out.print("\n BANK ACCOUNTS ID/INDEX 0 TO "+ (b1.get_assign_account_no()));//account ids/index numbers
	
	do
	{
	System.out.print("\n ENTER ACCOUNTS ID/INDEX \n");
	search_id=cin.nextInt();//ACCOUNT INDEX take input
	}while(search_id<=-1 || search_id > (b1.get_assign_account_no()) );//account ids/index numbers)// controling input range
	
	for(int i=0;i<=b1.get_bank_total_users();i++)//loop for bank all users
	{
		for(int k=0; k<b1.get_User(i).getTotal_accounts_user_hold(); k++)//loop for number of account user has
		{
		
		if(b1.get_User(i).get_Accounts()[k].getAccount_no() == search_id && b1.get_User(i).get_Accounts()[k].getStatus()=="CLOSE")
		{	
			if(b1.get_User(i).get_Accounts()[k].getBalance() < 0 )// if balance is negative
			{
				do
				{
				balance=( b1.get_User(i).get_Accounts()[k].getBalance()*-2)+100;
				System.out.print("\n DEPOSIT BALANCE TO OPEN ACCOUNT \nMINUMUN DEPOSIT IS "+balance);//calcluting minimum amount requiren to open account
				System.out.print("\n ENTER DEPOSIT AMOUNT \n");
				balance=cin.nextDouble();
			     }while(balance < ( b1.get_User(i).get_Accounts()[k].getBalance()*-2)+100);//minimum amount requiren to open account and handeling it 
				
				System.out.print("\n USER ACCOUNT STATUS CHANGED TO OPENED \n");
				b1.get_User(i).get_Accounts()[k].setStatus("OPEN");//updating status
				b1.get_User(i).get_Accounts()[k].setBalance(balance);//updating balanced
			}
			
			else// if balance is positive 
			{
				do
				{
				System.out.print("\n DEPOSIT BALANCE TO OPEN ACCOUNT \nMINUMUN DEPOSIT IS 100 ");//calcluting minimum amount requiren to open account
				System.out.print("\n ENTER DEPOSIT AMOUNT \n");
				balance=cin.nextDouble();
			     }while(balance < 100);//minimum amount requiren to open account and handeling it 
				System.out.print("\n USER ACCOUNT STATUS CHANGED TO OPENED \n");
				b1.get_User(i).get_Accounts()[k].setStatus("OPEN");//updating status	
				b1.get_User(i).get_Accounts()[k].setBalance(balance);//updating balance
			}
		}
		
		else {}
			
		}
	}
	
	break;
	
case 6://EDIT USER DETAIL
	System.out.print("\n SIGN IN YOUR ACCOUNT BY ENTERING USER UNIVERSITY  ID/INDEX AND PASSWORD \n");
	System.out.print("\n ENTER USER UNIVERSITY  ID \n");
	search_id=cin.nextInt();//uni id of user take input
	System.out.print("\nENTER PASSSWORD OF USER\n");
	user_password=cin.next();

	for(int i=0; i<=b1.get_bank_total_users() ;i++)
	{
		if(b1.get_User(i).getUniversity_id() == search_id && user_password.equals(b1.get_User(i).getPassword()) )//check all user and compare their each account number //
		{
			do
			{
			System.out.print("\n1] edit NAME\n2] edit ADDRESS\n3] edit PASSWORD");
			search_id=cin.nextInt();//taking input for option
			}while(search_id<=0 || search_id>=4);
			if(search_id == 1)
			{
				System.out.print("\nENTER NEW NAME OF USER\n");
				name=cin.next();
				b1.get_User(i).setName(name);
			}
			else if(search_id == 1)
			{
				System.out.print("\nENTER NEW ADDRESS OF USER\n");
				address=cin.next();	
				b1.get_User(i).setAddress(address);
			}
			else
			{
				System.out.print("\nENTER NEW PASSWORD OF USER\n");
				user_password=cin.next();	
				b1.get_User(i).setPassword(user_password);
			}
		}
		else
		{
			
		}
	}
	
	break;
case 7://GET SPECIFIC USER DETAIL
	
do 
{	
System.out.print("\n BANK TOTAL USER \n");
System.out.print(b1.get_bank_total_users()+1);
System.out.print("\nENTER USER UNIVERSITY ID/INDEX 0 to "+b1.get_bank_total_users());//for getting detail
search_id=cin.nextInt();
}while( search_id<=-1 || search_id > b1.get_bank_total_users() );


for(int i=0; i <= b1.get_bank_total_users(); i++ )//check all user and compare
{
	if(b1.get_User(i).getUniversity_id() == search_id)//check all user and compare their each university number //
	{
	System.out.print("\n===============================\n");
	System.out.println( "NAME ="+b1.get_User(i).getName() );//name
	System.out.println( "UNI ID  ="+b1.get_User(i).getUniversity_id() );//uni id
	System.out.println( "ADDRESS ="+b1.get_User(i).getAddress() );//adress
	
		for(int k=0;k < b1.get_User(i).getTotal_accounts_user_hold(); k++)//loop for number of account user has
		{
			b1.get_User(i).get_Accounts()[k].show_account_type();//type saving or current
			System.out.println("\nACCOUNT ID ="+ b1.get_User(i).get_Accounts()[k].getAccount_no() );//account id
			System.out.println("ACCOUNT BALANCE ="+ b1.get_User(i).get_Accounts()[k].getBalance() );//account balance
			System.out.println("\nUSER ID PASSWORD ="+ b1.get_User(i).getPassword());//show user id password which is connect to evary account
			System.out.println( b1.get_User(i).get_Accounts()[k].getStatus() );//SHOW ACCOUNT WITH THERE ID 
		}
		System.out.println( "TOTAL USER ACCOUNT HOLD ="+b1.get_User(i).getTotal_accounts_user_hold() );//number of account user hold
		System.out.println( "\n=============================\n");
	}
	else
	{
		//System.out.print("\nENTER CORRECT ACCOUNT NO \n");	
	}
}

break;

case 8://show all data
	
	for(int i=0;i<=b1.get_bank_total_users();i++)//loop for bank all users
	{
		System.out.print("\n===============================\n");
		System.out.println( "NAME ="+b1.get_User(i).getName() );//name
		System.out.println( "UNI ID  ="+b1.get_User(i).getUniversity_id() );//uni id
		System.out.println( "ADDRESS ="+b1.get_User(i).getAddress() );//adress
		
		for(int k=0; k<b1.get_User(i).getTotal_accounts_user_hold(); k++)//loop for number of account user has
		{
		b1.get_User(i).get_Accounts()[k].show_account_type();//type saving or current
		System.out.println("\nACCOUNT ID ="+ b1.get_User(i).get_Accounts()[k].getAccount_no() );//account id
		System.out.println("ACCOUNT BALANCE ="+ b1.get_User(i).get_Accounts()[k].getBalance() );//account balance
		System.out.println("\nUSER ID PASSWORD ="+ b1.get_User(i).getPassword());//show user id password which is connect to evary account
		System.out.println( b1.get_User(i).get_Accounts()[k].getStatus() );//SHOW ACCOUNT WITH THERE ID 
		}
		System.out.println( "TOTAL USER ACCOUNT HOLD ="+b1.get_User(i).getTotal_accounts_user_hold() );//number of account user hold
		System.out.print("\n===============================\n");
	}
	
break;

case 9://deposit 
	
	System.out.print("\n SIGN IN YOUR ACCOUNT BY ENTERING ACCOUNT ID/INDEX AND PASSWORD \n");
	
	System.out.print("\n BANK TOTAL USER \n");
	System.out.print(b1.get_bank_total_users()+1);
	System.out.print("\nUSERS  UIVERSITY ID/INDEX 0 TO "+b1.get_bank_total_users());//index /id of uni ids
	System.out.print("\n TOTAL ACCOUNTS IN BANK =  "+( b1.get_assign_account_no()+1));//CHANGED
	System.out.print("\n BANK ACCOUNTS ID/INDEX 0 TO "+ (b1.get_assign_account_no()));//account ids/index numbers
	
	do
	{
	System.out.print("\n ENTER ACCOUNTS ID/INDEX \n");
	search_id=cin.nextInt();//ACCOUNT INDEX take input
	
	}while(search_id<=-1 || search_id > (b1.get_assign_account_no()) );//account ids/index numbers)// controling input range
	
	System.out.print("\nENTER PASSSWORD OF USER\n");
	user_password=cin.next();
	
	for(int i=0;i<=b1.get_bank_total_users();i++)//loop for bank all users
	{
		
		for(int k=0; k<b1.get_User(i).getTotal_accounts_user_hold(); k++)//loop for number of account user has
		{
		
		if(b1.get_User(i).get_Accounts()[k].getAccount_no() == search_id && b1.get_User(i).get_Accounts()[k].getStatus()=="OPEN"  && user_password.equals(b1.get_User(i).getPassword()) )//only  open account can widraw money
		{
			System.out.print("\n ENTER AMOUNT YOU WANT TO DEPOSIT IN ACCOUNT MINIMMUM IS 100 RS \n");
			do
			{
				System.out.print("\n ENTER DEPOSIT AMOUNT \n");
				balance=cin.nextDouble();//deposit amount input 
			}while(balance<100);
			trans_balance=balance;
			balance=balance+b1.get_User(i).get_Accounts()[k].getBalance();//calcluting new balance
			
			System.out.print("\n DEPOSIT COMPLETED \n");
			
			b1.get_User(i).get_Accounts()[k].setBalance(balance);//updating balance
			
			b1.set_transaction_ledger();//new ledger
			b1.set_assign_transaction_id();
			System.out.println("TRANSACTION ID  = "+b1.get_assign_transaction_id() );
			
			b1.get_transaction_ledger(b1.get_assign_transaction_id()).set_time();
			b1.get_transaction_ledger(b1.get_assign_transaction_id()).set_transaction_id(b1.get_assign_transaction_id());
			b1.get_transaction_ledger(b1.get_assign_transaction_id()).set_transfer_amount( trans_balance );
			b1.get_transaction_ledger(b1.get_assign_transaction_id()).setFrom_Account_no(search_id);
			b1.get_transaction_ledger(b1.get_assign_transaction_id()).setTo_Account_no(-1);
			b1.get_transaction_ledger(b1.get_assign_transaction_id()).setTransaction_type("DEPOSIT");
		}
		
		else {}
			
		}
	}
	
	break;
case 10:// Widraw

	System.out.print("\n SIGN IN YOUR ACCOUNT BY ENTERING ACCOUNT ID/INDEX AND PASSWORD \n");
	System.out.print("\n BANK TOTAL USER \n");
	System.out.print(b1.get_bank_total_users()+1);
	System.out.print("\nUSERS  UIVERSITY ID/INDEX 0 TO "+b1.get_bank_total_users());//index /id of uni ids
	System.out.print("\n TOTAL ACCOUNTS IN BANK =  "+( b1.get_assign_account_no()+1));//CHANGED
	System.out.print("\n BANK ACCOUNTS ID/INDEX 0 TO "+ (b1.get_assign_account_no()));//account ids/index numbers


	do
	{
	System.out.print("\n ENTER ACCOUNTS ID/INDEX \n");
	search_id=cin.nextInt();//ACCOUNT INDEX take input
	}while(search_id<=-1 || search_id > (b1.get_assign_account_no()) );//account ids/index numbers)// controling input range
	
	System.out.print("\nENTER PASSSWORD OF USER\n");
	user_password=cin.next();
	
	for(int i=0;i<=b1.get_bank_total_users();i++)//loop for bank all users
	{
		
		for(int k=0; k<b1.get_User(i).getTotal_accounts_user_hold(); k++)//loop for number of account user has
		{
		
		if(b1.get_User(i).get_Accounts()[k].getAccount_no() == search_id && b1.get_User(i).get_Accounts()[k].getStatus()=="OPEN" && user_password.equals(b1.get_User(i).getPassword()) )//only  open account can widraw money
		{
			do
			{
				System.out.print("\n ENTER AMOUNT YOU WANT TO WIDRAW FROM ACCOUNT \n");
				balance=cin.nextDouble();//widraw amount input 
			}while(balance < 0 );
			
			System.out.print("\n  WIDRAW  COMPLETED \n");
			b1.get_User(i).get_Accounts()[k].widraw(balance);
			
			b1.set_transaction_ledger();//new ledger
			
			b1.set_assign_transaction_id();
			System.out.println("TRANSACTION ID  = "+b1.get_assign_transaction_id() );
			
			b1.get_transaction_ledger(b1.get_assign_transaction_id()).set_time();
			b1.get_transaction_ledger(b1.get_assign_transaction_id()).set_transaction_id(b1.get_assign_transaction_id());
			b1.get_transaction_ledger(b1.get_assign_transaction_id()).set_transfer_amount(balance);
			b1.get_transaction_ledger(b1.get_assign_transaction_id()).setFrom_Account_no(search_id);
			b1.get_transaction_ledger(b1.get_assign_transaction_id()).setTo_Account_no(-1);
			b1.get_transaction_ledger(b1.get_assign_transaction_id()).setTransaction_type("WIDRAW");
		}
		
		else {}
			
		}
	}
	break;
	
case 11://transaction//
	
	System.out.print("\n SIGN IN YOUR ACCOUNT BY ENTERING ACCOUNT ID/INDEX AND PASSWORD \n");
	System.out.print("\n BANK TOTAL USER \n");
	System.out.print(b1.get_bank_total_users()+1);
	System.out.print("\nUSERS  UIVERSITY ID/INDEX 0 TO "+b1.get_bank_total_users());//index /id of uni ids
	System.out.print("\n TOTAL ACCOUNTS IN BANK =  "+( b1.get_assign_account_no()+1));//CHANGED
	System.out.print("\n BANK ACCOUNTS ID/INDEX 0 TO "+ (b1.get_assign_account_no()));//account ids/index numbers


	do
	{
	System.out.print("\n ENTER ACCOUNTS ID/INDEX \n");
	search_id=cin.nextInt();//ACCOUNT INDEX take input
	}while(search_id<=-1 || search_id > (b1.get_assign_account_no()) );//account ids/index numbers)// controling input range
	from_acc_index=search_id;
	System.out.print("\nENTER PASSSWORD OF USER\n");
	user_password=cin.next();
	
	for(int i=0;i<=b1.get_bank_total_users();i++)//loop for bank all users
	{
		
		for(int k=0; k<b1.get_User(i).getTotal_accounts_user_hold(); k++)//loop for number of account user has
		{
		
		if(b1.get_User(i).get_Accounts()[k].getAccount_no() == search_id && b1.get_User(i).get_Accounts()[k].getStatus()=="OPEN" && user_password.equals(b1.get_User(i).getPassword()) )//only  open account can widraw money
		{
			do
			{
				System.out.print("\n ENTER AMOUNT YOU WANT TO TRANSFER FROM ACCOUNT \n");
				balance=cin.nextDouble();//widraw amount input 
			}while(balance < 0 );
			
			
			
			do
			{

			System.out.print("\n ENTER ACCOUNT ID/INDEX TO which you want to transfer money \n");
			search_id=cin.nextInt();//ACCOUNT INDEX take input
			
			}while(search_id<=-1 || search_id > (b1.get_assign_account_no()) );//account ids/index numbers)// controling input range
			
			for(int I=0;I<=b1.get_bank_total_users();I++)//loop for bank all users
			{
				
				for(int K=0; K<b1.get_User(I).getTotal_accounts_user_hold(); K++)//loop for number of account user has
				{
				//System.out.println(" acc no "+b1.get_User(I).get_Accounts()[K].getAccount_no());
				//System.out.println(" name   "+b1.get_User(I).getName());
				
					if(b1.get_User(I).get_Accounts()[K].getAccount_no() == search_id && b1.get_User(I).get_Accounts()[K].getStatus()=="OPEN"  )//only  open account can widraw money
				{
					//WIDRAWW
					//b1.setTransfer_balance(balance);
					b1.get_User(i).get_Accounts()[k].widraw(balance);
					//DEPOSIT.TRANSFER//
					trans_balance=balance;
					balance=balance+b1.get_User(I).get_Accounts()[K].getBalance();//calcluting new balance
					b1.get_User(I).get_Accounts()[K].setBalance(balance);//updating balance
					
					b1.set_transaction_ledger();//new ledger
					
					b1.set_assign_transaction_id();
					System.out.println("TRANSACTION ID  = "+b1.get_assign_transaction_id() );
					
					b1.get_transaction_ledger(b1.get_assign_transaction_id()).set_time();
					b1.get_transaction_ledger(b1.get_assign_transaction_id()).set_transaction_id(b1.get_assign_transaction_id());
					
					b1.get_transaction_ledger(b1.get_assign_transaction_id()).set_transfer_amount(trans_balance);
					
					b1.get_transaction_ledger(b1.get_assign_transaction_id()).setFrom_Account_no(from_acc_index);
					b1.get_transaction_ledger(b1.get_assign_transaction_id()).setTo_Account_no(search_id);
					b1.get_transaction_ledger(b1.get_assign_transaction_id()).setTransaction_type("TRANSFER");

					System.out.print("\n TRANSFER COMPLETED \n");
					
					
					break;
				}
				else 
				{
					
				}
					break;
					
				}
			}
			//
		}
		
		else {}
			
		}
	}
	break;
case 12:
	do
	{
	System.out.print("\n1] ACCOUNT STATEMENT BY ACCOUNT ID/INDEX \n2] TRANSACTION HISTORY BY TRANSACTION ID/INDEX \n");
	opt=cin.nextInt();
	}while(opt<=0 || opt>=3);
	
	if(opt==1)
{
	System.out.print("\n TOTAL ACCOUNTS IN BANK =  "+( b1.get_assign_account_no()+1));//CHANGED
	System.out.print("\n BANK ACCOUNTS ID/INDEX 0 TO "+ (b1.get_assign_account_no()));//account ids/index numbers
	
	System.out.print("\n ACCOUNT STATEMENT BY ACCOUNT ID/INDEX  \n");
	do
	{
	System.out.print("\n ENTER ACCOUNTS ID/INDEX \n");
	search_id=cin.nextInt();//ACCOUNT INDEX take input
	}while(search_id<=-1 || search_id >  b1.get_assign_account_no() );//account ids/index numbers)// controling input range
	
	for(int i=0; i<= b1.get_assign_transaction_id(); i++)//total transaction
	{
		if(b1.get_transaction_ledger(i).getFrom_Account_no( )== search_id)//account id match
		{
			System.out.println("\n=======================================================================\n");
			System.out.println("TRANSACTION ID  = "+b1.get_transaction_ledger(i).get_transaction_id());
			System.out.println("TRANSFER AMOUNT = "+b1.get_transaction_ledger(i).get_transfer_amount());
			System.out.println("FROM ACCOUNT    = "+b1.get_transaction_ledger(i).getFrom_Account_no());
			if(b1.get_transaction_ledger(i).getTo_Account_no()==-1){}
			else
			{
			System.out.println("TO ACCOUNT      = "+b1.get_transaction_ledger(i).getTo_Account_no());	
			}
			System.out.println("TRANSACTION TYPE= "+b1.get_transaction_ledger(i).getTransaction_type());
			System.out.println("YEAR   = "+b1.get_transaction_ledger(i).get_year());
			System.out.println("MONTH  = "+b1.get_transaction_ledger(i).get_month());
			System.out.println("DAY    = "+b1.get_transaction_ledger(i).get_day());
			System.out.println("HOUR   = "+b1.get_transaction_ledger(i).get_hour());
			System.out.println("MINUTE = "+b1.get_transaction_ledger(i).get_minute());
			System.out.println("\n=======================================================================\n");
		}
		else {}
	}
}
	
else
{
	do
	{
	System.out.print("\n ENTER TRANSACTION ID/INDEX from 0 to "+b1.get_assign_transaction_id());
	search_id=cin.nextInt();
	
	}while(search_id<= -1 || search_id > b1.get_assign_transaction_id() );
	
	for(int i=0;i<=b1.get_assign_transaction_id();i++)//total transcation
	{
		if(b1.get_transaction_ledger(i).get_transaction_id() == search_id)//trx id match
		{
			System.out.println("\n=======================================================================\n");
			System.out.println("TRANSACTION ID  = "+b1.get_transaction_ledger(i).get_transaction_id());
			System.out.println("TRANSFER AMOUNT = "+b1.get_transaction_ledger(i).get_transfer_amount());
			System.out.println("FROM ACCOUNT    = "+b1.get_transaction_ledger(i).getFrom_Account_no());
			if(b1.get_transaction_ledger(i).getTo_Account_no()==-1){}
			else
			{
			System.out.println("TO ACCOUNT      = "+b1.get_transaction_ledger(i).getTo_Account_no());	
			}
			System.out.println("TRANSACTION TYPE= "+b1.get_transaction_ledger(i).getTransaction_type());
			System.out.println("YEAR   = "+b1.get_transaction_ledger(i).get_year());
			System.out.println("MONTH  = "+b1.get_transaction_ledger(i).get_month());
			System.out.println("DAY    = "+b1.get_transaction_ledger(i).get_day());
			System.out.println("HOUR   = "+b1.get_transaction_ledger(i).get_hour());
			System.out.println("MINUTE = "+b1.get_transaction_ledger(i).get_minute());
			System.out.println("\n=======================================================================\n");
		}
		else {}
	}
	
}
	
	break;

}

opt=1;
}

}

}
