package class2_1.interface_ex.in01;

public class ColorPoint extends Point {
	private String color;
	public void setColor(String color) {
		this.color = color; // 멤버변수 color에 String 값 저장
	} 
	
	public void showColorPoint() {
		System.out.print(color); // 멤버변수 출력
		showPoint(); // Point 상속 받은 메소드 호출
	}
}
