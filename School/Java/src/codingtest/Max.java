package codingtest;

import java.util.Scanner;

public class Max {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[10];
		for(int i = 0; i < arr.length; i++) {
			do {
				System.out.print(i + 1 + "번째 수 : ");
				arr[i] = sc.nextInt();
			} while(arr[i] < 0);
		}
		
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(max < arr[i]) max = arr[i];
		}
		
		System.out.println("가장 큰 수 : " + max);
	}
}
