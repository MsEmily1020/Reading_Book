package codingtest;

import java.util.Scanner;

public class ReverseStr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("영문자 입력 : ");
		String str = sc.nextLine();
		
		System.out.print("변환된 문자 : ");
		for(int i = str.length() - 1; i >= 0; i--) 
			System.out.print(str.charAt(i));
	}
}