package likhiii;

import java.util.ArrayList;
import java.io.*;
import java.time.LocalDate;

public class Main {

public static void main(String[] args) {
		
	ArrayList<Account> acc = new ArrayList<>();
	ArrayList<Transaction> tra = new ArrayList<>();		
			try{
				BufferedReader bin=new BufferedReader(new FileReader("E:\\likhi\\src\\likhiii\\Account.txt"));
				BufferedReader bin1 = new BufferedReader(new FileReader("E:\\likhi\\src\\likhiii\\Transactions.txt"));
				String line;
				String line1;
				while((line=bin.readLine())!=null){
					String[] m= line.split(",");
					Account a = new Account(m[0],m[1],m[2],m[3]);
					acc.add(a);
				}
				while((line1=bin1.readLine())!=null) {
					String [] n= line1.split(",");
					Transaction t=new Transaction(n[0],n[1],n[2],n[3],n[4]);
					tra.add(t);
					
				}
			bin.close();
			/*for(Account a:acc) {
				System.out.println(a.getAccNo()+" "+a.getType()+" "+a.getDate()+" "+a.getBalance());
			}*/
			}catch(Exception e){
				e.printStackTrace();
			}
			for(Account a:acc) {
				LocalDate d1=LocalDate.now();
				LocalDate d2=a.getDate();
			}
			

	}

}
