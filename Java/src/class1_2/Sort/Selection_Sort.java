package class1_2.Sort;

import java.util.Scanner;

public class Selection_Sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇 개의 데이터를 입력하시겠습니까? ");
		int[] arr = new int[sc.nextInt()];

		System.out.print("정렬 전 : ");
		for(int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();

		for(int i = 0; i < arr.length - 1; i++)
			for(int j = i + 1; j < arr.length; j++)
				if(arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}

		System.out.print("정렬 후 : ");
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}