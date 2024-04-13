package class1_1.Scanner;

import java.util.Scanner;

public class Str_1206 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자를 입력하세요: ");
		String name1 = sc.nextLine();
		System.out.print("문자를 입력하세요: ");
		String name2 = sc.nextLine();

		System.out.println(name2 + " " + name1);
	}
}

		