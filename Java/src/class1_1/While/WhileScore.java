package class1_1.While;
import java.util.Scanner;

public class WhileScore {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0, count = 0;

		while(true) {
			System.out.print("점수 입력 : ");
			int score = sc.nextInt();
			sum += score;
			
			if(score == 0) break;
			count++;
		}
	
		System.out.println("점수의 합 : " + sum);
		System.out.println("평균 : " + (double)sum/count);
	}
}