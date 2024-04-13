package class2_1.interface_ex.in10;

public class SamsungPhone implements PhoneInterface {

	@Override
	public void sendCall() {
		System.out.println("띠리리링");
	}

	@Override
	public void receiveCall() {
		System.out.println("전화가 왔습니다.");
	}
	
	// 추가 메서드 작성
	public void flash() {
		System.out.println("전화기에 불이 켜졌습니다.");
	}
	
	
}
