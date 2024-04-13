package class1_1.DoWhile;

public class DoWhileExam1 {
	public static void main(String args[]) {
		for(int i = 1; i <= 10; i++) {
			System.out.print(i + "\t");
			if(i == 5) continue;
		}
	}
}