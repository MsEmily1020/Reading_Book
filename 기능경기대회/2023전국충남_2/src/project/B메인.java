package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class B메인 extends BaseFrame {
	
	JScrollPane jsp = new JScrollPane();
	
	ButtonGroup bg = new ButtonGroup();
	
	public B메인() {
		super("메인", 550, 650);
		try {
			main.add(setBounds(lb[0] = new JLabel("메인"), 15, 5, 505, 25));
			main.add(setBounds(tf[0] = new JTextField("검색할 상품을 입력하세요"), 75, 35, 350, 25));
			main.add(setBounds(btn[0] = actionbtn("IBLY", e -> 검색("order by sort")), 20, 30, 50, 30));
			main.add(setBounds(btn[1] = actionbtn("검색", e -> 검색("and name like replace(upper('%" + tf[0].getText() + "%'), ' ', '')")), 430, 35, 80, 25)); //tf[0].getname 조건 넣기
			main.add(setBounds(btn[2] = actionbtn("Best상품", e -> 검색("order by cnt desc limit 10")), 45, 70, 85, 35));
			main.add(setBounds(btn[3] = actionbtn("타임세일", e -> 검색("and saletime = '1'")), 140, 70, 85, 35));
			main.add(setBounds(btn[4] = actionbtn("new", e -> 검색("and newgoods = '1'")), 235, 70, 95, 35));
			main.add(setBounds(btn[5] = actionbtn("상의", e -> 검색(e)), 20, 115, 75, 75));
			main.add(setBounds(btn[6] = actionbtn("하의", e -> 검색(e)), 105, 115, 75, 75));
			main.add(setBounds(btn[7] = actionbtn("아우터", e -> 검색(e)), 190, 115, 75, 75));
			main.add(setBounds(btn[8] = actionbtn("속옷", e -> 검색(e)), 275, 115, 75, 75));
			main.add(setBounds(btn[9] = actionbtn("신발", e -> 검색(e)), 360, 115, 75, 75));
			main.add(setBounds(btn[10] = actionbtn("유아", e -> 검색(e)), 445, 115, 75, 75));
			
			main.add(setBounds(pn[1] = new JPanel(new GridLayout(1, 5, 15, 5)), 20, 565, 500, 30));
			
			pn[1].add(btn[11] = actionbtn("로그아웃", e -> changeFrame(new A로그인())));
			pn[1].add(btn[12] = actionbtn("광고보기", e -> {
				jsp.setVisible(pn[2].isVisible());
				pn[2].setVisible(!pn[2].isVisible());
			}));
			pn[1].add(btn[13] = actionbtn("My블리", e -> changeFrame(new F마이페이지())));
			pn[1].add(btn[14] = actionbtn("회원관리", e -> changeFrame(new J회원관리())));
			pn[1].add(btn[15] = actionbtn("상품등록", e -> changeFrame(new F마이페이지())));
			pn[1].add(btn[16] = actionbtn("공동구매현황", e -> changeFrame(new H공동구매현황())));
			pn[1].add(btn[17] = actionbtn("배송관리", e -> changeFrame(new L배송관리())));
			
			main.add(setBounds(ch[0] = new JCheckBox("전체"), 20, 200, 75, 25));
			main.add(setBounds(ch[1] = new JCheckBox("공용"), 100, 200, 75, 25));
			main.add(setBounds(ch[2] = new JCheckBox("남자"), 180, 200, 75, 25));
			main.add(setBounds(ch[3] = new JCheckBox("여자"), 260, 200, 75, 25));
			
			ch[0].setSelected(true);
			
			for (int i = 0; i < 4; i++) {
				bg.add(ch[i]);
				ch[i].addActionListener(e -> 검색(""));
			}
			
			main.add(setBounds(jsp = new JScrollPane(setBounds(pn[0] = new JPanel(new FlowLayout(0)), 0, 3000)), 20, 240, 500, 320));
			main.add(setBounds(pn[2] = new JPanel(new FlowLayout(0, 0, 0)), 20, 240, 500, 320)); //광고 보기
			
			pn[2].add(setBounds(lb[1] = new JLabel("유아용 3세용 신발", 0), 500, 30));
			pn[2].add(setBounds(lb[2] = new JLabel(getIcon("./datafiles/goods/13.jpg", 500, 270)), 500, 270));
			pn[2].add(setBounds(lb[3] = new JLabel("●○○", 0), 500, 20));
			
			setComponent(main);
			setComponent(pn[0]);
			setComponent(pn[1]);
			setComponent(pn[2]);
			
			lb[0].setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
			lb[1].setFont(new Font("맑은 고딕", 1, 12));
			
			lb[1].setBorder(new LineBorder(Color.BLACK));
			lb[3].setBorder(new LineBorder(Color.BLACK));
			
			btn[2].setFont(new Font("맑은 고딕", 1, 18));
			btn[3].setFont(new Font("맑은 고딕", 1, 18));
			btn[4].setFont(new Font("맑은 고딕", 1, 18));
			btn[0].setBorder(null);
			btn[2].setBorder(null);
			btn[3].setBorder(null);
			btn[4].setBorder(null);
			btn[0].setForeground(Color.BLUE);
			btn[0].setBackground(Color.WHITE);
			btn[2].setBackground(Color.WHITE);
			btn[3].setBackground(Color.WHITE);
			btn[4].setBackground(Color.WHITE);
			btn[5].setBackground(Color.WHITE);
			btn[6].setBackground(Color.WHITE);
			btn[7].setBackground(Color.WHITE);
			btn[8].setBackground(Color.WHITE);
			btn[9].setBackground(Color.WHITE);
			btn[10].setBackground(Color.WHITE);
			
			pn[2].setVisible(false);
			pn[2].setBorder(new LineBorder(Color.BLACK));
			
			for (int i = 5; i < 11; i++) {
				btn[i].setIcon(getIcon("./datafiles/categories/" + (i - 4) + ".jpg", 40, 40));
				btn[i].setVerticalTextPosition(3);
				btn[i].setHorizontalTextPosition(0);
				btn[i].setBorderPainted(false);
				btn[i].setBorder(new LineBorder(Color.RED));
			}

			jsp.setBorder(null);
			pn[0].setBackground(Color.WHITE);
			pn[1].setBackground(Color.WHITE);
			
			btn[3].setEnabled(getResult("SELECT *, now() between categories.c_saletime and addtime(categories.c_saletime, '01:00:00') as saletime,\r\n"
					+ "now() between ADDDATE(goods.g_date, INTERVAL -7 DAY) and goods.g_date as newgoods,\r\n"
					+ "if(FIND_IN_SET(goods.c_no, (select u_like from user where u_no = ?)) = 0, 4, \r\n"
					+ "FIND_IN_SET(goods.c_no, (select u_like from user where u_no = ?))) as sort,\r\n"
					+ "sum(purchase.p_quantity) as cnt, replace(upper(g_name),' ', '') as name\r\n"
					+ "FROM goods\r\n"
					+ "join purchase on purchase.g_no = goods.g_no\r\n"
					+ "join categories on categories.c_no = goods.c_no group by goods.g_no having saletime = 1", u_no, u_no).next());
			
			btn[4].setLayout(null);
			btn[4].add(setBounds(lb[2] = new JLabel("●"), 70, 3, 10, 10));
			lb[2].setForeground(Color.RED);
			lb[2].setEnabled(getResult("SELECT *, now() between categories.c_saletime and addtime(categories.c_saletime, '01:00:00') as saletime,\r\n"
					+ "now() between ADDDATE(goods.g_date, INTERVAL -7 DAY) and goods.g_date as newgoods,\r\n"
					+ "if(FIND_IN_SET(goods.c_no, (select u_like from user where u_no = ?)) = 0, 4, \r\n"
					+ "FIND_IN_SET(goods.c_no, (select u_like from user where u_no = ?))) as sort,\r\n"
					+ "count(*) as cnt, replace(upper(g_name),' ', '') as name\r\n"
					+ "FROM goods\r\n"
					+ "join purchase on purchase.g_no = goods.g_no\r\n"
					+ "join categories on categories.c_no = goods.c_no group by goods.g_no having newgoods = 1", u_no, u_no).next());
			
			btn[4].setEnabled(lb[2].isEnabled());
			
			검색("order by sort");
			
			if (u_no == 0) {
				pn[1].remove(btn[12]);
				pn[1].remove(btn[13]);
			} else {
				pn[1].remove(btn[14]);
				pn[1].remove(btn[15]);
				pn[1].remove(btn[16]);
				pn[1].remove(btn[17]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void 검색(ActionEvent e) {
		try {
			for (int i = 5; i < 11; i++) {
				btn[i].setBorderPainted(btn[i].getText().equals(e.getActionCommand()) && !((JButton) e.getSource()).isBorderPainted());
			}
			검색("");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void 검색(String sql) {
		try {
			pn[0].removeAll();

			String ctg = (ch[1].isSelected() ? "공용" : ch[2].isSelected() ? "남성" : ch[3].isSelected() ? "여성" : "") + "%";

			sql = " and name like replace(upper('%" + (tf[0].getText().equals(tf[0].getName()) ? "" : tf[0].getText()) + "%'), ' ', '') " + sql;

			for (int i = 5; i < 11; i++) {
				sql = " and c_name like '" + (btn[i].isBorderPainted() ? btn[i].getText() : "") + "%'" + sql;
			}
			
			var rs = getResult("SELECT *, now() between categories.c_saletime and addtime(categories.c_saletime, '01:00:00') as saletime,\r\n"
					+ "now() between ADDDATE(goods.g_date, INTERVAL -7 DAY) and goods.g_date as newgoods,\r\n"
					+ "if(FIND_IN_SET(goods.c_no, (select u_like from user where u_no = ?)) = 0, 4, \r\n"
					+ "FIND_IN_SET(goods.c_no, (select u_like from user where u_no = ?))) as sort,\r\n"
					+ "count(*) as cnt, replace(upper(g_name),' ', '') as name\r\n"
					+ "FROM goods\r\n"
					+ "join purchase on purchase.g_no = goods.g_no\r\n"
					+ "join categories on categories.c_no = goods.c_no group by goods.g_no having name like ? " + sql, u_no, u_no, ctg);
			
			for (int i = 0; rs.next(); i++) {
				pn[0].add(setBounds(btn[20] = actionbtn(rs.getString(1), e -> dispose()), 235, 175));
				btn[20].add(setBounds(lb[0] = new JLabel(getIcon("./datafiles/goods/" + rs.getString("g_no") + ".jpg", 200, 140)), 200, 140));
				btn[20].add(setBounds(lb[1] = new JLabel(String.format("%,d  ", (int) (rs.getInt("g_price") * (1 - (rs.getDouble("g_sale") - rs.getDouble("c_discount")) * rs.getInt("saletime")))) + rs.getString("g_name"), 0), 175, 20));
				btn[20].setBorder(new LineBorder(rs.getInt("saletime") == 1 ? Color.RED : Color.BLACK));
				btn[20].setBackground(Color.WHITE);
				btn[20].setLayout(new FlowLayout());
			}

			jsp.getVerticalScrollBar().setValue(0);
			
			pn[0].setPreferredSize(new Dimension(0, (pn[0].getComponentCount() + pn[0].getComponentCount() % 2) / 2 * 180));
//			pn[0].setPreferredSize(new Dimension(0, pn[0].getComponent(pn[0].getComponentCount() - 1). + 180));
			
			pn[0].revalidate();
			pn[0].repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new B메인().setVisible(true);
	}
}
