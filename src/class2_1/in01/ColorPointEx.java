package class2_1.in01;

public class ColorPointEx {
	public static void main(String[] args) {
		// Point 클래스를 가리키는 객체변수 p 생성
		Point p = new Point();
		// Point 클래스 안에 있는 set 메소드 호출
		p.set(1, 2);
		// p.x = 11; : private 접근 불가
		// Point 클래스 안에 있는 showPoint 메소드 호출
		p.showPoint(); 
		
		// ColorPoint 클래스를 가리키는 객체변수 cp 생성
		// ColorPoint 클래스는 Point 클래스를 상속받음
		ColorPoint cp = new ColorPoint();
		// Point 클래스 안에 있는 set 메소드를 상속받아 호출
		// cp.x = 5; x가 private 접근 불가
		cp.set(3, 4);
		// ColorPoint 클래스 안에 있는 setColor 메소드 호출
		cp.setColor("red");
		// ColorPoint 클래스 안에 있는 showColorPoint 메소드 호출
		cp.showColorPoint();
	}
} 