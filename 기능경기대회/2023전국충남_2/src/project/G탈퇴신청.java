package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class G탈퇴신청 extends BaseFrame {
	
	JTextArea area;
	
	public G탈퇴신청() {
		super("마이페이지", 350, 300);
		try {
			var rs = getResult("select * from user where u_no = ?", u_no);
			rs.next();
			main.add(setBounds(lb[0] = new JLabel("탈퇴신청"), 0, 0, 600, 35));
			main.add(setBounds(lb[1] = new JLabel(rs.getString("u_name") + "님 탈퇴 사유가 무엇인가요?", 0), 0, 45, 335, 40));
			main.add(setBounds(area = new JTextArea(), 10, 90, 315, 125));
			main.add(setBounds(btn[0] = actionbtn("제출", e -> {
				try {
					update("insert into secession values(null,?,?)", u_no, area.getText());
					dispose();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}), 245, 220, 80, 30));
			
			btn[0].setEnabled(!area.getText().isEmpty());
			
			area.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					btn[0].setEnabled(!area.getText().isEmpty());
				}
			});
			
			setComponent(main);
			
			lb[0].setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
			lb[1].setFont(new Font("맑은 고딕", 1, 20));
			
			area.setBorder(new LineBorder(Color.BLACK));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new G탈퇴신청().setVisible(true);
	}
}
