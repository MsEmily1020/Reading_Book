package class1_1.Switch;

import java.util.*;

public class Switch_Teacher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int teacher = sc.nextInt();
		
		switch(teacher) {
			case 1:
				System.out.println("정혜선 선생님");	
				break;
			case 2:
				System.out.println("민주리 선생님");	
				break;
			case 3:
				System.out.println("김윤환 선생님");
				break;
			case 4:
				System.out.println("김영철 선생님");
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
		}
	}
}