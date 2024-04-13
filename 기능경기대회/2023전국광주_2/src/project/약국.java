package project;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;

public class 약국 extends BaseFrame {
	public 약국() {
		super("약국", 400, 400);
		main.add(setBounds(lb[0] = new JLabel("약국"), 15, 15, 45, 25));
		main.add(setBounds(tf[0] = new JTextField(""), 70, 15, 290, 30));

		DefaultMutableTreeNode ret = new DefaultMutableTreeNode();
	}
	
	public static void main(String[] args) {
		new 약국().setVisible(true);
	}
}
