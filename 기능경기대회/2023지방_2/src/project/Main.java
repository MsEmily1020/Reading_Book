package project;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends CommonFrame {
	
	public static int userId = -255;
	public static String userName;
	
	public Main() {
		super("메인", 800, 600);
		
		var north = new JPanel();
		
		var welcomeText = "로그인 후 이용해주세요.";
		if(userId > 0) welcomeText = userName + "님 환영합니다.";
		else if(userId == -255) welcomeText = "관리자님 환영합니다.";
		
		var lb = new JLabel(welcomeText, 0);
		lb.setForeground(Color.black);
		lb.setFont(new Font("맑은 고딕", 1, 24));
		north.add(lb);
		
		var center = new JPanel();
		var south = new JPanel();
		
		var buttons = "로그인,회원가입,도서 목록,마이페이지,책읽기,종료".split(",");
		
		if(userId == -255) buttons = "로그아웃,도서관리,도서등록,대출통계,종료".split(",");
		else if(userId > 0) buttons[0] = "로그아웃";
		
		for (int i = 0; i < buttons.length; i++) {
			var bt = new JButton(buttons[i]);
			if(userId == 0 && (i >= 2 && i <= 4)) bt.setEnabled(false);
			south.add(setBounds(bt, 0, 0, 0, 0));
		}
		
		
		add(north, "North");
		add(center);
		add(south, "South");
	}
	
	public static void main(String[] args) {
		new Main().setVisible(true);
	}
}
