/*프로그래밍 공부
 * 1. 코딩 능력(지문 문장을 논리를 변환하여 프로그래밍 언어로 표현하는 능력) -> 프로그래머스 코딩 문제
 * 2. 객체 지향 패러다임 이해(설계) 능력(실제 세계 사물을 코딩 세계 class 등으로 표현) -> 프로젝트 과제(class, Interface 이해, 어떤걸 extends)
 * 3. 시스템 아키텍쳐를 구성하는 능력(백엔드 서버, UI App 간의 구조 구성, 어떻게 통신) -> 프로젝트 과제의 리더
 * 
 * PascalCase : 각 단어의 첫 글자를 대문자 -> 클래스 이름
 * camelCase : 첫 단어는 첫 글자를 소문자, 그 다음 단어부터는 첫 글자 대문자 -> 변수명, 함수이름
 * 변수/Class 이름은 명사의 의몰 쓰여야함.
 * 함수 이름 동작의 액션의 의미로 쓰여야함.(동사로 시작)
 * snake_case : 단어마다 _ 구분(소문자)
 * SNAKE_CASE : 상수 (대문자)
 * 
 * 인터페이스(Interface) : 서로 연결을 위한 하나의 규격, 규칙(어떻게 연결될 것인지 약속된...)
 *  - 정해진 규격이 있음(어떻게 연결할지 미리 약속된 스펙)
 *  - 규격이 지키지 않으면 연결x
 *  - 규격을 지켜서 상품 개발하면 어떤 기기든 연결 가능
 *  - 예시) HDMI, 랜선, WIFI, 충전기, 갤럭시/아이폰 무선 충전
 *  - 인터페이스를 고려한 제품은 서로 연결 가능
 */

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CalendarFrame extends JFrame {
	public CalendarFrame() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		// BorderLayout 기본 레이아웃
		// GridLayout 2차원 맵 x, y좌표를 지도처럼 배치하는 레이아웃
		
		/* BorderLayout
		add(new JButton("A"), BorderLayout.NORTH);
		add(new JButton("B"), BorderLayout.SOUTH);
		*/
		
		setLayout(new GridLayout(7, 7)); //행, 열, 사이 간격(가로 gap, 세로 gap)
		
		//버튼 갯수가 행 갯수에 채워지지 않으면 행에서만 추가
		//over되면 행은 고정 열은 무한 생성
		
		var weekdays = new String[] {
				"일", "월", "화", "수", "목", "금", "토"
		};
		
		/*
		for(String weekday : weekdays) {
			add(new JLabel(weekday));
		}*/
		
		Color[] colorList = {
				Color.RED,
				Color.BLACK,
				Color.BLACK,
				Color.BLACK,
				Color.BLACK,
				Color.BLACK,
				Color.BLUE
		};
		
		for(int i = 0; i < weekdays.length; i++) {
			var lb = new JLabel(weekdays[i], JLabel.CENTER);
			lb.setForeground(colorList[i]);
			add(lb);
		}

		LocalDate now = LocalDate.now(); //현재 날짜
		LocalDate startDate = LocalDate.of(now.getYear(), now.getMonth(), 1);
		LocalDate firstDate = startDate.minusDays((startDate.getDayOfWeek().ordinal() + 1) % 7);
		
		for (int i = 0; i < 42; i++) {
			
			if(firstDate.getMonth() == now.getMonth()) {
				var button = new JButton("" + firstDate.getDayOfMonth());
				
				if(firstDate.compareTo(now) < 0) {
					button.setEnabled(false);
				}
				
				//Event : 무언가 사건이 발생하는 (원인) > 동작 / EventListener : 컴퓨터 이벤트가 발생하면 함수를 호출
				//컴퓨터 이벤트 -> 입력(키보드, 마우스, 타이머)
				//Input 기기 Device(키보드, 마우스, 랜카드, 타이머)
				//T자형 인재가 O자형으로 바뀐다(하나의 개념이 여러 개념과 연관되어 인재가 됨)
				
				
				//람다표현식(익명클래스x) : 무조건 함수가 1개만 있는 인터페이스만
				//(하나의 인터페이스를 함수로 표현식(함수형 인터페이스)
				//화살표 표현식, 람다 표현식
		
				button.addActionListener(e -> {
					JOptionPane.showMessageDialog(null, "클릭!");
				});
				
				button.setForeground(colorList[i % 7]);
				add(button);
			}
			
			else {
				add(new JPanel());
			}
			
			firstDate = firstDate.plusDays(1);
		}
		
	}
	
	public static void main(String[] args) {
		var frame = new CalendarFrame();
		frame.setVisible(true);
	}
}
