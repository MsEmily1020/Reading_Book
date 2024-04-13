package class2_1.thread_ex.th02;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class RunnableTimerEx extends JFrame {
	public RunnableTimerEx() {
		setTitle("Thread를 상속 받은 타이머 스레드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLabel);
		
//		TimerRunnable runnable = new TimerRunnable(timerLabel);
//		Thread th = new Thread(runnable);
		
		Thread th = new Thread(new TimerRunnable(timerLabel));
		
		setSize(700, 900);
		setVisible(true);
		setLocationRelativeTo(null);
		th.start();
	}
	
	public static void main(String[] args) {
		new RunnableTimerEx();
		for (int i = 0; i < 100; i++) {
			System.out.println("Thread" + i);
		}
	}
}
