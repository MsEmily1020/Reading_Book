package codingtest;

import java.util.Scanner;

class CalculateClass {
	int a;
	int b;
	
	public CalculateClass(int n1, int n2) {
		this.a = n1;
		this.b = n2;
	}
	
	public String plus() {
		return Integer.toString(this.a + this.b);
	}
	
	public String minus() {
		return Integer.toString(this.a - this.b);
	}
	
	public String multiply() {
		return Integer.toString(this.a * this.b);
	}

	public String division() {
		return Double.toString((double)(this.a / this.b));
	}
	
	
	public void printResult() {
		System.out.println("===두수의 사칙연산 결과===");
		char[] op = {'+', '-', '*', '/'};
		String[] result = {plus(), minus(), multiply(), division()};
		for(int i = 0; i < 4; i++) System.out.println(this.a + " " + op[i] + " " + this.b + " = " + result[i]);
	}
}

public class Calculate {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("계산하고자 하는 첫번째 수 입력 : ");
		int n1 = scan.nextInt();
		System.out.print("계산하고자 하는 두번째 수 입력 : ");
		int n2 = scan.nextInt();
		
		CalculateClass c1 = new CalculateClass(n1, n2);
		c1.printResult();
	}
}
