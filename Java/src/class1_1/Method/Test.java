package class1_1.Method;

import java.util.Scanner;

public class Test {
	public static void main(String args[]) {
		//점수입력 메서드
		int a = keyInput();
		int b = keyInput();
		int c = keyInput();	
		//합계, 평균, 평균의 성취도 계산 메서드
		getResult1(a, b, c);
		//3등 과목
		getResult2(a, b, c);
	}

	static int keyInput() {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		return sc.nextInt();	
	}

	static void getResult1(int in1, int in2, int in3) {
		int sum = in1 + in2 + in3;
		int avg = sum / 3;
		char res;
		switch(avg / 10) {
			case 10: case 9:
				res = 'A'; break;
			case 8:
				res = 'B'; break;
			case 7:
				res = 'C'; break;
			default:
				res = 'D'; break;
		}

		System.out.println("== 성적 처리 결과 ==");
		System.out.println("합계 : " + sum + "\t평균 : " + avg);
		System.out.println("성취도 : " + res);	
	}

	static void getResult2(int a, int b, int c) {
		int min, num;
		min = (a < b) ? ((a < c) ? a : c) : ((b < c) ? b : c);
		num = (a < b) ? ((a < c) ? 1 : 3) : ((b < c) ? 2 : 3);
		System.out.println("== 노력이 필요한 교과 ==");
		System.out.println("과목 : " + num + "\t점수 : " + min);
	}
}