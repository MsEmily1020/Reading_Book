package codingtest;

import java.util.Scanner;

public class Average {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double avg = 0;
		for(int i = 1; i <= 5; i++) {
			System.out.print(i + "번째 수 : ");
			avg += sc.nextInt();
		}
		
		System.out.printf("평균 : %.2f", avg / 5);
	}
}
