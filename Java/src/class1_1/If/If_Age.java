package class1_1.If;

import java.util.*;

public class If_Age {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int age;

		do {
			System.out.print("나이 입력:");
			age = sc.nextInt();
			if(age >= 100) {
				System.out.println("나이가 100 초과하였습니다.");
			}

		} while(age >= 100);
		

		if(age >= 60 && age < 100) {
			System.out.println("노인입니다.");
		}
		
		else if(age >= 20) {
			System.out.println("청년입니다.");
		}

		else if(age >= 10) {
			System.out.println("학생입니다.");
		}

		else if(age >= 0) {
			System.out.println("아이입니다.");
		}
		
		else {
			System.out.println("잘못된 입력입니다.");
		}
	}
}