package likhiii;
import java.time.LocalDate;
public class Transaction {
	int tid;
	int acc_no;
	LocalDate tdate;
	String mode;
	double amt;
	public Transaction(String tid,String acc_no,String tdate,String mode,String amt) {
		this.tid=Integer.parseInt(tid);
		this.acc_no=Integer.parseInt(acc_no);
		this.tdate=LocalDate.parse(tdate);
		this.mode=mode;
		this.amt=Double.parseDouble(amt);
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}
	public LocalDate getTdate() {
		return tdate;
	}
	public void setTdate(LocalDate tdate) {
		this.tdate = tdate;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}
	
}
