package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class C로그인 extends BaseFrame {
	
	JPanel sch;
	
	public C로그인() {
		super("로그인", 500, 600);
		setUndecorated(true);
		main.setBackground(getBackground());

		main.add(setBounds(lb[0] = new JLabel(getIcon("./datafiles/logo.png", 30, 30), 0), 220, 80, 50, 35));
		main.add(setBounds(lb[1] = new JLabel("기능장터로 중고거래 시작하기", 0), 0, 150, getWidth(), 30));
		main.add(setBounds(lb[2] = new JLabel("간편하게 가입하고 상품을 확인하세요", 0), 0, 200, getWidth(), 30));
		main.add(setBounds(jp[0] = new JPanel(new GridLayout(4, 1, 10, 20)), 50, 280, getWidth() - 100, 250));
		main.add(setBounds(btn[0] = actbtn("", e -> dispose()), 450, 15, 30, 30));
		
		lb[0].setEnabled(false);
		
		String[] str = "아이디로 이용하기,전화번호로 이용하기,이메일로 이용하기,회원가입".split(",");
		for (int i = 0; i < str.length; i++) {
			jp[0].add(actbtn(str[i], e -> System.out.println(e.getActionCommand())));
		}
		
		setCompoent(main);
		setCompoent(jp[0]);
		
		jp[0].setBackground(getBackground());
		lb[1].setFont(new Font("맑은 고딕", 1, 24));
		btn[0].setIcon(getIcon("./datafiles/image/icon/cancel.png", 30, 30));
		btn[0].setBackground(new Color(238, 238, 238));
	}

	public static void main(String[] args) {
		new C로그인().setVisible(true);
	}
}
