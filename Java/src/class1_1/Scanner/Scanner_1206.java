package class1_1.Scanner;

import java.util.Scanner;

public class Scanner_1206 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.print("사각형의 밑면 : ");
		int a = sc.nextInt();
		System.out.print("사각형의 높이 : ");
		int b = sc.nextInt();

		int s = a * b;
		System.out.println("사각형의 넓이 : " + s);
	}
}