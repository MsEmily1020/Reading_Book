package class2_1.pack06;

public class AutoBoxingUnBoxingEx {
	public static void main(String[] args) {
		int n = 10;
		Integer intObject = n;
		System.out.println("ingObject = " + intObject);
		
		int m = intObject + 10;
		System.out.println("m = " + m);
	}
}
