package class1_1.Switch;

import java.util.*;

public class Switch_Class {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Class = sc.nextInt();
		switch(Class) {
			case 1:
				System.out.println("뉴미디어 소프트웨어과");
				break;
			case 2:
				System.out.println("뉴미디어 소프트웨어과");
				break;
			case 3:
				System.out.println("뉴미디어 웹솔루션과");
				break;
			case 4:
				System.out.println("뉴미디어 웹솔루션과");	
				break;
			case 5:
				System.out.println("뉴미디어 디자인과");
				break;
			case 6:
				System.out.println("뉴미디어 디자인과");
				break;
			default :
				System.out.println("잘못 입력하였습니다.");
		}
	}
}