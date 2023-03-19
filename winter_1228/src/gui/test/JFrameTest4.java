package gui.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Anonymous(익명)클래스로 ActionListener를 구현
public class JFrameTest4 extends JFrame {
	JButton[] bt = new JButton[3];
	ImageIcon icon = new ImageIcon("./image/호빵맨.gif");
	JLabel label = new JLabel(icon, JLabel.CENTER);

	public JFrameTest4() {
		JPanel panel = new JPanel();
		
		String[] str = "Ive,Black Pink,New Jeans".split(",");

		for (int i = 0; i < bt.length; i++) {
			bt[i] = new JButton(str[i]);
			panel.add(bt[i]);
			bt[i].addActionListener(btnListener);
		}
		
		//add(panel, BorderLayout.NORTH);
		add(panel, "North");
		add(label, "Center");

		setTitle("JFrame 상속 연습");
		setResizable(true);
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(2);
	}
	
	ActionListener btnListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < bt.length; i++) {
				if(e.getSource() == bt[i]) {
					if(i == 0) icon = new ImageIcon("./image/ive.jpg");
					else if(i == 1) icon = new ImageIcon("./image/blackpink.jpg");
					else icon = new ImageIcon("./image/newjeans.jpg");
					label.setIcon(icon);
				}
			}
		}
	};
	
	public static void main(String[] args) {
		new JFrameTest4().setVisible(true);
	}
}