package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class H판매 extends BaseFrame {
	
	JLabel 설명 = new JLabel("<HTML>*상품 이미지는 640x640에 최적화 되어 있습니다.<br>"
			+ "-이미지는 상품 등록시 정사각형으로 잘려서 등록됩니다.<br>"
			+ "-큰 이미지일 경우 이미지가 깨지는 경우가 발생할 수 있습니다.<br>"
			+ "최대 지원 사이즈인 640 x 640으로 리사이즈 해서 올려주세요.(개당 이미지 최대 10M)");
	
	public H판매() {
		super("메인", 880, 640);
		try {
			main.add(setBounds(lb[0] = new JLabel("기본정보"), 5, 5, 80, 20));
			main.add(setBounds(lb[1] = new JLabel("*필수항목"), 80, 5, 70, 20));
			main.add(setBounds(jp[0] = new JPanel(), 0, 0, 860, 40));
			main.add(setBounds(page = new JPanel(new FlowLayout(0, 0, 0)), 0, 60, 860, 3000));
			
			page.add(setBounds(jp[1] = new JPanel(new BorderLayout()), 860, 300));
			jp[1].add(setBounds(jp[2] = new JPanel(new FlowLayout(0, 0, 0)), (int) (860 * 0.15), 300), BorderLayout.WEST);
			jp[1].add(setBounds(jp[3] = new JPanel(new FlowLayout(0)), (int) (860 * 0.85), 200), BorderLayout.CENTER);
			
			jp[2].add(lb[2] = new JLabel(" 상품이미지"));
			jp[2].add(lb[3] = new JLabel("* "));
			jp[2].add(lb[4] = new JLabel("(4/12)"));
			
			jp[3].add(setBounds(btn[0] = actbtn("이미지 등록", e -> dispose()), jp[3].getPreferredSize().width / 4 - 7, jp[3].getPreferredSize().width / 4 - 7));
			for (int i = 0; i < 12; i++) {
				jp[3].add(setBounds(lb[5] = new JLabel(), jp[3].getPreferredSize().width / 4 - 7, jp[3].getPreferredSize().width / 4 - 7));
				lb[5].add(setBounds(lb[6] = new JLabel() {
					protected void paintComponent(Graphics g) {
						g.setFont(new Font("맑은 고딕", 1, 12));
						g.setColor(new Color(0, 0, 0, 80));
						g.fillArc(0, 0, getWidth(), getHeight(), 0, 360);
						g.setColor(Color.WHITE);
						g.drawString("X", 7, 15);
					};
				}, lb[5].getPreferredSize().width - 30, 10, 20, 20));
				lb[5].setBorder(new LineBorder(Color.BLACK));
				lb[5].setVisible(false);
			}
			jp[3].add(setBounds(설명, jp[3].getPreferredSize().width, 100));
			
			jp[1].setVisible(false);
			
			page.add(setBounds(jp[4] = new JPanel(null), 860, 80));
			jp[4].add(setBounds(lb[5] = new JLabel("제목"), 15, 15, 115, 35));
			jp[4].add(setBounds(tf[0] = new JTextField(), 120, 15, 640, 35));
			
			setCompoent(main);
			setCompoent(jp[1]);
			setCompoent(jp[2]);
			setCompoent(jp[3]);
			setCompoent(jp[4]);
			
			lb[0].setFont(new Font("맑은 고딕", 1, 18));
			lb[1].setFont(new Font("맑은 고딕", 1, 10));
			lb[4].setFont(new Font("맑은 고딕", 1, 10));
			lb[1].setForeground(Color.RED);
			lb[3].setForeground(Color.RED);
			lb[4].setForeground(Color.GRAY);
			설명.setForeground(Color.BLUE);
				
			jp[0].setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
			jp[1].setBorder(new MatteBorder(0, 0, 2, 0, Color.LIGHT_GRAY));
			jp[4].setBorder(new MatteBorder(0, 0, 2, 0, Color.LIGHT_GRAY));
			
			btn[0].setBackground(Color.LIGHT_GRAY);
			btn[0].setIcon(getIcon("./datafiles/image/icon/region.png", 30, 30));
			btn[0].setHorizontalTextPosition(JLabel.CENTER);
			btn[0].setVerticalTextPosition(JLabel.BOTTOM);
			
			main.setPreferredSize(new Dimension(850, 660));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new H판매().setVisible(true);
	}
}
