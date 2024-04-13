package class1_1.For;

import java.util.Scanner;

public class Gugudan {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("시작단 입력 : ");
		int start_dan = sc.nextInt();
		System.out.print("마지막 단 입력 : ");
		int finish_dan = sc.nextInt();
	
		for(int i = start_dan; i <= finish_dan; i++) {
			for(int j = 1; j <= 9; j++) {	
				System.out.println(i+"*" + j + "=" + i*j);
			}
			System.out.println("-----------");
		}
	}
}