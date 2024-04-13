package class1_2.Array;

public class ArrayExam14 {
	public static void main(String[] args) {
		int[][] arr = new int[4][4];
		
		int cnt = 1;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < i + 1; j++) {
				arr[i][j] = cnt++; 
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < i + 1; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
		/*
		int[][] arr = new int[5][];
		int num = 1;
		for(int i = 0; i < arr.length; i++)
			arr[i] = new int[5 - i];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = num++;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.printf("%5d", arr[i][j]);
			}
			System.out.println();
		}
		*/
	}
}