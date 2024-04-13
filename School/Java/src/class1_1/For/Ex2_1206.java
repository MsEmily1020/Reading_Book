package class1_1.For;

public class Ex2_1206 {
	public static void main(String args[]) {
		for(int i = 3; i >=1; i--) {
			for(int j = 0; j < 3 - i; j++) {
				System.out.print(" ");
			}
			
			for(int k = 1; k <= i*2-1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}