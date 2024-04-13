package codingtest;

import java.util.Scanner;

public class SalesVol {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] sales = new int[3][4];
		int[] year = {2019, 2020, 2021};
		//입력
		for(int i = 0; i < sales.length; i++) {
			System.out.print(year[i] + "년도 : ");
			for (int j = 0; j < sales[i].length; j++)
				sales[i][j] = sc.nextInt();
		}
		
		//출력
		System.out.println("\t  1사분기\t 2사분기\t 3사분기\t 4사분기\t 연간판매량  누적판매량");
		int total = 0; //누적판매량
		for(int i = 0; i < sales.length; i++) {
			System.out.print(year[i] + "년도 : ");
			int sum = 0; //연간판매량
			for(int j = 0; j < sales[i].length; j++) {
				System.out.printf("%4d\t", sales[i][j]);
				sum += sales[i][j];
			}
			total += sum;
			System.out.printf("%7d\t%10d",sum, total);
			System.out.println();
		}
	}
}
