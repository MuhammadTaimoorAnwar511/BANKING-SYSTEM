
abstract class Accounts_type 
{
	private int account_no;
	private double balance;
	private String status;
	public Accounts_type(int account_no, double balance, String status) //constructor//
	{
		this.account_no = account_no;
		this.balance = balance;
		this.status = status;
	}
	public int getAccount_no() //get account no
	{
		return account_no;
	}
	public void setAccount_no(int account_no) //set account no
	{
		this.account_no = account_no;
	}
	public double getBalance() //get balance
	{
		return balance;
	}
	public void setBalance(double balance) //set balance
	{
		this.balance = balance;
	}
	public String getStatus() //get status
	{
		return status;
	}
	public void setStatus(String status) //set status
	{
		this.status = status;
	}
	public void check_dormant()//negative pa account closed
	{
	if(this.getBalance()<0)
	{
		this.status="CLOSE";
	}
	else
	{
		
	}
	
	}
	
	public abstract  void show_account_type();
	public abstract  void  set_joint_account(User_Managements us1,User_Managements us2);
	public abstract void show_Dual_user_data() ;
	public abstract void widraw(double bal);
}
