package class1_2.Class;

public class Account {
	private String accountNum;
	private int balance;
	static int cnt;
	static final double interest = 0.02;

	Account(String account) {
		this.accountNum = account;
		cnt++;
		System.out.println(toString());
	}

	void deposit(int plus) {
		this.balance += plus;
		System.out.println(toString());
	}

	void withdraw(int minus) {
		if(balance - minus < 0) System.out.println("현재 출금할 수 없는 금액입니다.");
		else this.balance -= minus;

		System.out.println(toString());
	}

	public String toString() {
		return "현재 계좌번호" + this.accountNum + "의 잔액은 " + this.balance + "원입니다.";
	}

	//get : return 타입o
	String getAccNum() {
		return accountNum;
	}

	//set : return 타입x
	void setAccBalance(int balance) {
		this.balance = balance;
	}
	
	int fixedDeposit(int year, int price) {
		return (int)(price + price * interest * year);
	}
}