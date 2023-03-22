package class1_1.Switch;

import java.util.Scanner;

public class SwitchOp {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.print("수식 입력(수와 연산자 사이는 공백을 둘 것) : ");
		int first = sc.nextInt();
		char op =  sc.next().charAt(0);
		int second = sc.nextInt();
		
		System.out.print(first + " " + op + " " + second + " = ");
		switch(op) {
			case '+' : 
				System.out.println(first + second);
				break;
			case '-' :
				System.out.println(first - second);
				break;
			case '*' :
				System.out.println(first * second);
				break;
			case '/' :
				System.out.println(first / second);
				break;
			default : 
				System.out.println("사칙연산자가 아닙니다.");
		}
	}
}
