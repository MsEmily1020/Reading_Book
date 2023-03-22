package class1_1.Final;

import java.util.Scanner;

public class Constant2_1206 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		final double pi = 3.14;
		System.out.print("������ : ");
		int r = sc.nextInt();

		double d = 2 * pi * r;
		System.out.println("반지름 " + r + "인 원의 둘레 : " + d);
		double area = pi * r * r;
		System.out.println("반지름 " + r + "인 원의 넓이 : " + area);
	}
}
		
		 