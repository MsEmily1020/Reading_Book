package class1_1.While;
public class Whilesum1to100 {
	public static void main(String args[]) {
		int i = 2, sum = 0;
		while(i < 100) {
			sum += i;
			i++;
		}

		System.out.println(sum);
	}
}