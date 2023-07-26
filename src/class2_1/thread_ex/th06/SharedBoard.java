package class2_1.thread_ex.th06;

public class SharedBoard {
	private int sum = 0; // 집계판의 합

	synchronized public void add() {
		int n = sum;
		Thread.yield(); // 현재 실행 중인 스레드 양보
		n += 10; // 10 증가
		sum = n; // 증가한 값을 집계합에 기록
		System.out.println(Thread.currentThread().getName() + " : " + sum);
	}

	public int getSum() {
		return sum;
	}
}
