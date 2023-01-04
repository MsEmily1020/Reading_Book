package racehores;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RaceHorse extends JFrame {
	JLabel[] horses = new JLabel[3];
	JButton start = new JButton("게임하기");
	HorseThread[] hts = new HorseThread[horses.length];
	int[] winnerIndex = new int[horses.length];
	int index;

	public RaceHorse() {		
		JPanel pan = new JPanel(null);

		for (int i = 0; i < horses.length; i++) {
			horses[i] = new JLabel(new ImageIcon("image/img"+(i+1)+".gif"));
			horses[i].setLocation(0, 50 + i * 120);
			horses[i].setSize(100, 100);
			pan.add(horses[i]);
		}

		add(pan, "Center");
		add(start ,"North");

		setTitle("경주마게임");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 500);
		setLocationRelativeTo(null);
		setResizable(false);

		start.addActionListener(e -> {
			for (int i = 0; i < horses.length; i++) {
				hts[i] = new HorseThread(horses[i], i);
				hts[i].start();
			}
		});
	}

	public static void main(String[] args) {
		new RaceHorse().setVisible(true);
	}

	public class HorseThread extends Thread{
		JLabel lblHorse;
		int randomValue;
		int horseIndex;

		public HorseThread(JLabel lblHorse, int horseIndex) {
			this.lblHorse = lblHorse;
			this.horseIndex = horseIndex;
		}

		@Override
		public void run() {
			while (true) {
				lblHorse.setLocation(lblHorse.getX()+5, lblHorse.getY());
				if(lblHorse.getX() == 500) {
					winnerIndex[index++] = horseIndex;
					if(horseIndex == horses.length-1) {
						int again = JOptionPane.showConfirmDialog(RaceHorse.this, "축하합니다. " + (winnerIndex[0] + 1) + "이 우승!!!", "다시 플레이 하시겠습니까?", JOptionPane.YES_NO_OPTION);
						if(again == JOptionPane.YES_OPTION) {
							dispose();
							new RaceHorse().setVisible(true);
						}
						else System.exit(0);
					}
					break;
				}
				try {
					Random random = new Random();
					sleep(5 * random.nextInt(10));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}