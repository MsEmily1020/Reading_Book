package class2_1.pack_ex.pack03;

public class Point {
	private int x, y;

	public Point(int x, int y) { // 생성자
		this.x = x;
		this.y = y;
	}

	public boolean equals(Object obj) {

		Point p = (Point)obj; // 다운캐스팅
		if(this.x == p.x && this.y == p.y)
			return true;
		else
			return false;
	}
}	
