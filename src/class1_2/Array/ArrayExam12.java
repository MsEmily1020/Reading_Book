package class1_2.Array;

public class ArrayExam12 {
	public static void main(String[] args) {
		int[][] arr = new int[4][4];
		
		System.out.println("-------- 자바실행 --------");
		for(int i = 0; i < arr.length; i++)
			for(int j = 0; j < arr[0].length; j++)
				arr[i][j] = 1;

		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++)
				System.out.print(arr[i][j] + "\t");
			System.out.println();	
		}
		
		System.out.println();
		System.out.println("출력 완료 (0초 경과) - 정상 종료");
	}
}