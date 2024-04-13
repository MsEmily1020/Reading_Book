import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tic_tac_toe extends JFrame {
	public Tic_tac_toe() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		var textField = new JTextField();

		add(textField, BorderLayout.SOUTH);

		var panel = new JPanel( new GridLayout(3, 3) );

		String[] buttons = {"1", "2", "3",
							"4", "5", "6",
							"7", "8", "9"};

		for(String button : buttons) {
			var btn = new JButton(button);

			btn.addActionListener(e -> {
				//확인(O,X)
				String checkButton = textField.getText();

				for(int i = 0; i < buttons.length; i++) {
					if(button.equals(Integer.toString(i+1))) {
						if(checkButton.equals("O")) {
							buttons[i] = "O";
							btn.setText("O");
						}
						else if(checkButton.equals("X")) {
							buttons[i] = "X";
							btn.setText("X");
						}
					}
				}

				textField.setText("");

				//연속된 순서 찾기
				JOptionPane win = new JOptionPane();

				String isCheckWin = "";

				for(int i = 0; i < buttons.length; i += 3) {
					//0 == 1 == 2 / 3 == 4 == 5 / 6 == 7 == 8
					if((buttons[i] == buttons[i+1]) && (buttons[i] == buttons[i+2])) {
						isCheckWin = buttons[i];
					}
				}

				//0 == 3 == 6 / 1 == 4 == 7 / 2 == 5 == 8
				for(int i = 0; i < 3; i++) {
					if(buttons[i] == buttons[i+3] && buttons[i] == buttons[i+6]) {
						isCheckWin = buttons[i];
					}
				}

				//0 == 4 == 8 / 2 == 4 == 6
				if ((buttons[4] == buttons[0] && buttons[4] == buttons[8])
						|| (buttons[4] == buttons[2] && buttons[4] == buttons[6])) {
					isCheckWin = buttons[4];
				}

				if(isCheckWin == "X") {
					win.showMessageDialog(null, "X가 이겼습니다.");
				}

				else if(isCheckWin == "O") {
					win.showMessageDialog(null, "O가 이겼습니다.");
				}
			});
			panel.add(btn);
		}
		add(panel);
	}

	public static void main(String[] args) {
		var frame = new Tic_tac_toe();

		frame.setVisible(true);
	}
}
