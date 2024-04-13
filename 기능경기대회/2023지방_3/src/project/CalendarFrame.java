package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarFrame extends BaseFrame {
	public static int month;
	public static int day;
	
	public CalendarFrame() {
		super("날짜선택", 500, 500);
		
		setLayout(null);
		var dateLb = new JLabel("2023년 04월", 0);
		dateLb.setFont(new Font("맑은 고딕", 1, 13));
		add(setBounds(dateLb, 0, 20, 490, 40));
		
		var calPn = new JPanel(new GridLayout(6, 7));
		add(setBounds(calPn, 0,	100, 500, 400));
		
		calPn.setBackground(Color.white);
		
		String[] day = "일,월,화,수,목,금,토".split(",");
		for (int i = 0; i < day.length; i++) {
			var lb = new JLabel(day[i]);
			add(setBounds(lb, 40 + i * 65, 60, 20, 10));
			
			if(i == 0) {
				lb.setForeground(Color.red);
			}
			
			if(i == day.length - 1) {
				lb.setForeground(Color.blue);
			}
			
		}
		var left = new JLabel("◀");
		var right = new JLabel("▶");
		
		add(setBounds(left, 180, 25, 40, 30));
		add(setBounds(right, 300, 25, 40, 30));
		
		left.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		right.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}	
		});
		
		
	}

	public static void main(String[] args) {
		new CalendarFrame().setVisible(true);
	}
}
