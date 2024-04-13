package class1_1.Switch;

import java.util.*;

public class Switch_Example {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력:");
		int num = sc.nextInt();
		
		switch(num) {
			case 1:
				System.out.println("1학년입니다.");
				break;
			case 2:
				System.out.println("2학년입니다.");
				break;
			case 3:
				System.out.println("3학년입니다.");
				break;
			default:
				System.out.println("그 외의 숫자입니다.");
		}
	}
}