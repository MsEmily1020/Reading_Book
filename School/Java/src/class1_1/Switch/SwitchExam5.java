package class1_1.Switch;

import java.util.Scanner;

public class SwitchExam5 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 : ");
		int classroom = sc.nextInt();
		
		switch(classroom) {
			case 1 : case 2:
				System.out.println("뉴미디어소프트웨어과");
				break;
			case 3 : case 4:
				System.out.println("뉴미디어웹솔루션과");
				break;
			case 5: case 6:
				System.out.println("뉴미디어디지인과");
				break;
			default :
				System.out.println("존재하지 않는 학급입니다.");
		}
	}
}