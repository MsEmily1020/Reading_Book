package class2_1.thread_ex.th03;

public class ThreadMainEx {
	public static void main(String[] args) {
		long id = Thread.currentThread().getId();
		String name = Thread.currentThread().getName();
		int prority = Thread.currentThread().getPriority();
		Thread.State s = Thread.currentThread().getState();
		System.out.println("현재 스레드 이름 : " + name);
		System.out.println("현재 스레드 id : " + id);
		System.out.println("현재 스레드 우선순위 : " + prority);
		System.out.println("현재 스레드상태 : " + s);
	}
}
