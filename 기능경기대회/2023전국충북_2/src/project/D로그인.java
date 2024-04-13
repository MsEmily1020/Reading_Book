package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class D로그인 extends BaseFrame {
	
	public D로그인() {
		super("로그인", 1000, 800);
		main.setBackground(getBackground());

		main.add(setBounds(lb[0] = new JLabel(getIcon("./datafiles/image/icon/id.png", 30, 30), 0), 460, 220, 60, 30));
		main.add(setBounds(lb[1] = new JLabel("아이디로 로그인", 0), 280, 260, 425, 45));
		
		main.add(setBounds(tf[0] = new JTextField("아이디"), 300, 335, 385, 40));
		main.add(setBounds(tf[1] = new JTextField("비밀번호"), 300, 405, 385, 40));
		
		main.add(setBounds(btn[0] = new JButton("로그인"), 300, 470, 190, 35));
		main.add(setBounds(btn[1] = new JButton("닫기"), 495, 470, 190, 35));
		
		main.add(setBounds(jp[0] = new JPanel(), 280, 215, 425, 310));
		
		setCompoent(main);
		
		lb[1].setFont(new Font("맑은 고딕", 1, 18));
		tf[0].setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
		tf[1].setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
		btn[0].setForeground(getBackground());
		btn[1].setForeground(getBackground());
		btn[0].setBackground(Color.RED);
		btn[1].setBackground(Color.BLACK);
		jp[0].setBorder(new LineBorder(Color.LIGHT_GRAY));
		jp[0].setBackground(Color.WHITE);
	}

	public static void main(String[] args) {
		new D로그인().setVisible(true);
	}
}
