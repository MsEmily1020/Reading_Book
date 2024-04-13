package class2_1.interface_ex.in12;

public class SoundExam {
	public static void main(String[] args) {
		// 상속관계의 경우와는 다르게 인터페이스의 객체는 생성되지 않는다
		// 인터페이스명을 자료형으로 하여 구현체의 객체를 참조할 수 있다
		// Sound tv1 = new Sound();
		Sound tv = new TV();
		Sound radio = new Radio();
		tv.SoundUp(5);
		tv.SoundDown(10);
		
		radio.SoundUp(5);
		radio.SoundDown(10);
		
	}
}
