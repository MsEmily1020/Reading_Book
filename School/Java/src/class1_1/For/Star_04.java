package class1_1.For;

import java.util.Scanner;

public class Star_04 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("줄 수 입력 : ");
		int line = sc.nextInt();

		for(int i = 5; i >= 1; i--) {
			for(int j = 1; j < i; j++) 
				System.out.print("  ");
			for(int k = 1; k <= 6-i; k++) 
				System.out.print(" *");

			for(int l = 2; l <= 6 - i; l++)
				System.out.print(" *");

			System.out.print("\n");

		}
	}
}