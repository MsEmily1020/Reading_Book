package class1_1.For;

public class For_Test2 {
	public static void main(String args[]) {
		int cnt = 0;
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <=i; j++) { 
				cnt ++;
				System.out.printf("%02d", cnt);
			}
			System.out.println();
		}
	}
}