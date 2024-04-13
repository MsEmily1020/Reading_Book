package class1_1.For;

public class ForExam6_1 {
	public static void main(String args[]) {
		for(int i = 1; i <= 3; i++) {
			for(int j = 1; j <= i; j++)
				System.out.print("*" + "\t");
			System.out.print("\n");
		}	
	}
}