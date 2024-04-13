package class1_1.Scanner;

import java.util.Scanner;

public class Grade_1206 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		String str1 = "---------- 자바실행 ----------";
		System.out.println(str1);

		str1 = "이름\t과제\t보너스\t합계";
		System.out.println(str1);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("과제 : ");
		int a = sc.nextInt();
		System.out.print("보너스 : ");
		int b = sc.nextInt();
		int c = a + b;

		
		System.out.println(name + "\t" + a+ "\t" + b + "\t" + c);
		//System.out.printf("%1s \t %5d \t %5d \t %5d", name, a, b, c);
		
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.print("과제 : ");
		a = sc.nextInt();
		System.out.print("보너스 : ");
		b = sc.nextInt();
		c = a + b;

		
		System.out.println(name + "\t" + a+ "\t" + b + "\t" + c);
		
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.print("과제 : ");
		a = sc.nextInt();
		System.out.print("보너스 : ");
		b = sc.nextInt();
		c = a +b;
		
		System.out.println(name + "\t" + a + "\t" + b + "\t" + c);
		

	}
}
