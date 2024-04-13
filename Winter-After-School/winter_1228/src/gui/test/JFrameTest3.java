package gui.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Inner(내부) 클래스로 ActionListener를 구현
public class JFrameTest3 extends JFrame {
	JButton[] bt = new JButton[3];
	ImageIcon icon = new ImageIcon("./image/호빵맨.gif");
	JLabel label = new JLabel(icon, JLabel.CENTER);

	public JFrameTest3() {
		JPanel panel = new JPanel();
		
		String[] str = "Ive,Black Pink,New Jeans".split(",");

		for (int i = 0; i < bt.length; i++) {
			BtListener btListenr = new BtListener();
			bt[i] = new JButton(str[i]);
			panel.add(bt[i]);
			bt[i].addActionListener(btListenr);
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
		new JFrameTest3().setVisible(true);
	}

	public class BtListener implements ActionListener {
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
	}
}