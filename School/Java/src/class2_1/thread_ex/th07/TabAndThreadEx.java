package class2_1.thread_ex.th07;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class TabAndThreadEx  extends JFrame {
	MyLabel bar = new MyLabel(100); 	
	TabAndThreadEx(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		bar.setBackground(Color.ORANGE);
		bar.setOpaque(true);
		bar.setLocation(20,  50);
		bar.setSize(300, 20); 
		c.add(bar);
		
		c.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) 
			{
				bar.fill(); 
			}
		});
		setSize(350,200);
		setVisible(true);
		
		c.requestFocus(); 
		ConsumerThread th = new 
			ConsumerThread(bar); 
		th.start(); // 스레드 시작
	}

	public static void main(String[] args) {
		new TabAndThreadEx("아무키나 빨리 눌러 바 채우기");
	}
}
