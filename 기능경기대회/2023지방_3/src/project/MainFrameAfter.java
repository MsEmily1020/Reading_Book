package project;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MainFrameAfter extends BaseFrame {
	public static int userNo;
	public static String userId;
	public static String userPw;
	public static String userName1;
	public static String userName2;
	public static String birth;

	static {
		
	}
	
	public MainFrameAfter() {
		super("메인", 700, 500);

		setLayout(null);

		var img = new ImageIcon("datafiles/구름.jpg");
		var image = img.getImage();
		var changeImg = image.getScaledInstance(700, 150, Image.SCALE_SMOOTH);
		add(setBounds(new JLabel(new ImageIcon(changeImg)), 0, 0, 700, 200));

		var title = new JLabel("SKY AIRLINE", 0);
		title.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		add(setBounds(title, 0, 100, 690, 200));

		String[] buttons = "로그아웃,정보수정,항공권 조회,마이페이지,연령별분석".split(",");
		
		for (int i = 0; i < buttons.length; i++) {
			var bt = new JButton(buttons[i]);
			
			bt.addActionListener(e -> {
				if(bt.getText().equals("로그아웃")) {
					dispose();
					new MainFrameBefore().setVisible(true);
				}
				
				if(bt.getText().equals("정보수정")) {
					dispose();
					new SignUpFrameFix().setVisible(true);
				}
				
				if(bt.getText().equals("항공권 조회")) {
					dispose();
					new SelectAirplaneFrame().setVisible(true);
				}
			});
			
			add(setBounds(bt, 20 + i * 130, 400, 120, 30));
		}
		
	}

	public static void main(String[] args) {
		new MainFrameAfter().setVisible(true);
	}
}
