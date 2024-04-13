package project;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class 로그인 extends BaseFrame {
	JPasswordField tf1 = new JPasswordField();

	public 로그인() {
		super("로그인", 600, 500);

		main.add(setBounds(lb[0] = new JLabel("ID"), 145, 290, 35, 40));
		main.add(setBounds(lb[1] = new JLabel("PW"), 145, 335, 30, 30));
		main.add(setBounds(tf[0] = new JTextField(), 190, 290, 190, 30));
		main.add(setBounds(tf1 = new JPasswordField(), 190, 335, 190, 30));
		main.add(setBounds(btn[0] = new JButton("로그인"), 390, 293, 75, 70));
		main.add(setBounds(jp[0] = new JPanel(null), 5, 0, 580, 250));

		jp[0].add(setBounds(btn[1] = new JButton("Delivery", getIcon("datafiles/logo.png", 200, 200)), 405, 50, 405, 150));

		new Thread() {
			public void run() {
				while(true) {
					try {
						btn[1].setLocation(btn[1].getX() - 5, btn[1].getY());
						if(btn[1].getX() == 105) break;
						Thread.sleep(500);
						repaint();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}.start();
		
		setComponent(main);
		setComponent(jp[0]);

		btn[1].setFont(new Font("맑은 고딕", 1, 50));
		btn[1].setForeground(Color.orange);
		
		tf1.setEchoChar('*');

		tf[0].setBorder(new LineBorder(Color.black));
		tf1.setBorder(new LineBorder(Color.black));
		btn[0].setBackground(Color.orange);

		btn[0].addActionListener(e -> {
			if(tf[0].getText().length() == 0 || tf1.getText().length() == 0) {
				showErr("빈칸이 있습니다.");
				return;
			}
			
			try {
				var rs = getResult("select * from customer where c_id = ? and c_pw = ?", tf[0].getText(), tf1.getText());
				var rs1 = getResult("select * from rider where ri_id = ? and ri_pw = ?", tf[0].getText(), tf1.getText());
				
				if(rs.next()) {
					showInfo(rs.getString("c_name") + " 고객님 환영합니다.");
					userNo = rs.getInt("c_no");
					userName = rs.getString("c_name");
					changeFrame(new 메인());
				}
				
				else if(rs1.next()) {
					showInfo(rs1.getString("ri_name") + " 배달원님 환영합니다.");
					riderNo = rs1.getInt("ri_no");
					riderName = rs1.getString("ri_name");
					changeFrame(new 메인라이더());
				}
				
				else {
					showErr("회원정보가 일치하지 않습니다.");
					tf[0].setText("");
					tf1.setText("");
					tf[0].grabFocus();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
	}

	public static void main(String[] args) {
		new 로그인().setVisible(true);
	}
}
