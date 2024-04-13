package class1_1.If;

import java.util.Scanner;

public class MinOfThree {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.print("첫 번째 수 입력 : ");
		int first = sc.nextInt();
		System.out.print("두 번째 수 입력 : ");
		int second = sc.nextInt();
		System.out.print("세 번째 수 입력 : ");
		int third = sc.nextInt();

		System.out.print(first + "와 " + second + "와 " + third +" 중 제일 작은 수는 ");
		int min;
		
		if(first < second) {
			if(first < third) min = first;
			else min = third;
		} else {
			if(second < third) min = second;
			else min = third;
		}

		System.out.println(min + "입니다.");
	}
}
			
