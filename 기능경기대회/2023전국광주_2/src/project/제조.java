package project;

import javax.swing.JLabel;

public class 제조 extends BaseFrame {
	public 제조() {
		super("survey", 500, 500);

		main.add(setBounds(lb[0] = new JLabel(getIcon("datafiles/아이콘/조리.PNG", 125, 90)), 180, 140, 125, 90));
		main.add(setBounds(lb[1] = new JLabel("I'm making medicine...", 0), 100, 240, 280, 25));

		showInfo("제조가 완료되었습니다!");
		changeFrame(new Result());
	}

	public static void main(String[] args) {
		new 제조().setVisible(true);
	}
}
