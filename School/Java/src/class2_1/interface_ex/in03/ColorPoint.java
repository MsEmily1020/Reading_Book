package class2_1.interface_ex.in03;

public class ColorPoint extends Point{
	private String color;
	
	public ColorPoint(int x, int y, String color) {
		// Point 부모 클래스 생성자 불러옴
		// 매개변수가 없는 생성자는 생략도 가능
		// 매개변수로 부모 클래스의 생성자 구분
		// super는 단 1개만 호출가능 하므로 매개변수를 적으면 매개변수를 적지 않은 생성자는 호출되지 않음
		super(x, y);
		this.color = color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void showColorPoint() {
		System.out.println(color);
		showPoint();
	}
}
