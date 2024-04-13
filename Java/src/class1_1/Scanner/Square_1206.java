package class1_1.Scanner;

import java.util.Scanner;

public class Square_1206 {
	public static void main(String args[]) {
		Scanner k = new Scanner(System.in);
		int a, b, c;
		a = k.nextInt();
		b = k.nextInt();
		c = a * b;
		System.out.println("가로길이 : " + a + ", " + "세로길이 : " + b + ", " + "넓이 : " + c);
		System.out.printf("가로길이 : %d", a);
	}
}