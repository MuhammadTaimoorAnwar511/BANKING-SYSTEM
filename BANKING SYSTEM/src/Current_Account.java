
public class Current_Account extends Accounts_type
{
	private User_Managements[] user;
	private int total_dual_users;
	
	public Current_Account(int id, double balance, String status)
	{
			super(id, balance, status);
			this.user=new User_Managements[2];
			total_dual_users=0;
	}

	@Override
	public void show_account_type()
	{
		System.out.print("\nTYPE = Current account \n");
		
	}
	public   void  set_joint_account(User_Managements us1,User_Managements us2)
	{
		user[total_dual_users]=us1;
		total_dual_users++;
		user[total_dual_users]=us2;
		total_dual_users++;
	}
	public void show_Dual_user_data() 
	{
		 System.out.println("User 2: " + user[0].getName() +", USER INDEX"+user[0].getUniversity_id());
		 System.out.println("User 1: " + user[1].getName() +", USER INDEX"+user[1].getUniversity_id());
	}
	public int getTotal_user_() 
	{
		return total_dual_users;
	}

	public void setTotal_user() 
	{
		this.total_dual_users =total_dual_users+1 ;
	}
	public void widraw(double wid)
	{
		double remaining;
		
		if(wid >= this.getBalance() )
		{
		remaining=this.getBalance()-wid;
		this.setBalance(remaining);
		this.check_dormant();
		}
		else
		{
			remaining=this.getBalance()-wid;
			this.setBalance(remaining);
			this.check_dormant();	
		}
	}
	
	
	
}
