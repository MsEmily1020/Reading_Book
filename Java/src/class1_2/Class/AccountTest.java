package class1_2.Class;

import java.util.Scanner;

public class AccountTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Account[] acc = new Account[5];

		while(true) {
			System.out.println("1. 계좌생성   2. 입금   3.출금   4. 잔액조회   5. 계좌전체조회   0.종료");
			System.out.print("메뉴 입력 : ");
			int menu = sc.nextInt();

			int foundAcc = 0;
			switch(menu) {
			case 1: //계좌생성
				System.out.print("계좌를 입력하세요 : ");
				acc[Account.cnt] = new Account(sc.next());
				break;

			case 2: //입금
				System.out.print("계좌를 입력하세요 : ");
				String temp = sc.next();

				for(int i = 0; i < Account.cnt; i++) {
					if(temp.equals(acc[i].getAccNum())) {
						foundAcc = i;
						break;
					}
				}
				System.out.print("입금액을 입력하세요 : ");
				acc[foundAcc].deposit(sc.nextInt());
				break;

			case 3: //출금
				System.out.print("계좌를 입력하세요 : ");
				temp = sc.next();
				for(int i = 0; i < Account.cnt; i++) {
					if(temp.equals(acc[i].getAccNum())) {
						foundAcc = i;
						break;
					}
				}

				System.out.print("출금액을 입력하세요 : ");
				acc[foundAcc].withdraw(sc.nextInt());
				break;

			case 4: //잔액조회
				System.out.print("계좌를 입력하세요 : ");
				temp = sc.next();
				for(int i = 0; i < Account.cnt; i++) {
					if(temp.equals(acc[i].getAccNum())) {
						foundAcc = i;
						break;
					}
				}

				System.out.println(acc[foundAcc].toString());
				break;

			case 5: //계좌전체조회
				for(int i = 0; i < Account.cnt; i++) {
					System.out.println(acc[i].toString());
				}
				break;

			case 0: //종료
				System.out.println("프로그램을 종료합니다.");
				return;

			default: System.out.println("메뉴 선택 오류입니다.");
			}	
			System.out.println();
		}
	}
}