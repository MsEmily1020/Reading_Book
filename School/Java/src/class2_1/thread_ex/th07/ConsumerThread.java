package class2_1.thread_ex.th07;

class ConsumerThread extends Thread {
	MyLabel bar;
	
	ConsumerThread(MyLabel bar) {
		this.bar = bar;
	}
	public void run() {
		while(true) {
			try {
				sleep(200);
				bar.consume(); 
			} catch (InterruptedException e)
			 { return; }
		}
	}
}
