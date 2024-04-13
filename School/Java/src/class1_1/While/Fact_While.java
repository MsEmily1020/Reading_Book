package class1_1.While;
public class Fact_While {
	public static void main(String args[]) {
		int n = Integer.parseInt(args[0]);
		int i = 1, sum = 1;
		System.out.print(n + "!=");
		while(i <= n) {
			if(i == n) System.out.print(i);
			else System.out.print(i + "*");
			sum *= i;
			i++;
		}
		System.out.println("=" + sum);
	}
}