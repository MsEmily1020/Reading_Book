package codingtest;

import java.util.Scanner;

public class MergeSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] A = new int[5];
		int[] B = new int[5];
		
		//입력
		System.out.print("첫번째 배열의 데이타 : ");
		for(int i = 0; i < A.length; i++) A[i] = sc.nextInt();
		
		System.out.print("두번째 배열의 데이타 : ");
		for(int i = 0; i < B.length; i++) B[i] = sc.nextInt();
		
		//병합
		int[] C = new int[A.length + B.length];
		for(int i = 0; i < A.length; i++) {
			C[i] = A[i];
			C[i + 5] = B[i];
		}
		
		//정렬
		for(int i = 0; i < C.length - 1; i++)
			for(int j = i + 1; j < C.length; j++)
				if(C[i] > C[j]) {
					int tmp = C[i];
					C[i] = C[j];
					C[j] = tmp;
				}
		
		//중복제거
		System.out.print("병합된 배열의 데이타 : ");
		Loop : for(int i = 0; i < C.length; i++) {
			for(int j = i + 1; j < C.length; j++)
				if(C[i] == C[j]) continue Loop; 
			System.out.print(C[i] + " ");
		}
	}
}
