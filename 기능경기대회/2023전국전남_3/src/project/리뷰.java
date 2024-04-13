package project;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class 리뷰 extends BaseFrame {
	public 리뷰() {
		super("리뷰", 600, 500);
		
		main.add(setBounds(lb[0] = new JLabel(), 20, 25, 95, 35));
		main.add(setBounds(lb[1] = new JLabel(), 20, 65, 560, 0));
		main.add(setBounds(lb[2] = new JLabel(), 20, 155, 155, 20));
		main.add(setBounds(tf[0] = new JTextField(), 20, 185, 550, 195));
		main.add(setBounds(btn[0] = new JButton("등록"), 430, 410, 135, 25));

		btn[0].addActionListener(e -> {
			if(tf[0].getText().length() == 0) {
				showErr("빈칸이 있습니다.");
				return;
			}
			
			if(tf[0].getText().length() < 10 || tf[0].getText().length() > 50) {
				showErr("리뷰 내용은 10글자이상 50글자 이하로 입력해 주세요.");
				return;
			}
			
			for(String text : "ㅅㅂ,ㅄ,ㄱㅅㄲ,ㅈㄴ,ㅁㅊ".split(",")) {
				if(tf[0].getText().contains(text)) {
					showErr("금기어가 포함되어 있습니다.(신발 x,수박 x)");
					return;
				}
			}
			
			showInfo("등록이 완료되었습니다.");
			changeFrame(new 마이페이지());
		});
	}
	
	public static void main(String[] args) {
		new 리뷰().setVisible(true);
	}
}
