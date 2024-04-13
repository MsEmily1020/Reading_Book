package class1_1.For;

import java.util.Scanner;

public class FlagSum {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("ex) 1 - 2 + 3 - 4 + 5... -n ->  n 입력 : ");
		int n = sc.nextInt();

		int i, sum = 0;
		for(i = 1; i <= n; i++)
			if(i % 2 == 0) {
				if(i != n) System.out.print(" - "+ i + " + ");
				else System.out.print(" - " + i);
				sum -= i;
			}
			
			else {
				System.out.print(i);
				sum += i;
			}
		System.out.println(" = " + sum);
	}
}