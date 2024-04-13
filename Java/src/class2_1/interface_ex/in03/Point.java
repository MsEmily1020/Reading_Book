package class2_1.interface_ex.in03;

public class Point {
	private int x, y;
	
	public Point() {
		this.x = 3;
		this.y = 4;
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void showPoint() {
		System.out.println("(" + x + ", " + y + ")");
	}
}
