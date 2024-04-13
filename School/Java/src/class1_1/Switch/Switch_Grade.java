package class1_1.Switch;

import java.util.*;

public class Switch_Grade {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char grade = sc.next().charAt(0);
		switch(grade) {
			case 'A':
				System.out.println("잘했습니다.");
				break;
			case 'B':
				System.out.println("잘했습니다.");
				break;
			case 'C':
				System.out.println("좀 더 노력하세요.");
				break;
			case 'D':
				System.out.println("좀 더 노력하세요.");	
				break;
			case 'F':
				System.out.println("다시 수강하세요.");
				break;
			default:
				System.out.println("잘못 입력하였습니다.");
				break;
		}
	}
}