package class1_1.Method;

import java.util.Scanner;

public class Test1206 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.print("얼마를 들고 가시겠습니까: ");
		int change = sc.nextInt();
		while(true) {
			System.out.print("과일 갯수를 입력하세요: ");
			int fruitNum = sc.nextInt();
	
			if(fruitNum == 0) break;

			System.out.print("과일 종류를 입력하세요: ");
			String fruitType = sc.next();

			change = getPrice(fruitType, fruitNum, change);
		}

		if(change < 0) System.out.println("구입불가");
		else System.out.println("거스름돈 : " + change + "원");
		
	}
	public static int getPrice(String fruitType, int fruitNum, int money) {
		int change = 0;
		switch(fruitType) {
			case "토마토" :
				change = money-(1000 * fruitNum);
				break;
			case "사과" :
				change = money-(1500 * fruitNum);
				break;
			case "수박" :
				change = money-(7000 * fruitNum);
				break;
		}
		return change;
	}
}