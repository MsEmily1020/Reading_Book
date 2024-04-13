package class1_2.Class;

public class Tri_Test {
	public static void main(String[] args) {
		Triangle tri1 = new Triangle();
		Triangle tri2 = new Triangle();
		tri1.init(20, 10);
		tri2.init(3, 7);
		System.out.println("삼각형1의 넓이는 " + tri1.area() + "입니다.");
		System.out.println("삼각형2의 넓이는 " + tri2.area() + "입니다.");
	}
}

class Triangle {
	int width;
	int height;
	
	void init(int w, int h) {
		width = w;
		height = h;
	}
	
	double area() {
		return width * height * 0.5;
	}
}