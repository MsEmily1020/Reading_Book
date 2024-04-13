package class1_1.For;

public class star_01 {
	public static void main(String args[]) {
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
}