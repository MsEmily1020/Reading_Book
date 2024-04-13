package class1_1.If;

import java.util.*;

public class If_Elseif_Else_Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("현금을 입력하세요 : ");
		int money = sc.nextInt();

		if (money >= 30000) {
			if(money >= 50000) {
				System.out.println("모범택시를 탑니다.");
			} 

			else {
				System.out.println("일반택시를 탑니다.");
			}
		}
 
		else if(money >= 10000) {
			System.out.println("버스를 탑니다.");
		} 

		else {
			System.out.println("걸어갑니다.");
		}
	}
}