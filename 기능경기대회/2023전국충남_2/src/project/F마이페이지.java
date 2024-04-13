package project;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class F마이페이지 extends BaseFrame {
	
	ArrayList<String> arr = new ArrayList();
	
	public F마이페이지() {
		super("마이페이지", 600, 550);
		try {
			var rs = getResult("select * from user where u_no = ?", u_no);
			rs.next();
			main.add(setBounds(lb[0] = new JLabel(" 마이페이지"), 0, 0, 600, 35));
			main.add(setBounds(lb[1] = new JLabel(rs.getString("u_name") + "님"), 5, 50, 110, 25));
			main.add(setBounds(lb[2] = new JLabel("내 포인트"), 10, 75, 110, 35));
			main.add(setBounds(lb[3] = new JLabel(String.format("%,dp", rs.getInt("u_point")), 4), 460, 75, 110, 35));
			main.add(setBounds(lb[4] = new JLabel(), 5, 75, 575, 35));
			
			main.add(setBounds(lb[5] = new JLabel("장바구니"), 10, 165, 135, 20));
			
			main.add(setBounds(jsp = new JScrollPane(setBounds(pn[10] = new JPanel(new FlowLayout(0)), 0, 600)), 5, 190, 575, 270));
			
			main.add(setBounds(pn[0] = new JPanel(new GridLayout(1, 4, 5, 0)), 5, 120, 575, 30));
			main.add(setBounds(pn[1] = new JPanel(new GridLayout(1, 4, 5, 0)), 5, 470, 575, 30));
			
			String[][] name = {"정보수정,탈퇴신청,공동구매현황,배송조회".split(","), "일괄구매,일괄삭제,선택구매,선택삭제".split(",")};
			for (int i = 0; i < 8; i++) {
				pn[i / 4].add(btn[i] = new JButton(name[i / 4][i % 4]));
				btn[i].addActionListener(e -> 버튼(e));
			}
			
			setComponent(main);
			
			lb[0].setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
			lb[4].setBorder(new LineBorder(Color.BLACK));
			
			pn[10].setBackground(Color.WHITE);
			
			검색("");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void 버튼(ActionEvent e) {
		try {
			arr.clear();
			if (e.getActionCommand().equals("정보수정")) {
				changeFrame(new G탈퇴신청()); return;
			}

			if (e.getActionCommand().equals("탈퇴신청")) {
				new G탈퇴신청().setVisible(true); return;
			}
			
			if (e.getActionCommand().equals("공동구매현황")) {
				changeFrame(new H공동구매현황()); return;
			}
			
			if (e.getActionCommand().equals("배송조회")) {
				changeFrame(new I배송조회()); return;
			}
			
			if (e.getActionCommand().equals("일괄구매")) {
				for (Component comp : pn[10].getComponents()) {
					arr.add(((JButton) comp).getText());
				}
				changeFrame(new E결제(arr)); return;			}
			
			if (e.getActionCommand().equals("일괄삭제")) {
				update("delete from groupbying where u_no = ?", u_no); return;
			}
			
			if (e.getActionCommand().equals("구매선택")) {
				for (Component comp : pn[10].getComponents()) {
					if (((LineBorder) ((JButton) comp).getBorder()).getLineColor() == Color.RED) {
						arr.add(((JButton) comp).getText());
					}
				}
				changeFrame(new E결제(arr)); return;
			}
			
			if (e.getActionCommand().equals("선택삭제")) {
				for (Component comp : pn[10].getComponents()) {
					if (((LineBorder) ((JButton) comp).getBorder()).getLineColor() == Color.RED) {
						update("delete from groupbying where u_no = ? and g_no = ?", u_no, ((JButton) comp).getText());
					}
				}
				return;
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public void 검색(String sql) {
		try {
			pn[10].removeAll();
			
			var rs = getResult("SELECT * FROM groupbying\r\n"
					+ "join goods on goods.g_no = groupbying.g_no\r\n"
					+ "where u_no = ?", u_no);  // shoppingbasket
			
			for (int i = 0; rs.next(); i++) {
				pn[10].add(setBounds(btn[20] = actionbtn(rs.getString("g_no"), e -> {
					JButton btn = (JButton) e.getSource();
					btn.setBorder(new LineBorder(((LineBorder) btn.getBorder()).getLineColor() == Color.BLACK ? Color.RED : Color.BLACK));
				}), 175, 210));
				btn[20].add(setBounds(lb[6] = new JLabel(getIcon("./datafiles/goods/" + rs.getString("g_no") + ".jpg", 150, 150)), 150, 150));
				btn[20].add(setBounds(lb[7] = new JLabel(rs.getString("g_name"), 0), 150, 20));
				btn[20].add(setBounds(lb[8] = new JLabel(String.format("%,d  ", rs.getInt("g_price")), 0), 150, 20));
				btn[20].setBorder(new LineBorder(Color.BLACK));
				btn[20].setBackground(Color.WHITE);
				btn[20].setLayout(new FlowLayout());
			}
			
			for (int i = 4; i < 8; i++) {
				btn[i].setEnabled(pn[10].getComponentCount() != 0);
			}
			
			jsp.getVerticalScrollBar().setValue(0);
			
			pn[10].setPreferredSize(new Dimension(0, (pn[10].getComponentCount() + pn[10].getComponentCount() % 3) / 3 * 180));
			
			pn[10].revalidate();
			pn[10].repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new F마이페이지().setVisible(true);
	}
}
