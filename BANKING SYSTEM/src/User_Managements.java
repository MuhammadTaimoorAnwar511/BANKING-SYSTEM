
public class User_Managements 
{
	private String name;
	private int University_id;
	private String address;	
	private int total_accounts_user_hold;
	private String password;
	private Accounts_type[] account;//account array
	
	
	public User_Managements(String name, int university_id, String address,String pass)//constructors//
	{
		this.name = name;
		this.University_id = university_id;
		this.address = address;
		this.total_accounts_user_hold=0;
		this.account=new Accounts_type[3];
		this.password=pass;
	}
	
	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getUniversity_id() 
	{
		return University_id;
	}
	public void setUniversity_id(int university_id) 
	{
		University_id = university_id;
	}
	public String getAddress() 
	{
		return address;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}
	public int getTotal_accounts_user_hold() 
	{
		return total_accounts_user_hold;
	}
	public void setTotal_accounts_user_hold(int total_accounts_user_hold) 
	{
		this.total_accounts_user_hold = total_accounts_user_hold;
	}
	public Accounts_type[] get_Accounts() //get account of user
	{
	    return account;
	}

	
public void set_saving_account(int acc_no,double bal,int user_no)//to open saving account
{
     
	 Saving_Account saving = new Saving_Account(acc_no,bal,"OPEN");//saving account class objects 
	
	 initializng_account(user_no,saving);
}
public void set_current_account(int acc_no,double bal,int user_no)//to open current account
{
     
	 Current_Account current = new Current_Account(acc_no,bal,"OPEN");//saving account class objects 
	
	 initializng_account(user_no,current);
}


public void initializng_account(int user_no,Accounts_type ac)//storing derived account address in parent account array
{
	if( getTotal_accounts_user_hold() < 3)//user can open maximum 3 account
	{
		 System.out.print("\n=============ACCOUNT CREATED=============\n");
		account[getTotal_accounts_user_hold()]=ac;//address assign
		setTotal_accounts_user_hold( (getTotal_accounts_user_hold()+1) );//increment user total account
		//this.total_accounts_user_hold=total_accounts_user_hold+1;//increment user total account
	}
	else
	{
		 System.out.println("Cannot add more accounts.");
	}
	
}

}
