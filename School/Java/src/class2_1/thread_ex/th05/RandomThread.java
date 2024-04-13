package class2_1.thread_ex.th05;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;

public class RandomThread extends Thread {
	private Container contentPane;
	private boolean flag = false;

	public RandomThread(Container contenPane) {
		this.contentPane = contenPane;
	}

	void finish() {
		flag = true;
	}

	@Override
	public void run() {
		while(true) {
			int x = ((int)(Math.random() * contentPane.getWidth()));
			int y = ((int)(Math.random() * contentPane.getHeight()));
			JLabel label = new JLabel("Java");
			label.setSize(80, 30);
			label.setLocation(x, y);
			contentPane.add(label);
			contentPane.repaint();
			try {
				Thread.sleep(300);

				if (flag) {
					contentPane.removeAll();
					label = new JLabel("finish");
					label.setSize(80, 30);
					label.setLocation(100, 100);
					label.setForeground(Color.red);
					contentPane.add(label);
					contentPane.repaint();
					return;
				}
			} catch(InterruptedException e) {
				return;
			}
		}
	}
}