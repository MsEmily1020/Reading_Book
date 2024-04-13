package class1_1.If;

import java.util.*;

public class If_Teacher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("선생님:");
		int teacher = sc.nextInt();
	
		if(teacher == 1) {
			System.out.println("정혜선 선생님");
		}

		else if(teacher == 2) {
			System.out.println("민주리 선생님");	
		}

		else if(teacher == 3) {
			System.out.println("김윤환 선생님");
		} 

		else if(teacher == 4) {
			System.out.println("김영철 선생님");
		}

		else if(teacher == 5) {
			System.out.println("이호연 선생님");
		}

		else if(teacher == 6) {
			System.out.println("김보경 선생님");	
		}

		else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}
}