package project;

import javax.swing.JLabel;

public class 로딩 extends BaseFrame {
	public 로딩() {
		super("로딩", 450, 500);
		main.add(setBounds(lb[0] = new JLabel(getIcon("datafiles/로고/로고1.jpg", getWidth() - 120, getHeight() - 150)), -8, -20, getWidth(), getHeight()));
	}

	public static void main(String[] args) {
		new 로딩().setVisible(true);
	}
}
