package likhiii;

import java.time.LocalDate;
public class Account {
	public Account(String accNo,String type,String date,String balance) {
		this.accNo=Integer.parseInt(accNo);
		this.type=type;
		this.date=LocalDate.parse(date);
		this.balance=Double.parseDouble(balance);
		
	}
	
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	int accNo;
	String type;
	LocalDate date;
	double balance;
}


