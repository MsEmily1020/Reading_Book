package racehores;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RaceHores extends JFrame {
	JLabel[] lb = new JLabel[3];
	JPanel[] pn = new JPanel[3];
	
	public RaceHores() {
		for (int i = 0; i < lb.length; i++) {
			pn[i] = new JPanel(null);
			pn[i].setBounds(0, 0, 500, 400);
			pn[i].add(lb[i] = new JLabel(new ImageIcon("image/img" + (i+1) + ".gif")));
			lb[i].setBounds(10, 40 + i * 130, 100, 100);
			add(pn[i]);
		}
		
		setTitle("달리기시합");
		setResizable(false);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(2);
	}
	
	public static void main(String[] args) {
		new RaceHores().setVisible(true);
	}
}
