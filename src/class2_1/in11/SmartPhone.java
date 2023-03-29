package class2_1.in11;

public class SmartPhone extends PDA implements MobilePhoneInterface, MP3Interface{
	// MobilePhoneInterface의 추상메서드 재정의
	@Override
	public void sendCall() {
		System.out.println("따르릉따르릉");
	}
	
	@Override
	public void receiveCall() {
		System.out.println("전화 왔어요");
	}
	
	@Override
	public void sendSNS() {
		System.out.println("문자보냅니다");
	}
	
	@Override
	public void receiveSNS() {
		System.out.println("문자 왔어요");
	}
	
	// MP3Interface의 추상메서드 재정의
	@Override
	public void play() {
		System.out.println("음악 연주합니다");
	}
	
	@Override
	public void stop() {
		System.out.println("음악 중단합니다");
	}
	
	// 추가로 작성한 메서드
	public void schedule() {
		System.out.println("일정관리합니다");
	}
}
