package class1_1.Switch;

import java.util.*;

public class Switch_Age {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 입력:");
		int age = sc.nextInt();

		switch(age/10) {
			case 9:
			case 8:
			case 7:
			case 6:
				System.out.println("노인입니다.");
				break;
			case 5: 
			case 4:
			case 3:
			case 2:
				System.out.println("청년입니다.");
				break;
			case 1:
				System.out.println("학생입니다.");
				break;
			case 0:
				System.out.println("아이입니다.");
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
		}
	}
}