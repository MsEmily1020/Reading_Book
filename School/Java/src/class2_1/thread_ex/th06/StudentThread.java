package class2_1.thread_ex.th06;

public class StudentThread extends Thread {
	private SharedBoard board;

	public StudentThread(String name, SharedBoard board) {
		super(name);
		this.board = board;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			board.add();
			try {
				sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
