package codingtest;

import java.util.Scanner;

public class GradeClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//학생 수
		System.out.print("학생수 입력 : ");
		int[][] score = new int[sc.nextInt()][3];

		//입력
		for(int i = 0; i < score.length; i++) {
			System.out.println();
			for(int j = 0; j < score[i].length; j++) {
				System.out.print("점수" + (j + 1) + " 입력 : ");
				while(true) {
					score[i][j] = sc.nextInt();
					if(score[i][j] >= 0 && score[i][j] <= 100) break;
					System.out.print("다시 입력하세요==> 점수" + (j + 1) + " 입력 : ");
				}
			}
		}

		//처리(최고점)
		int[] max = new int[score.length];
		for(int i = 0; i < score.length; i++) {
			max[i] = score[i][0];
			for(int j = 1; j < score[i].length; j++) {
				if(max[i] < score[i][j]) max[i] = score[i][j];
			}
		}

		//처리(평점)
		int[] grade = new int[score.length];
		for(int i = 0; i < max.length; i++) {
			switch(max[i] / 10) {
			case 10 : case 9:
				grade[i] = 5;
				break;
			case 8:
				grade[i] = 4;
				break;
			case 7:
				grade[i] = 3;
				break;
			case 6:
				grade[i] = 2;
				break;
			default:
				grade[i] = 1;
			}
		}
		
		//출력
		System.out.println();
		System.out.println("=============================================");
		System.out.println("순번\t점수1\t점수2\t점수3\t최고점\t평점");
		System.out.println("=============================================");
		for (int i = 0; i < score.length; i++) {
			System.out.printf("%3d", (i + 1));
			for (int j = 0; j < score[i].length; j++) {
				System.out.printf("\t%3d", score[i][j]);
			}
			System.out.printf("\t%3d\t%3d", max[i], grade[i]);
			System.out.println();
		}
		System.out.println("=============================================");
	}
}
