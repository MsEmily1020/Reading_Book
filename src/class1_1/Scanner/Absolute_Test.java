package class1_1.Scanner;

import java.util.Scanner;

public class Absolute_Test {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
	
		System.out.print("정수 입력 : ");
		int A = sc.nextInt();

		int result = (A > 0) ? A : ~A + 1;
		// int result = (A > 0) ? A : A * -1;
		System.out.println(A + "의 절대값은 " + result + "입니다.");
	}
}