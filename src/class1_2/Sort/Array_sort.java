package class1_2.Sort;

import java.util.Scanner;

public class Array_sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] score = new int[10];

		for(int i = 0; i < score.length; i++)
			do { 
				System.out.print((i + 1) + "번째 점수 입력 : ");
				score[i] = sc.nextInt();
			} while(score[i] < 0 || score[i] > 100);
		
		System.out.print("정렬 전 : ");
		for(int i = 0; i < score.length; i++)
			System.out.print(score[i] + " ");

		for(int i = 0; i < score.length - 1; i++) {
			for(int j = i + 1; j < score.length; j++)
				if(score[i] > score[j]) {
					int tmp = score[i];
					score[i] = score[j];
					score[j] = tmp;
				}
		}
		
		System.out.println();
		System.out.print("정렬 후 : ");
		for(int i = 0; i < score.length; i++)
			System.out.print(score[i] + " ");
	}
}