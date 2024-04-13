package class1_1.If;

import java.util.Scanner;

public class Ex1_1206 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.print("총 이수학점 입력 :");
		int sum_grade = sc.nextInt();
		System.out.print("TOEIC점수 입력 :");
		int toeic = sc.nextInt();

		if(sum_grade >= 140)
			if(toeic >= 700) System.out.print("졸업을 축하합니다.");
			else System.out.print("아쉽지만 수료하셨습니다.");
		else
			System.out.print("졸업이 불가합니다.");
	}
}