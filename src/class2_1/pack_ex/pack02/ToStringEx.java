package class2_1.pack_ex.pack02;

public class ToStringEx {
	public static void main(String[] args) {
		Point p = new Point(2, 3);
		System.out.println(p.toString()); // Point 클래스의 재정의한 toString() 메소드가 호출됨
		System.out.println(p); // .toString()가 생략 (p는 p.toString()으로 자동변환)
		System.out.println(p + "입니다");

	}
}
