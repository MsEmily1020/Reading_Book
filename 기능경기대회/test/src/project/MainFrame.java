package project;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import main.BackgroundFrame;
import main.BaseFrame;

public class MainFrame extends BaseFrame {
	
	public MainFrame() {
		super("메인", 1000, 700);
		메인 = this;
		try {
			stmt.execute("delete from sys.list1");
			
			main.add(setBounds(btn[2] = actbtn("로그인/회원가입", e -> changeFrame(new LoginFrame())), 860, 10, 105, 25));
			main.add(setBounds(btn[5] = new JButton("미림장터", getIcon("datafiles/logo.png", 30, 30)), 10, 45, 150, 30));
			main.add(setBounds(btn[6] = new JButton("판매하기", getIcon("datafiles/image/icon/sell.png", 20, 20)), 715, 45, 90, 25));
			main.add(setBounds(btn[7] = new JButton("내상점", getIcon("datafiles/image/icon/store.png", 20, 20)), 810, 45, 95, 25));
			main.add(setBounds(btn[8] = new JButton("차트", getIcon("datafiles/image/icon/chart.png", 20, 20)), 905, 48, 65, 25));
			main.add(setBounds(btn[9] = actbtn("", e -> search()), 600, 46, 28, 28));

			main.add(setBounds(tf[0] = new JTextField("상품명, 지역명, @상점명 입력"), 171, 46, 430, 28));

			main.add(setBounds(lb[0] = new JLabel(), 165, 45, 465, 30));
			main.add(setBounds(lb[1] = new JLabel("찜한상품", 0), 910, 120, 60, 15));
			main.add(setBounds(lb[2] = new JLabel("♥ 0", 0), 910, 140, 60, 15));
			main.add(setBounds(lb[3] = new JLabel("최근본상품", 0), 900, 175, 80, 15));

			main.add(setBounds(jp[0] = new JPanel(null), 165, 80, 430, 350));
			main.add(setBounds(jp[1] = new JPanel(), 900, 110, 80, 55));
			main.add(setBounds(jp[2] = new JPanel(), 900, 170, 80, 440));

			main.add(setBounds(jsp = new JScrollPane(), 10, 110, 885, 545));

			jp[0].add(setBounds(btn[10] = actbtn("최근검색어", e -> search(e.getSource())), 5, 5, 205, 35));
			jp[0].add(setBounds(btn[11] = actbtn("인기검색어", e -> search(e.getSource())), 215, 5, 205, 35));
			jp[0].add(setBounds(btn[12] = actbtn("검색어 전체삭제", e -> { jp[3].removeAll(); jp[3].repaint(); }), 5, 320, 110, 20));
			jp[0].add(setBounds(btn[13] = actbtn("닫기", e -> jsp.requestFocus()), 380, 320, 40, 20));
			jp[0].add(setBounds(jp[3] = new JPanel(new FlowLayout(0, 0, 0)), 5, 45, 415, 265));
			jp[0].add(setBounds(jp[4] = new JPanel(new FlowLayout(0, 0, 0)), 5, 45, 415, 265));
			jp[0].add(setBounds(jp[5] = new JPanel(), 1, 310, 428, 39));

			jp[4].setVisible(false);

			rs = getResult("SELECT no, content, count(*) cnt FROM market.history group by content order by cnt desc, no desc limit 20;");
			
			for (int i = 0; rs.next(); i++) {
				jp[4].add(setBounds(btn[20] = actbtn((i % 2) * 10 + i / 2 + 1 + "", e -> search()), (int) (jp[3].getWidth() * 0.05), jp[3].getHeight() / 10));
				jp[4].add(setBounds(btn[21] = actbtn(rs.getString("content"), e -> search()), (int) (jp[3].getWidth() * 0.45), jp[3].getHeight() / 10));
				btn[20].setForeground(new Color(0, 128, 0));
				btn[21].setHorizontalAlignment(2);
			}

			tf[0].addFocusListener(new FocusListener() {
				@Override
				public void focusLost(FocusEvent e) {
					jp[0].setVisible(false);
					main.repaint();
				}

				@Override
				public void focusGained(FocusEvent e) {
					jp[0].setVisible(true);
					main.repaint();
				}
			});
			
			btn[5].addActionListener(e -> changeFrame(new MainFrame()));
			
			setComponent(main);
			setComponent(jp[0]);	
			setComponent(jp[4]);

			tf[0].setForeground(Color.GRAY);
			
			lb[0].setBorder(new LineBorder(new Color(0, 128, 0)));

			jp[0].setVisible(false);
			jp[0].setBorder(new LineBorder(Color.GRAY));
			jp[1].setBorder(new LineBorder(Color.BLACK));
			jp[2].setName("1");
			jp[2].setBorder(new CompoundBorder(new LineBorder(Color.BLACK), new EmptyBorder(30, 0, 0, 0)));
			jp[5].setBackground(getBackground());

			btn[5].setForeground(new Color(0, 128, 0));
			btn[9].setIcon(new ImageIcon("./datafiles/image/icon/search.png"));
			btn[10].setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 128, 0)));
			btn[11].setBorder(new MatteBorder(0, 0, 2, 0, Color.GRAY));
			btn[10].setForeground(new Color(0, 128, 0));
			btn[11].setForeground(Color.GRAY);
			btn[12].setBackground(new Color(238, 238, 238));
			btn[13].setBackground(new Color(238, 238, 238));
			
			jsp.setVerticalScrollBarPolicy(22);
			jsp.getVerticalScrollBar().setUnitIncrement(22);
			
			jsp.getViewport().setView(new BackgroundFrame().main);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void visibleFalseAll() {                                                                                  
		for (Component comp : jp[3].getComponents()) {
			comp.setVisible(false);
		}
	}
	 
	public void recentProduct() throws Exception {
		jp[2].removeAll();
		상품리스트(jp[2], getResult("select distinct(no), title, price from sys.list1 order by sort desc limit 5"));
	}

	private void search() {
		try {
			jp[3].add(setBounds(actbtn("X", e -> {
				jp[3].remove(((JButton) e.getSource()));
				jp[3].remove(jp[3].getComponentAt(0, ((JButton) e.getSource()).getY()));
				jp[3].revalidate();
				jp[3].repaint();
			}), (int) (jp[3].getWidth() * 0.05), jp[3].getHeight() / 10), 0);
			jp[3].add(btn[20] = setBounds(actbtn(tf[0].getText(), e -> tf[0].setText(e.getActionCommand())), (int) (jp[3].getWidth() * 0.95), jp[3].getHeight() / 10), 0);
			btn[20].setHorizontalAlignment(2);
			
			update("insert into history values(null,?)", tf[0].getText());
			setComponent(jp[3]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void search(Object obj) {
		if(((JButton) obj).getForeground() == new Color(0, 128, 0)) return;
		btn[10].setBorder(new MatteBorder(0, 0, 2, 0, !jp[3].isShowing() ? new Color(0, 128, 0) : Color.GRAY));
		btn[11].setBorder(new MatteBorder(0, 0, 2, 0, jp[3].isShowing() ? new Color(0, 128, 0) : Color.GRAY));
		btn[10].setForeground(!jp[3].isShowing() ? new Color(0, 128, 0) : Color.GRAY);
		btn[11].setForeground(jp[3].isShowing() ? new Color(0, 128, 0) : Color.GRAY);
		jp[3].setVisible(!jp[3].isShowing());
		jp[4].setVisible(!jp[4].isShowing());
		btn[12].setVisible(jp[3].isShowing());
	}

	public static void main(String[] args) {
		try {
			new MainFrame().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
