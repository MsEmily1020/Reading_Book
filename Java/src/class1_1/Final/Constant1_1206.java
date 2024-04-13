package class1_1.Final;

import java.util.Scanner;

public class Constant1_1206 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.print("시험점수 : ");
		int point = sc.nextInt();

		final int point1 = 85;

		System.out.println(point + "-" + point1 + "=" + (point-point1));
	}
}