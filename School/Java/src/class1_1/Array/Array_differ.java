package class1_1.Array;

public class Array_differ {
	public static void main(String[] args) {
		int[][] a = new int[2][];
		a[0] = new int[2];
		a[1] = new int[5];

		for(int i = 0; i < a[0].length; i++)
			System.out.println(a[0][i]);

		for(int i = 0; i < a[1].length; i++)
			System.out.println(a[1][i]);

		int[][] c = new int[3][];

		for(int i = 0; i < c.length; i++) {
			c[i] = new int[2 * (i + 1)];
			System.out.println(c[i].length);
		}

		int num = 1; 
		for(int i = 0; i < c.length; i++)
			for(int j = 0; j < c[i].length; j++) {
				c[i][j] = num++;
				System.out.print(c[i][j]);
			}
	}
}
