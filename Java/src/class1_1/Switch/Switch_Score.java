package class1_1.Switch;

import java.util.*;

public class Switch_Score {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		switch(score/10) {
			case 10:
			case 9:
				System.out.println("A입니다.");
				break;
			case 8:
				System.out.println("B입니다.");
				break;
			case 7:
				System.out.println("C입니다.");
				break;
			default :
				System.out.println("잘못 입력하였습니다.");
				break;
		}
	}
}