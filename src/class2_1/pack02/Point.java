package class2_1.pack02;

public class Point {
	private int x, y;

	public Point(int x, int y) { // 생성자
		this.x = x;
		this.y = y;
	}

	public String toString() { // toString() 메소드 재정의
		return "Point(" + x + " " + ", " + y + ")";
	}
}
