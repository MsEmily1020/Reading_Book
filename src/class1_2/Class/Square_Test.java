package class1_2.Class;

public class Square_Test {
	public static void main(String[] args) {
		Square square1 = new Square();
		Square square2 = new Square();
		square1.init(20, 10);
		square2.init(5, 4);
		System.out.println("사각형1의 넓이는 " + square1.area() + "이고, 둘레는 " + square1.round() + "입니다.");
		System.out.println("사각형2의 넓이는 " + square2.area() + "이고, 둘레는 " + square2.round() + "입니다.");
	}
}

class Square {
	int width;
	int height;
	
	void init(int w, int h) {
		width = w;
		height = h;
	}
	
	int area() {
		return width * height;
	}

	int round() {
		return (width + height) * 2;
	}
}
