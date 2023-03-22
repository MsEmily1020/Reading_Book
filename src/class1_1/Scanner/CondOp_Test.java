package class1_1.Scanner;

import java.util.Scanner;

public class CondOp_Test {
	public static void main(String args[]) { 
		Scanner sc = new Scanner(System.in);

		System.out.print("정수입력 : ");
		int num = sc.nextInt();

		String result = (num % 2 == 0) ? "짝수" : "홀수";
		System.out.println(num + "은(는) " + result + "입니다.");
	}
}