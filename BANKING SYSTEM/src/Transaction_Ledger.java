import java.time.LocalDateTime;


public class Transaction_Ledger 
{
	
LocalDateTime currentDateTime = LocalDateTime.now();

private  int transaction_id;
private  int year;
private  int month;
private  int day;
private  int hour;
private  int minute;
private  int from_Account_no;
private  int to_Account_no;
private  String transaction_type;
private double transfer_amount;

public Transaction_Ledger()
{	
	this.transaction_id = 0;
	this.year = 0;
	this.month = 0;
	this.day = 0;
	this.hour=0;
	this.minute = 0;
	this.from_Account_no = -1;
	this.transaction_type="null";
	this.to_Account_no = -1;
	this.transfer_amount = 0.00;
}


public void set_transfer_amount(double t)
{
	this.transfer_amount=t;
}
public void set_transaction_id(int i)
{
	this.transaction_id=i;
}

public int get_transaction_id()
{
	return transaction_id;	
}
public void set_time()
{
	 year = currentDateTime.getYear();
	 month = currentDateTime.getMonthValue();
	 day = currentDateTime.getDayOfMonth();
	 hour = currentDateTime.getHour();
	 minute = currentDateTime.getMinute();
}


public void setFrom_Account_no(int from_Account_no) 
{
	this.from_Account_no = from_Account_no;
}


public void setTo_Account_no(int to_Account_no) 
{
	this.to_Account_no = to_Account_no;
}

public void setTransfer_amount(double transfer_amount) 
{
	this.transfer_amount = transfer_amount;
}

public void setTransaction_type(String transaction_type) 
{
	this.transaction_type = transaction_type;
}

//================================//
public String getTransaction_type() 
{
	return transaction_type;
}
public double get_transfer_amount()
{
	return this.transfer_amount;
}
public int get_year() 
{
	return this.year;
}
public int get_month() 
{
	return this.month;
}
public int get_day() 
{
	return this.day;
}
public int get_hour() 
{
	return this.hour;
}
public int get_minute() 
{
	return this.minute;
}

public int getFrom_Account_no() 
{
	return from_Account_no;
}
public int getTo_Account_no() 
{
	return to_Account_no;
}
public double getTransfer_amount() 
{
	return transfer_amount;
}

}
