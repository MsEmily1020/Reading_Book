package class1_1.For;

public class For_Test3 {
	public static void main(String args[]){
		double sum = 1.0;
		System.out.print(1);
		for(int i = 2; i <= 100; i++) {
			System.out.print(" + (1/" + i + ")");
			sum += (double)1/i;
			if(i % 5 == 0) System.out.println();
		}

		System.out.printf("= %.2f", sum);
	}
}
			