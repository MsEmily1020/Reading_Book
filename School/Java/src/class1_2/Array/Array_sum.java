package class1_2.Array;

public class Array_sum {
	public static void main(String[] args) {
		int[] arr = new int[100];

		int sum = 0, tog = -1; 
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
			tog *= -1;
			sum += arr[i] * tog;

			if(arr[i] % 2 == 0) System.out.print(" - ");
			else
				if(i != 0) System.out.print(" + "); 

			System.out.print(arr[i]);
		}

		System.out.print(" = " + sum);
	}
}