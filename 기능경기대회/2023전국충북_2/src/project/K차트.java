package project;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class K차트 extends BaseFrame {
	
	JPanel sch;
	
	public K차트() {
		super("메인", 1000, 800);
		
		main.add(setBounds(lb[8] = new JLabel("<", 0), 5, 0, 30, 30));
		main.add(setBounds(lb[9] = new JLabel(">", 0), 35, 0, 30, 30));
		
		main.add(setBounds(lb[0] = new JLabel("로그인/회원가입", 0), 785, 5, 115, 20));
		main.add(setBounds(lb[1] = new JLabel("내상점", 0), 905, 5, 75, 20));
		
		main.add(setBounds(lb[2] = new JLabel("기능장터", 0), 20, 50, 125, 45));
		
		main.add(setBounds(tf[0] = new JTextField("상품명, 지역명, @상점명 입력"), 175, 52, 450, 31));
		tf[0].setForeground(Color.GRAY);
		
		main.add(setBounds(lb[3] = new JLabel(new ImageIcon("./datafiles/image/icon/search.png")), 630, 52, 35, 31));
		tf[0].setBorder(null);
		
		main.add(setBounds(jp = new JPanel(), 170, 50, 495, 35));
		jp.setBorder(new LineBorder(Color.ORANGE, 2));
		
		main.add(setBounds(lb[4] = new JLabel("판매하기", 0), 740, 50, 85, 35));
		main.add(setBounds(lb[5] = new JLabel("내상점", 0), 820, 50, 85, 35));
		main.add(setBounds(lb[6] = new JLabel("차트", 0), 880, 50, 85, 35));
		
		main.add(setBounds(new JLabel("찜한상품", 0), 885, 120, 95, 25));
		main.add(setBounds(lb[7] = new JLabel("♥ 0", 0), 885, 150, 95, 25));
		
		main.add(setBounds(jp = new JPanel(), 885, 115, 95, 65));
		jp.setBorder(new LineBorder(Color.BLACK));
		main.add(setBounds(jp = new JPanel(), 885, 185, 95, 485));
		jp.setBorder(new LineBorder(Color.BLACK));
		
		main.add(setBounds(sch = new JPanel(null), 170, 95, 470, 451));
		sch.setBorder(new LineBorder(Color.GRAY, 1));
		
		sch.add(setBounds(lb[0] = new JLabel("최신검색어", 0), 10, 5, 225, 35));
		sch.add(setBounds(lb[1] = new JLabel("인기검색어", 0), 235, 5, 225, 35));
		lb[0].setBorder(new MatteBorder(0, 0, 2, 0, Color.ORANGE));
		lb[1].setBorder(new MatteBorder(0, 0, 2, 0, Color.GRAY));
		lb[0].setForeground(Color.ORANGE);
		
		sch.add(setBounds(jp = new JPanel(), 10, 50, 450, 350));
		sch.add(setBounds(jp1 = new JPanel(), 10, 50, 450, 350));

		sch.add(setBounds(lb[2] = new JLabel("검색어 전체삭제"), 30, 410, 150, 20));
		sch.add(setBounds(lb[3] = new JLabel("닫기"), 430, 410, 45, 20));
		sch.add(setBounds(jp3 = new JPanel(), 1, 400, 468, 50));
		
		for (int i = 0; i < 2; i++) {
			lb[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(((JLabel) e.getSource()).getForeground() == Color.ORANGE) return;
					lb[0].setBorder(new MatteBorder(0, 0, 2, 0, !jp.isShowing() ? Color.ORANGE : Color.GRAY));
					lb[1].setBorder(new MatteBorder(0, 0, 2, 0, jp.isShowing() ? Color.ORANGE : Color.GRAY));
					lb[0].setForeground(!jp.isShowing() ? Color.ORANGE : Color.GRAY);
					lb[1].setForeground(jp.isShowing() ? Color.ORANGE : Color.GRAY);
					jp.setVisible(!jp.isShowing());
					lb[2].setVisible(jp.isShowing());
				}
			});
		}
		
		main.add(setBounds(jp = new JPanel(), 0, 115, 880, 640));
		
		sch.setVisible(false);
		
		tf[0].addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				tf[0].setForeground(tf[0].getText().isEmpty() ? Color.GRAY : Color.BLACK);
				tf[0].setText(tf[0].getText().isEmpty() ? "상품명, 지역명, @상점명 입력" : tf[0].getText());
				sch.setVisible(false);
			}
			@Override
			public void focusGained(FocusEvent e) {
				tf[0].setText("");
				tf[0].setForeground(Color.BLACK);
				sch.setVisible(true);
			}
		});
		
		lb[3].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				sch.setVisible(false);
			};
		});
		
		
		changeWhite(sch);
		changeWhite(main);
		
		jp3.setBackground(getBackground());
	}
	
	public static void main(String[] args) {
		new K차트().setVisible(true);
	}
}
