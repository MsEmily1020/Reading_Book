package class1_1.Scanner;

import java.util.Scanner;

public class Integer_1206 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 3개 입력 : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int sum = a + b + c;
		double avg = (double)sum/3;

		System.out.println("합: " + sum);
		System.out.printf("평균: %.2f", avg);
	}
}

		