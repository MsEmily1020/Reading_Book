package class2_1.in09;

public class GoocCalc extends Calculator {
	@Override
	public int add(int a, int b) {
		return a + b;
	}
	
	@Override
	public int subtract(int a, int b) {
		return a - b;
	}
	
	@Override
	public double average(int[] a) { // int[] a = new int[] {2, 3, 4}
		double sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum / a.length;
	}
	
	public static void main(String[] args) {
		GoocCalc c = new GoocCalc();
		System.out.println(c.add(2, 3));
		System.out.println(c.subtract(2, 3));
		System.out.println(c.average(new int[] {2, 3, 4}));
	}
}
