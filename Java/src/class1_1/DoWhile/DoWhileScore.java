package class1_1.DoWhile;

import java.util.Scanner;

public class DoWhileScore {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0, count = 0;

		do {
			System.out.print("점수 입력 : ");
			int score = sc.nextInt();
			if(score == 0) break;
			sum += score;
			count++;
		} while(count > 0);
	
		System.out.println("점수의 합 : " + sum);
		System.out.println("평균 : " + (double)sum/count);
	}
}