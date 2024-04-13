package class1_1.For;

import java.util.Scanner;

public class For_Test6 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자 입력 ==> ");
		char C = sc.next().charAt(0);

		for(int i = 1; i <= (int)C; i++) {
			for(char j = 65; j <= i*2-1; j++)
				System.out.print(j);
			System.out.println();
		}
	}
}
		