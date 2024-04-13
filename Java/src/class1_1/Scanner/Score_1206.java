package class1_1.Scanner;

import java.util.Scanner;

public class Score_1206 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.print("국어점수 : ");
		int kor = sc.nextInt();
		System.out.print("영어점수 : ");
		int eng = sc.nextInt();
		System.out.print("수학점수 : ");
		int math = sc.nextInt();
		System.out.print("자바점수 : ");
		int java = sc.nextInt();

		int sum = kor + eng + math + java;
		double avg = (double)sum / 4;

		System.out.println("합계 : " + sum);
		System.out.printf("평균 : %8.3f", avg);
	}
}