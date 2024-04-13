import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.TemporalUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorFrame extends JFrame {

	String operand;
	String operator;
	long sum = 0;
	
	public CalculatorFrame() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		var textField = new JTextField();
		
		add(textField, BorderLayout.NORTH);
		
		var panel = new JPanel( new GridLayout(4, 4) );
		
		String[] buttons = { "7", "8", "9", "-", "4", "5", "6", "+", "1", "2", "3", "*", "/", "0", "Clear", "=" };
		
		for(String button : buttons) {
			var btn = new JButton(button);
			
			btn.addActionListener(e -> {
				
				// 숫자 입력
				if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
					textField.setText(textField.getText() + button);
					if(textField.getText().length() > 8) {
						textField.setText("");
						operand = "";
						operator = "";
					}
				}
				
				// 초기화
				else if (button.equals("Clear")) {
					textField.setText("");
					operand = "";
					operator = "";
					sum = 0;
				}
				
				//계산
				else if (button.equals("=")) {
					long op1 = Long.valueOf(sum);
					long op2 = Long.valueOf(textField.getText());
					
					if (operator.equals("+")) {
						op1 += op2;
					} else if (operator.equals("-")) {
						op1 -= op2;
					} else if (operator.equals("*")) {
						op1 *= op2;
					} else if (operator.equals("/")) {
						op1 /= op2;
					}
					
					textField.setText(String.valueOf(op1));
				}
				
				// 기호 입력
				else {
					operand = textField.getText();
					operator = button;
					
					if(operator.equals("+"))
						sum += Long.valueOf(operand);
					else if(operator.equals("-"))
						sum -= Long.valueOf(operand);
					else if(operator.equals("*"))
						sum *= Long.valueOf(operand);
					else if(operator.equals("/"))
						sum /= Long.valueOf(operand);
					
					textField.setText("");
				}
				
			});
			
			panel.add(btn);
		}
		
		add(panel);
	}
	
	public static void main(String[] args) {
		var frame = new CalculatorFrame();
		
		frame.setVisible(true);
		
	}

}
