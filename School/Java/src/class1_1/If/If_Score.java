package class1_1.If;

import java.util.*;

public class If_Score {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수:");
		int score = sc.nextInt();

		if(score >= 90) {
			System.out.println("A입니다.");
		} 

		else if(score >= 80) {
			System.out.println("B입니다.");
		}
	
		else if(score >= 70) {
			System.out.println("C입니다.");
		}
	
		else {
			System.out.println("D입니다.");
		}
	}
}