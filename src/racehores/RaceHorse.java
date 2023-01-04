package racehores;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RaceHorse extends JFrame {
	JLabel[] horses = new JLabel[3];
	HorseThread[] hts = new HorseThread[horses.length];
	int[] winnerIndex = new int[horses.length];
	int index;
	String[] comboStr = "1번: horse,2번: human,3번: bird".split(",");
	JComboBox<String> combo = new JComboBox<String>(comboStr);
	ArrayList<BettingPerson> btList = new ArrayList<BettingPerson>();
	JTextField tf = new JTextField(10);
	int betingIndex;

	public RaceHorse() {		
		JPanel pan = new JPanel(null);
		pan.setBackground(Color.white);
		JPanel panN = new JPanel();
		panN.setBackground(Color.white);
		
		JLabel lineLbl = new JLabel(new ImageIcon("image/line.png"));
		lineLbl.setBounds(540, 27, 5, 420);
		JLabel flagLbl = new JLabel(new ImageIcon("image/flag.png"));
		flagLbl.setBounds(530, 5, 20, 27);
		pan.add(lineLbl);
		pan.add(flagLbl);
		
		JButton btnBeting = new JButton("게임배팅");
		JButton btnStart = new JButton("게임시작");
		btnBeting.addActionListener(btnL);
		btnStart.addActionListener(btnL);
		panN.add(tf);
		panN.add(combo);
		panN.add(btnBeting);
		panN.add(btnStart);
		
		for (int i = 0; i < horses.length; i++) {
			horses[i] = new JLabel(new ImageIcon("image/img" + (i+1) + ".gif"));
			horses[i].setLocation(0, 50 + i * 120);
			horses[i].setSize(100, 100);
			pan.add(horses[i]);
		}
		
		add(pan, "Center");
		add(panN, "North");
		setTitle("경주마게임");
		setDefaultCloseOperation(2);
		setSize(600, 500);
		setLocationRelativeTo(null);
		setResizable(false);		
	}

	public static void main(String[] args) {
		new RaceHorse().setVisible(true);
	}
	
	ActionListener btnL = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			switch (e.getActionCommand()) {
			case "게임배팅":
				BettingPerson btPs = new BettingPerson();
				btPs.setName(tf.getText());
				btPs.setBetting(combo.getSelectedIndex());
				btList.add(btPs);
				break;
			case "게임시작":
				for (int i = 0; i < horses.length; i++) {
					HorseThread t = new HorseThread(horses[i], i);
					t.start();
				}
				break;
			}
		}
	};

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
				if(lblHorse.getX()>=540) {
					winnerIndex[index++] = horseIndex;
					if(index == horses.length-1) {
						JOptionPane.showMessageDialog(RaceHorse.this, (winnerIndex[0]+1)+"말이 우승!!!");
						if(winnerIndex[0]==btList.get(0).getBetting() && winnerIndex[0] != btList.get(1).getBetting())
							JOptionPane.showMessageDialog(RaceHorse.this, "축하합니다. " + btList.get(0).getName() + "님이 배팅에 성공하였습니다.");
						else if(winnerIndex[0] == btList.get(0).getBetting())
							JOptionPane.showMessageDialog(RaceHorse.this, "두 분다 배팅에 성공하셨군요.");
						else if(winnerIndex[0] == btList.get(1).getBetting() && winnerIndex[0] != btList.get(0).getBetting())
							JOptionPane.showMessageDialog(RaceHorse.this, "축하합니다. " + btList.get(1).getName() + "님이 배팅에 성공하였습니다.");
						else	
							JOptionPane.showMessageDialog(RaceHorse.this, "두 분다 배팅에 성공 못하셨어요 ㅠㅠ");
						index = 0;
						for (int i = 0; i < horses.length; i++)
							horses[i].setLocation(0, horses[i].getY());
						btList = new ArrayList<BettingPerson>();
					}
					break;
				}
				
				try {
					Random random = new Random();
					sleep(10 * random.nextInt(10));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
		}
	}
}
