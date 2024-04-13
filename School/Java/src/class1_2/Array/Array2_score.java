package class1_2.Array;

import java.util.Scanner;

public class Array2_score {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] score = new int[5][3];

		String[] str = {"완성도", "창의성", "이해도"};
		//입력
		for(int i = 0; i < score.length; i++) {
			System.out.println("--" + (i+1) + "번째 조--");
			for(int j = 0; j < score[i].length; j++) {
				System.out.print(str[j] + " : ");
				score[i][j] = sc.nextInt();
			}
		}

		//처리(점수)
		int[] sum = new int[score.length];
		for(int i = 0; i < score.length; i++)
			for(int j = 0; j < score[i].length; j++)
				sum[i] += score[i][j];

		//처리(최고팀)
		int max = sum[0], idx = 1;
		for(int i = 1; i < sum.length; i++)
			if(max < sum[i]) { max = sum[i]; idx = (i + 1); }

		//출력
		System.out.println("최고팀 : " + idx + "번째 팀 -> 점수 : " + max);
	}
}