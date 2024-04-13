package class2_1.interface_ex.in07;

public class MethodOverridingEx {
	static void paint(Shape s) {
		s.draw();
	}
	
	public static void main(String[] args) {
		Line line = new Line();
		paint(line); // Shape s = line 동일 s.draw()는 Line 클래스에 있는 draw()호출
		paint(new Shape()); // Shape s = new Shape() 와 동일
		paint(new Circle()); // Shape s = new Circle()와 동일
		paint(new Rect()); // Shape s = new Rect()와 동일
	}
}
