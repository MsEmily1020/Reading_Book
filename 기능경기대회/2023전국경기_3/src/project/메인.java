package project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class 메인 extends BaseFrame {

	ButtonGroup group = new ButtonGroup();

	public 메인() {
		super("메인", 750, 600);

		main.add(setBounds(jp[0] = new JPanel(), 0, 0, 750, 250));
		main.add(setBounds(jp[1] = new JPanel(), 0, 250, 750, 35));

		main.add(setBounds(lb[0] = new JLabel("전체"), 15, 290, 60, 30));

		main.add(setBounds(btn[0] = new JButton("전체"), 15, 320, 85, 30));
		main.add(setBounds(btn[1] = new JButton("상의"), 105, 320, 85, 30));
		main.add(setBounds(btn[2] = new JButton("하의"), 195, 320, 85, 30));
		main.add(setBounds(btn[3] = new JButton("신발"), 285, 320, 85, 30));
		main.add(setBounds(btn[4] = new JButton("스포츠"), 375, 320, 85, 30));
		main.add(setBounds(btn[5] = new JButton("방한"), 465, 320, 85, 30));
		main.add(setBounds(btn[6] = new JButton("아동"), 555, 320, 85, 30));
		main.add(setBounds(btn[7] = new JButton("액세서리"), 645, 320, 85, 30));

		setComponent(main);

		if (userId == 0) {
			jp[0].add(lb[1] = new JLabel(getIcon("datafiles/메인1.png", 750, 250)));
			for (int i = 0; i < 4; i++) {
				rb[i] = new JRadioButton() {
					@Override
					public void paint(Graphics g) {
						g.setColor(Color.RED);
						g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
					};
				};
				group.add(rb[i]);
				jp[1].add(rb[i]);
				
				rb[i].addActionListener(e -> {
					for (int j = 0; j < 4; j++) {
						if (e.getSource() == rb[j]) {
							lb[1].setIcon(getIcon("datafiles/메인" + (j + 1) + ".png", 750, 250));
							lb[1].revalidate();
							lb[1].repaint();
						}
					}
				});
			}
		}

		else if (userId > 0) {
			jp[0].add(lb[1] = new JLabel(getIcon("datafiles/회원1.png", 750, 250)));
		}

		else {
			jp[0].add(lb[1] = new JLabel(getIcon("datafiles/관리자1.png", 750, 250)));
		}

	}

	public static void main(String[] args) {
		new 메인().setVisible(true);
	}
}
