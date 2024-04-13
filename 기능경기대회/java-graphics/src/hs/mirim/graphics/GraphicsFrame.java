package hs.mirim.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsFrame extends JFrame {
	public GraphicsFrame() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(2); //dispose 자원 할당 해제 -> 깔끔히 종료
		
		add(new JPanel() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				
				//그림이 그려지는 부분을 부드럽게 실행하여 그림
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				
				g.setColor(Color.RED);
				g.drawLine(10, 10, 50, 50);
				g.fillRect(100, 100, 20, 50);
				g.drawRect(100, 100, 20, 50);
				
				g.fillOval(150, 50, 150, 150);
			}
		});
	}
	public static void main(String[] args) {
		new GraphicsFrame().setVisible(true);
	}
}
