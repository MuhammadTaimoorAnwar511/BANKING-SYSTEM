import java.time.LocalDateTime;
import java.util.ArrayList;

public class Bank 
{
private String name;
private int assign_account_no;
private int assign_transaction_id;
private int total_bank_user;
private int total_transaction_happens;//total transaction happen//
private double transfer_balance;//transfer balance from widraw account to deposit account;
private ArrayList<User_Managements>  user;//array list of user
private ArrayList<Transaction_Ledger> ledger;//array list of transaction 

public Bank(String name) //bank constructor//
{
	this.setName(name);
	this.assign_account_no = -1;
	this.assign_transaction_id =-1;
	this.total_bank_user=-1;
	this.transfer_balance=0;
	total_transaction_happens=0;
	user=new ArrayList<>();//array list of user
	ledger=new ArrayList<>();
}

public void set_total_bank_user()
{
	 this.total_bank_user=total_bank_user+1;
}
public void set_total_transaction_happens()
{
	 this.total_transaction_happens=total_transaction_happens+1;
}

public User_Managements get_User(int i) //get user object
{
	return user.get(i);
}
public void set_transaction_ledger() 
{
	this.ledger.add( new Transaction_Ledger() );
//	this.ledger.add( new Transaction_Ledger(0,0,0,0,0,0,-1,-1,"null",0) );
}
public Transaction_Ledger get_transaction_ledger(int i)
{
	return ledger.get(i);
}

public void set_User(String u_name,int u_id,String u_address,String pass)//add new user to bank//
{
	this.user.add( new User_Managements(u_name,u_id,u_address,pass) );
}

public void  set_assign_account_no()//bank assign unique code to account
{
	assign_account_no=assign_account_no+1;
}
public void set_assign_transaction_id()//bank assign unique transaction id for each transaction
{
	assign_transaction_id=assign_transaction_id+1;
}

public int get_total_transaction_happens()
{
	return total_transaction_happens;
}
public int get_bank_total_users()
{
	return total_bank_user;
}
public int get_assign_account_no()//get account no
{
	return assign_account_no;
}
public int  get_assign_transaction_id()//get transaction id
{
	return assign_transaction_id;
}
public void open_new_account(String u_name,int u_id,String u_address,String pass)//open new bank account
{
	set_User( u_name,u_id,u_address,pass );	
}

public String getName() //getter bank name
{
	return name;
}

public void setName(String name) //bank name setter
{
	this.name = name;
}

public double getTransfer_balance()
{
	return transfer_balance;
}

public void setTransfer_balance(double transfer_balance) 
{
	this.transfer_balance = transfer_balance;
}

}
