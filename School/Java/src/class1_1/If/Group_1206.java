package class1_1.If;

import java.util.Scanner;

public class Group_1206 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자입력: ");
		int num = sc.nextInt();

		if(num < 0 && num % 2 == 0) {
			System.out.println("minus");
			System.out.println("even");
		}

		else if(num < 0 && num % 2 != 0) {
			System.out.println("minus");
			System.out.println("odd"); 
		}

		else if(num > 0 && num % 2 == 0) {
			System.out.println("plus");
			System.out.println("even");
		}

		else {
			System.out.println("plus");
			System.out.println("odd");
		}
	}
}
		

		