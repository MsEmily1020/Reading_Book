package class1_2.Array;

import java.util.Scanner;

public class ArrayScore {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		//점수입력 메서드
		System.out.print("몇 과목을 입력하시겠습니까?");
		int count = sc.nextInt();

		int[] score = new int[count];

		for(int i = 0; i < score.length; i++)
			score[i] = keyInput();

		//합계, 평균, 평균의 성취도 계산 메서드
		getResult1(score);

		//3등 과목
		int minIndex = getResult2(score);

		System.out.println("== 노력이 필요한 교과 ==");
		System.out.println("과목 : " + (minIndex + 1) + "번째 과목 \t점수 : " + score[minIndex]);
	}

	static int keyInput() {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		return sc.nextInt();	
	}

	static void getResult1(int[] score) {
		int sum = 0;
		for(int i = 0; i < score.length; i++)
			sum += score[i];

		int avg = sum / score.length;
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

	static int getResult2(int[] score) {
		int minNum = score[0];
		int idx = 0;

		for(int i = 1; i < score.length; i++) {
			if(score[i] < minNum) {
				idx = i; 
				minNum = score[idx];
			}
		}

		return idx;
	}
}