package BankManagementSystem;

public class BankAccount {
	private long accountNo;
	private String name;
	private double balance;
	private double fdAmount;
	
	

	public long getAccountNo() {
		return accountNo;
	}



	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	public double getFdAmount() {
		return fdAmount;
	}



	public void setFdAmount(double fdAmount) {
		this.fdAmount = fdAmount;
	}



	public BankAccount(long accountNo, String name, double balance, double fdAmount) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
		this.fdAmount = 0;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
		System.out.println(amount+" has been deposited to your account");
	}
	
	public void withDraw(double amount) {
		this.balance -= amount;
		System.out.println(amount+ " has withdrawed from your account");
	}
	
	public void createFD(double amount) {
		this.balance -= amount;
		this.fdAmount += amount;
		System.out.println(amount+ " has FD done");
	}

}
