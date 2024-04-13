package class2_1.pack_ex.pack01;

public class ObjectPropertyEx {

	// Object 클래스: 최상위 클래스
	public static void print(Object obj) { // Object obj = p 와 같은 문장(업캐스팅)
		System.out.println(obj.getClass().getName()); // 현재 참조하고 있는 클래스의 이름을 가져와서 출력
		System.out.println(obj.hashCode()); // 해시코드 값을 출력 (각 객체의 주소값을 변환하여 생성한 객체의 고유한 정수값)
		System.out.println(obj.toString()); // 패키지, 클래스 이름, 해시코드를 출력
		System.out.println(obj); // 객체 출력
	}

	public static void main(String[] args) {
		Point p = new Point(2, 3);
		print(p);

	}
}