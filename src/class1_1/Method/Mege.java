package class1_1.Method;

import java.util.Scanner;

public class Mege {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = add(a, b);

		System.out.println(c);
	}

	static int add(int x, int y) {
		return x + y;
	}
}