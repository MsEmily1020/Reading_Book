package class1_2.Array;

public class ForEx2 {
	public static void main(String[] args) {
		int[] arr = new int[100];
		
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
			
			if(arr[i] == 100) System.out.print(arr[i]);
			else System.out.print(arr[i] + "+");
			
			sum += arr[i];
		}
		
		System.out.print("=" + sum);
	}
}
