package class2_1.thread_ex.th03;

import java.awt.Color;

import javax.swing.JLabel;

public class FlickeringLabel extends JLabel implements Runnable {
	private long dely;
	
	public FlickeringLabel(String text, long dely) {
		super(text);
		this.dely = dely;
		setOpaque(true);
		Thread th = new Thread(this);
		th.start();
	}

	@Override
	public void run() {
		int n = 0;
		while(true) {
			if (n == 0)
				setBackground(Color.yellow);
			else
				setBackground(Color.green);
			
			if(n == 0) n = 1;
			else n = 0;
			
			try {
				Thread.sleep(dely);
			} catch(InterruptedException e ) {
				return;
			}
		}
		
	}
}
