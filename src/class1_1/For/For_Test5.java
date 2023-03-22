package class1_1.For;

public class For_Test5 {
	public static void main(String args[]) {
		System.out.print(1);
		int sum = 1;
		for(int i = 2; i <= 10; i++) {
			System.out.print(" + (" + i + " * " + i + ")");
			sum += i*i;
		}
		System.out.println(" = " + sum);
	}
}