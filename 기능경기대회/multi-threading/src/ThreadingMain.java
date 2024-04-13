//process : 프로그램 실행(exe) -> 프로세스 생성
//		  : 프로그램을 실행할 때, OS에 지원을 요청하기 위한 기본적인 단위
//		  : Process 내에서 메모리, 저장소, CPU 할당받음
//		  : Process와 OS 자원을 하나의 라이프싸이클로 사용하는 개념

//Thread : 프로그램 소스 코드를 실행하는 흐름(CPU 할당 받음)
//Multi-Tasking : Process 여러개 실행하는 방식
//Multi-Treading : Thread 여러개 실행하는 방식
//동기화 : 여러 쓰레드가 하나의 자원을 두고 발생하는 문제를 해결하는 방법
//Mutex lock 
//Windows 11, Linux(개발자 필수), IOS, Android : 컴퓨터 자원 효율적 관리해주는 프로그램
//컴퓨터 자원(CPU(계산장치), Memory(1차 저장장치), Storage(2차 저장장치 -> HDD, SSD), Network)

public class ThreadingMain {
	
	static int counter = 0;
	
	public static void main(String[] args) throws Exception {
		Thread t1  = new Thread(() -> {
			synchronized ("COUNTER") { //lock걸기 -> 동기화
				System.out.println("A lock");
				for(int i = 0; i < 10000; i ++) {
					++counter;
				}
			}
		});
		
		System.out.println("A unLock");
		
		Thread t2  = new Thread(() -> {
			synchronized ("COUNTER") {
				System.out.println("B lock");
				for(int i = 0; i < 10000; i ++) {
					++counter;
				}
			}
		});
		System.out.println("B unLock");
		
		t1.start();
		t2.start();
		
		//thread의 흐름이 끝날 때까지 대기 (blocking)
		t1.join();
		t2.join();
		
		//비동기 프로그램 <- 멀티 쓰레드
		
		System.out.println(counter);
	}
}