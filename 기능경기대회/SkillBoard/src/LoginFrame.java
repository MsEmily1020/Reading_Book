import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginFrame extends JFrame{

	public LoginFrame() {
		this.setSize(300, 300); //창 사이즈
		this.setLocationRelativeTo(null); //창 위치 가운데
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //프로세스 종료하기

		// Layout 레이아웃


		//		this.setLayout(new BorderLayout(10, 10)); // BorderLayout : 현재 패널 크기에 따라 5개 구역으로 나누기
		//
		//		this.add(new JButton("클릭")); // BorderLayout.CENTER 생략
		//		this.add(new JButton("동쪽"), BorderLayout.EAST);
		//		this.add(new JButton("서쪽"), BorderLayout.WEST);
		//		this.add(new JButton("남쪽"), BorderLayout.SOUTH); 
		//		this.add(new JButton("북쪽"), BorderLayout.NORTH);



		//		this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10)); // FlowLayout : 순서대로 추가
		//		
		//		this.add(new JButton("클릭")); // BorderLayout.CENTER 생략 
		//		this.add(new JButton("동쪽"), BorderLayout.EAST); 
		//		this.add(new JButton("서쪽"), BorderLayout.WEST);
		//		this.add(new JButton("남쪽"), BorderLayout.SOUTH);
		//		this.add(new JButton("북쪽"), BorderLayout.NORTH);

		this.setLayout(new BorderLayout());
		
		var panel = new JPanel(new FlowLayout()); //var : 타입추론(기본형x)

		panel.add(new JLabel("ID:"));
		panel.add(new JTextField(24));  //JTextField() : 값 입력받기(입력창 크기)
		panel.add(new JLabel("PW:"));
		panel.add(new JTextField(24));

		this.add(panel);
		this.add(new JButton("로그인"), BorderLayout.EAST);
	}

	public static void main(String[] args) {
		new LoginFrame().setVisible(true); //창 보이기
	}
}
