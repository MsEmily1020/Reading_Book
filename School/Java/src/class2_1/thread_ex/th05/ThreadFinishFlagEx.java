package class2_1.thread_ex.th05;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.TransferHandler;

public class ThreadFinishFlagEx extends JFrame {
	private RandomThread th;
	
	public ThreadFinishFlagEx() {
		setTitle("ThreadFinishFlag Ex 예제");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				th.finish();
			}
		});
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(300, 200);
		
		th = new RandomThread(c);
		th.start();
	}
	public static void main(String[] args) {
		new ThreadFinishFlagEx();
	}
}
