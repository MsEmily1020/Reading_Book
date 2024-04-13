package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.function.Consumer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class J리뷰등록수정 extends BaseFrame {

	public J리뷰등록수정() {
		super("리뷰등록", 300, 230);
		try {
			rs = getResult("select * from review where user = ? and post = ?", u_no, p_no);

			main.add(setBounds(jp[0] = new JPanel(), 0, 10, 285, 55));
			main.add(setBounds(jta = new JTextArea(rs.next() ? rs.getString("content") : ""), 5, 70, 275, 70));
			main.add(setBounds(btn[0] = actbtn("취소", e -> dispose()), 5, 145, 140, 40));
			main.add(setBounds(btn[1] = actbtn(rs.getRow() == 0 ? "등록" : "수정", e -> {
				try {
					if (e.getActionCommand().equals("등록")) {
						update("insert into table values(?,?,?,?)", 1, 1, 1, 1);
					} else if (e.getActionCommand().equals("수정")) {
						update("insert into table values(?,?,?,?)", 1, 1, 1, 1);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}), 150, 145, 130, 40));

			for (int i = 0; i < 5; i++) {
				final int a = i;
				jp[0].add(lb[0] = new JLabel("★"));
				lb[0].setFont(new Font("맑은 고딕", 1, 32));
				lb[0].setForeground(Color.YELLOW);
				lb[0].setEnabled(false);
				lb[0].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						Arrays.stream(jp[0].getComponents()).forEach(comp -> comp.setEnabled(false));
						for (int i = 0; i <= a; i++) {
							jp[0].getComponent(i).setEnabled(true);
						}
					};
				});
			}

			setCompoent(main);

			jta.setBorder(new LineBorder(Color.BLACK));
			jta.setLineWrap(true);

			btn[0].setBackground(Color.BLACK);
			btn[0].setForeground(Color.WHITE);
			btn[1].setBackground(Color.RED);
			btn[1].setForeground(Color.WHITE);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new J리뷰등록수정().setVisible(true);
	}
}
