package codingtest;

import java.util.Scanner;

class Money {
	String account;
	int total = 0;

	Money(String account) {
		this.account = account;
	}

	void deposit(int money) {
		this.total += money;
	}

	void withdraw(int money) {
		if(this.total - money < 0) { System.out.println("출금하려는 계좌의 잔액이 부족하여 출금이 불가능합니다"); return; }
		this.total -= money;
	}

	void print() {
		System.out.println("계좌번호 " + this.account + "의 현재 잔액 : " + this.total);
	}
}

public class Account {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Money[] m = new Money[3];
		System.out.println("======================================");
		for(int i = 0; i < 3; i++) {
			System.out.print("계좌번호 입력 : ");
			m[i] = new Money(sc.next());
			m[i].print();
			System.out.println();

			System.out.print("입금할 금액 : ");
			m[i].deposit(sc.nextInt());
			m[i].print();
			System.out.println();

			System.out.print("출금할 금액 : ");
			m[i].withdraw(sc.nextInt());
			m[i].print();
			
			if(i != 2) System.out.println("======================================");
		}

		System.out.println();
		System.out.println("======================================");
		System.out.println("계좌번호\t\t\t잔액");
		System.out.println("======================================");
		for(int i = 0; i < 3; i++)
			System.out.printf("%s\t\t  %10d\n", m[i].account, m[i].total);

		System.out.println("======================================");

	}
}
