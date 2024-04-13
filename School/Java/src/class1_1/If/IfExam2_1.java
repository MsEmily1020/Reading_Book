package class1_1.If;

import java.util.Scanner;

public class IfExam2_1{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("ex) a + b : ");
		int a = sc.nextInt();
		char op = sc.next().charAt(0);
		int b = sc.nextInt();

		if(op == '+') System.out.println(a + " + " + b + " = " + (a+b));
		else if(op == '-') System.out.println(a + " - " + b + " = " + (a-b));
		else if(op == '*') System.out.println(a + " * " + b + " = " + (a*b));
		else if(op == '/') System.out.println(a + " / " + b + " = " + (a/b));
		else System.out.println("사칙연산자가 아닙니다.");
	}
}