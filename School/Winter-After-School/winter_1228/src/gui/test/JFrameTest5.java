package gui.test;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//독립된 ActionListener 클래스를 사용하자
public class JFrameTest5 extends JFrame {
	JButton[] bt = new JButton[3];
	ImageIcon icon = new ImageIcon("./image/호빵맨.gif");
	JLabel label = new JLabel(icon, JLabel.CENTER);

	public JFrameTest5() {
		JPanel panel = new JPanel();
		
		String[] str = "Ive,Black Pink,New Jeans".split(",");

		for (int i = 0; i < bt.length; i++) {
			bt[i] = new JButton(str[i]);
			panel.add(bt[i]);
			ButtonListener btnListener = new ButtonListener(bt[0], bt[1], label);
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
	
	public static void main(String[] args) {
		new JFrameTest5().setVisible(true);
	}
}