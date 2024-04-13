package class1_1.If;

import java.util.Scanner;

public class Max {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
	
		System.out.print("첫 번째 수 입력 : ");
		int first = sc.nextInt();
		System.out.print("두 번째 수 입력 : ");
		int second = sc.nextInt();

		if(first > second) {
			System.out.println(first + "와 "+ second + " 중 큰 수는 " + first + "입니다.");
		} 

		else {
			System.out.println(first + "와 "+ second + " 중 큰 수는 " + second + "입니다.");
		}
	}
}