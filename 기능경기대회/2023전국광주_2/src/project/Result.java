package project;

import javax.swing.JLabel;

public class Result extends BaseFrame {
	public Result() {
		super("result", 700, 600);
		main.add(setBounds(lb[0] = new JLabel(userName + "님의 건강설문 결과표"), 15, 5, 205, 25));
		main.add(setBounds(lb[1] = new JLabel("성별: " + userGender), 15, 40, 70, 20));
		main.add(setBounds(lb[2] = new JLabel("나이: " + userAge), 95, 40, 75, 15));

	}

	public static void main(String[] args) {
		new Result().setVisible(true);
	}
}
