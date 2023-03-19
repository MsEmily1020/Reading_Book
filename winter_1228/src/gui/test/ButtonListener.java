package gui.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ButtonListener implements ActionListener {
	JButton btn1, btn2;
	JLabel label;

	public ButtonListener(JButton btn1, JButton btn2, JLabel lb1) {
		this.btn1 = btn1;
		this.btn2 = btn2;
		this.label = lb1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ImageIcon icon = null;
		JButton[] bt = new JButton[2];
		bt[0] = btn1;
		bt[1] = btn2;
		for (int i = 0; i < bt.length; i++) {
			if(e.getSource() == bt[i]) {
				if(i == 0) icon = new ImageIcon("./image/ive.jpg");
				else if(i == 1) icon = new ImageIcon("./image/blackpink.jpg");
				label.setIcon(icon);
			}
		}
	}
}