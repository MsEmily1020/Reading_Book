package class1_1.For;

import java.util.Scanner;

public class For_Test4 {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		System.out.print("n 입력 : ");
		int n  = sc.nextInt();

		double sum = 1.0;
		System.out.print(1);
		for(int i = 2; i <= n; i++) {
			System.out.print(" + (1/" + i + ")");
			sum += (double)1/i;
			if(i % 5 == 0) System.out.println();
		}

		System.out.printf("= %.2f\n", sum);
	}
}