package class1_2.Array;

import java.util.Scanner;

public class Array_max {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] score = new int[10];
		
		for(int i = 0; i < score.length; i++) {
			System.out.print((i + 1) + "번째 점수 입력 : ");
			score[i] = sc.nextInt();
		}
		
		int max = score[0];
		
		for(int i = 1; i < score.length; i++)
			if(max < score[i]) max = score[i];
		
		System.out.println("최댓값은 : " + max);
	
	}
}