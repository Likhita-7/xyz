package bank;



import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;

import java.time.LocalDate;

import java.util.ArrayList;



public class Main {

	static ArrayList<Account> accList = new ArrayList<>();

	static ArrayList<Transaction> transList = new ArrayList<>();



	public static ArrayList<Transaction> getMembers(int accNo) {

		ArrayList<Transaction> mem = new ArrayList<>();

		for (int i = 0; i < transList.size(); i++) {

			if (accNo == transList.get(i).getAccNo())

				mem.add(transList.get(i));

		}

		return mem;

	}



	public static double getAmountOnDate(LocalDate date, ArrayList<Transaction> want, double bal) {

		for (int i = 0; i < want.size(); i++) {

			if (date.isBefore(want.get(i).getDateofTrans())) {

				if (want.get(i).getTypeofPay().equals("deposit"))

					bal -= want.get(i).getAmount();

				else

					bal += want.get(i).getAmount();

			}

		}

		return bal;

	}



	public static int getMonths(LocalDate date, LocalDate tod) {

		if (date.getDayOfMonth() > 10)

			date.plusMonths(1);

		if (date.getYear() == tod.getYear())

			return tod.getMonthValue() - date.getMonthValue();

		else {

			int x = tod.getMonthValue() + 12 - date.getMonthValue();

			if (x >= 6)

				return 6;

			else

				return x;

		}

	}



	public static double calInterest(Account obj) {

		LocalDate tod = LocalDate.of(2023, 07, 01);

		ArrayList<Transaction> use = getMembers(obj.getAccNo());

		int noMonths = getMonths(obj.getOpDate(), tod);

		LocalDate fromDate = tod.minusMonths(noMonths);

		double balance = getAmountOnDate(fromDate, use, obj.getBal());

		double totalInterest = 0;

		while (noMonths > 0) {

			double monInterest = 0;

			double minBal = balance;

			for (int i = 0; i < use.size(); i++) {

				LocalDate st = use.get(i).getDateofTrans();

				if (st.isAfter(fromDate) && st.isBefore(fromDate.plusMonths(1))) {

					if (use.get(i).getTypeofPay().equals("deposit"))

						balance += use.get(i).getAmount();

					else

						balance -= use.get(i).getAmount();

					if (st.getDayOfMonth() > 9) {

						if (balance < minBal)

							minBal = balance;

					}

				}

			}

			monInterest = minBal * (0.00375);

			totalInterest += monInterest;

			noMonths--;

		}

		return totalInterest;

	}



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		try {

			BufferedReader br = new BufferedReader(new FileReader("D:\\TEST1\\Interest\\src\\bank\\account"));

			String line = "";

			while ((line = br.readLine()) != null) {

				String[] s = line.split(",");

				accList.add(new Account(s[0], s[1], s[2], s[3]));

			}

			br.close();

		} catch (IOException ae) {

			ae.printStackTrace();

		}



		try {

			BufferedReader br1 = new BufferedReader(new FileReader("D:\\TEST1\\Interest\\src\\bank\\transaction"));

			String line1 = "";

			while ((line1 = br1.readLine()) != null) {

				String[] s = line1.split(",");

				transList.add(new Transaction(s[0], s[1], s[2], s[3], s[4]));

			}

			br1.close();

		} catch (IOException ae) {

			ae.printStackTrace();

		}



		// Main ma = new Main();

		for (int i = 0; i < accList.size(); i++) {

			if (accList.get(i).getType().equals("savings account")) {

				System.out.println(Main.calInterest(accList.get(i)));

			}

		}

	}

			}
