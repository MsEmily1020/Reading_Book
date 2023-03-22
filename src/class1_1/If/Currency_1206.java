package class1_1.If;

import java.util.Scanner;

public class Currency_1206 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.print("금액을 입력하시오 >> ");
		int money = sc.nextInt();
		int sum = 0;
	
		if(money >= 50000) {
			sum = money * 1/50000;
			System.out.println("오만원권 " + sum + "매");
			
		}
		
		else {
			System.out.println("오만원권 0매");

		}

		if((money%50000) >= 10000) {
			sum = (money%50000)* 1/10000;
			System.out.println("만원권 " + sum + "매");
	
		}

		else {
			System.out.println("만원권 0매");

		}

		if((money%60000) >= 5000) {
			sum = (money%60000) * 1/5000;
			System.out.println("오천원권 " + sum + "매");
	
		}

		else {
			System.out.println("오천원권 0매");

		}

		if((money%65000-60000) >= 1000) {
			sum = (money % 65000-60000) * 5/5000;
			System.out.println("천원권 " + sum + "매");

		}

		else {
			System.out.println("천원권 0매");

		}

		if((money % 66000 - 65000) >= 500) {
			sum = (money % 66000 - 65000) * 1/500;
			System.out.println("오백원권 " + sum + "매");
		}

		else {
			System.out.println("오백원권 0매");

		}

		if((money % 66500 - 66000) >= 100) {
			sum = (money % 66500 - 66000) * 1/100;
			System.out.println("백원권 " + sum + "매");
		}

		else {
			System.out.println("백원권 0매");
		}

		if((money % 66600 - 66500) >= 50) {
			sum = (money % 66600 - 66500) * 1/50;
			System.out.println("오십원 " + sum + "개");
		}

		else {
			System.out.println("오십원 0개");
		}

		if((money % 66650 - 66600) >= 10) {
			sum = (money % 66650 - 66600) * 1/10;
			System.out.println("십원 " + sum + "개");
		}

		else {
			System.out.println("십원 0개");

		}

		if((money % 66660 - 66600) >= 5) {
			sum = (money % 66660 - 66600) * 1/5;
			System.out.println("오원 " + sum + "개");
		}

		else {
			System.out.println("오원 0개");
		}

		if((money % 66665 - 66660) >= 1) {
			sum = (money % 66665 - 66660) / 1;
			System.out.println("일원 " + sum + "개");

		}

		else {
			System.out.println("일원 0개");
		}
	}
}
			
		
	
