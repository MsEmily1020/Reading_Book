package class2_1.gui_ex.gui01;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	MyFrame() {
		setTitle("300*300 스윙 프레임 만들기");
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
	}
}
