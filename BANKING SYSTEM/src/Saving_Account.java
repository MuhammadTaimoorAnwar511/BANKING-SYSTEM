
public  class Saving_Account extends Accounts_type
{
	//private User_Managements[] user;
	//private int total_user;
	
	public Saving_Account(int id, double balance, String status)
	{
			super(id, balance, status);
		//	this.user=new User_Managements[2];
	}
	public void show_account_type()
	{
		System.out.print("\nTYPE = saving account \n");
	}
	
	public void widraw(double wid)
	{
		double remaining;
		if(wid >= this.getBalance() )
		{
		remaining=(this.getBalance()- (wid+wid*0.0001) );
		this.setBalance(remaining);
		this.check_dormant();
		}
		else
		{
			remaining=(this.getBalance() - (wid+wid*0.0001) );
			this.setBalance(remaining);
			this.check_dormant();	
		}
	}
	
	public   void  set_joint_account(User_Managements us1,User_Managements us2){}
	public void show_Dual_user_data(){}
	
}
