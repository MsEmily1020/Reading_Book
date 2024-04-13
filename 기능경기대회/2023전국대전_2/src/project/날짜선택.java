package project;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class 날짜선택 extends BaseFrame {
	
	Calendar cal = Calendar.getInstance();
	
	Color[] c = {Color.BLUE, Color.RED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK};
	
	public 날짜선택() {
		super("날짜선택", 800, 800);
		
		main.add(setBounds(btn[0] = actbtn("◀", e -> 날짜업데이트(-1)), 315, 0, 40, 40));
		main.add(setBounds(btn[1] = actbtn("▶", e -> 날짜업데이트(1)), 435, 0, 40, 40));
		main.add(setBounds(lb[0] = new JLabel("10월", 0), 350, 5, 90, 40));
		main.add(setBounds(jp[0] = new JPanel(new GridLayout(1, 7, 5, 5)), 10, 45, 770, 35));
		main.add(setBounds(jp[1] = new JPanel(new GridLayout(6, 7, 5, 5)), 10, 85, 770, 670));
		
		// 요일 label
		String[] str = "일,월,화,수,목,금,토".split(",");
		for (String string : str) {
			jp[0].add(new RoundLabel(string));
		}
		
		// date jp 생성
		for (int i = 0; i < 42; i++) {
			JPanel jp = new JPanel(null);
			jp.add(setBounds(new JLabel(), 5, 5, 35, 30));
			jp.add(setBounds(new JLabel("*종일권"), 35, 25, 95, 15));
			jp.add(setBounds(new JLabel("*오전권"), 35, 50, 95, 15));
			jp.add(setBounds(new JLabel("*야간권"), 35, 75, 95, 15));
			jp.getComponent(0).setForeground(Color.BLACK); // 일
			jp.getComponent(1).setForeground(Color.GRAY); // 종일권
			jp.getComponent(2).setForeground(Color.YELLOW); // 오전권
			jp.getComponent(3).setForeground(Color.BLUE); // 야간권
			jp.getComponent(0).setFont(new Font("HY견고딕", 1, 24));
			jp.setBorder(new LineBorder(Color.BLACK));
			this.jp[1].add(jp); // gridlayout이므로 일일이 location 잡을 필요 x
		}
		
		changeWhite(main);
		lb[0].setFont(new Font("HY견고딕", 1, 24));
		btn[0].setFont(new Font("HY견고딕", 1, 24));
		btn[1].setFont(new Font("HY견고딕", 1, 24));
		btn[0].setMargin(new Insets(0, 0, 0, 0));
		btn[1].setMargin(new Insets(0, 0, 0, 0));
		btn[0].setBorder(null);
		btn[1].setBorder(null);
		btn[0].setBackground(Color.WHITE);
		btn[1].setBackground(Color.WHITE);
		btn[0].setForeground(Color.PINK);
		btn[1].setForeground(Color.PINK);
		jp[0].setBackground(Color.WHITE);
		jp[1].setBackground(Color.WHITE);
		
		날짜업데이트(0); // 기본 10월달
	}
	
	public void 날짜업데이트(int day) {
		try {
			int m = (Integer.parseInt(lb[0].getText().replace("월", "")) + day); // 월 +1 인지 -1인지
			btn[0].setEnabled(m != 1); // 1이면 왼쪽버튼 클릭 안되게
			btn[1].setEnabled(m != 12); // 12이면 오른쪽 버튼 클릭 안되게
			lb[0].setText(m + "월"); // 몇월인지 (+1, -1) 한 후
			cal.setTime(sdf.parse("2023-" + m + "-01")); // 현재월 1일 parse하기
			int w = cal.get(Calendar.DAY_OF_WEEK); // 요일 (1 : 일, 2 : 월, 3 : 화, 4 : 수, 5 : 목, 6 : 금, 7 : 토)
			
			cal.add(Calendar.DATE, -w); // 현재 날짜 포함해서 요일만큼 뺀다면 이전 date까지 나오면서 꽉 채운 달력 완성 시킬 수 있음.
			
			for (Component comp : jp[1].getComponents()) { // date 받아와서 for문 돌리기
				JPanel jp = (JPanel) comp; // 하나하나 date panel 받아오기
				cal.add(Calendar.DATE, 1); // date 1씩 더하기

				comp.setName(sdf.format(cal.getTime())); // 액션 처리를 위함.
				
				jp.setBackground(resultSet("SELECT * FROM 에더랜드.ticket where uno = 1 and date = ?", comp.getName()).next() ? Color.PINK : Color.WHITE);
				
				((JLabel) jp.getComponent(0)).setText(cal.get(Calendar.DATE) + ""); // date set
				
				// 현재 월일이 아닌 date라면 gray로, 현재 월일이라면 검은색, 빨강색, 파랑색으로 글자색 변경
				// month - 1 : month는 1이 빼진 상태에서 나오기 때문에 -1을 해서 비교해야 함.
				((JLabel) jp.getComponent(0)).setForeground((cal.get(Calendar.MONTH) != m - 1 ? Color.GRAY : c[cal.get(Calendar.DAY_OF_WEEK) % 7]));
				((JLabel) jp.getComponent(1)).setVisible(cal.get(Calendar.MONTH) == m - 1);
				((JLabel) jp.getComponent(2)).setVisible(cal.get(Calendar.MONTH) == m - 1);
				((JLabel) jp.getComponent(3)).setVisible(cal.get(Calendar.MONTH) == m - 1 && m >= 4 && m <= 10);
			}   
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new 날짜선택().setVisible(true);
	}
}
