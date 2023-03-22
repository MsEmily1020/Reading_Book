package codingtest;

class RectangleClass {
	int x1, y1, x2, y2;
	int width;
	int height;
	
	public RectangleClass(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.width = (this.x2 - this.x1);
		this.height = (this.y2 - this.y1);
	}
	
	public void showRectangle() {
		System.out.println("사각형의 좌표는 왼쪽 위 (" + this.x1 + ", " + this.y1 + ")");
		System.out.println("사각형의 좌표는 오른쪽 아래 (" + this.x2 + ", " + this.y2 + ")");
	}
	
	public int getRound() {
		return 2 * width + 2 * height;
	}
	
	public int getArea() {
		return width *height;
	}
}

public class Rectangle {
	public static void main(String[] args) {
		RectangleClass t1 = new RectangleClass(1, 1, 3, 3);
		
		t1.showRectangle();
		System.out.println("사각형의 둘레: " + t1.getRound());
		System.out.println("사각형의 넓이: " + t1.getArea());
	}
}
