package class1_1.Array;

import java.util.Scanner;

public class Array_AtoZ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("어디까지 출력하시겠습니까 : ");
		char ch = sc.next().charAt(0);

		int alpabet = (ch >= 'A' && ch <= 'Z') ? 'A'-1 : 'a'-1;

		char[] chArr = new char[(int)ch - alpabet];
		for(int i = 0; i < chArr.length; i++)
			chArr[i] = (char)(i + 'A');

		System.out.print("대문자 : ");
		for(int i = 0; i < chArr.length; i++)
			System.out.print(chArr[i]);

		System.out.println();
		System.out.print("소문자 : ");
		for(int i = 0; i < chArr.length; i++) 
			System.out.print((char)(chArr[i] + ('a' - 'A')));
	}
}