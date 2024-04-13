package class1_2.Sort;

import java.util.Scanner;

public class Bubble_Sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("몇 개의 데이터를 입력하시겠습니까? ");
		int[] arr = new int[sc.nextInt()];

		System.out.print("정렬 전 : ");
		for(int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();

		for(int i = 0; i < arr.length - 1; i++)
			for(int j = 0; j < arr.length - i - 1; j++)
				if(arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}

		System.out.print("정렬 후 : ");
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}