package bmi.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bmi.vo.BMIVO;

public class BMIView extends JFrame {
	JTextField[] tf = new JTextField[2];
	JButton result = new JButton("결과확인");
	String[] header = "체질량지수(BMI),키 : ,체중 : ,cm,kg,당신의 키는 ,이고 체중은 ,이므로,체중입니다.".split(",");
	JLabel lblIcon;
	JLabel lblResult;
	
	public BMIView() {
		add(new PanelAbove(),"North");
		add(new PanelBelow(),"Center");
		setTitle("BMI(Body Measure Index)");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 600);
		setLocationRelativeTo(null);
	}
	
	class PanelAbove extends JPanel {
		public PanelAbove() {
			setBackground(new Color(204, 204, 255));
			setLayout(new BorderLayout());
			JLabel title = new JLabel(header[0],JLabel.CENTER);
			title.setFont(new Font("맑은 고딕", Font.BOLD, 30));
			add((title), BorderLayout.NORTH);
			
			JPanel pCenter = new JPanel(new BorderLayout());
			
			JPanel[] pan = new JPanel[3];
			for (int i = 0; i < pan.length; i++) pan[i] = new JPanel();
			
			pCenter.add(pan[0] , "North");
			pCenter.add(pan[1] , "Center");
			
			for(int i = 0; i < 2; i++) {
				pan[0].add(new JLabel(header[i * 2 + 1]));
				tf[i] = new JTextField(10);
				pan[i].add(tf[i]);
				pan[1].add(new JLabel(header[i * 2 + 2]));
			}
			pan[2].add(result);
			
			add(pCenter, "Center");
			add(pan[2], "South");
		}
	}
	
	class PanelBelow extends JPanel{
		public PanelBelow() {
			setBackground(new Color(255, 204, 229));
			
			setLayout(new BorderLayout());
			
			lblResult = new JLabel("<html>당신의 키는 _cm, 체중은 _kg이므로<br>bmi지수는 _㎏/㎡이며, __체중입니다.</html>", JLabel.CENTER);
			Font font = new Font("맑은 고딕", Font.BOLD, 20);
			lblResult.setFont(font);
			
			ImageIcon icon = new ImageIcon("images/bmi_original.jpg");
			lblIcon = new JLabel(icon, JLabel.CENTER);
			add(lblResult, "North");
			add(lblIcon, "Center");

			result.addActionListener(btnL);
		}
	}
	
	ActionListener btnL = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			BMIVO vo = new BMIVO();
			vo.setHeight(Double.parseDouble(tf[0].getText()));
			vo.setWeight(Double.parseDouble(tf[1].getText()));
			vo.setBmi();
			double bmi = vo.getBmi();

			String bmiResult = "";
			String[] bmiResul = "저,정상,과,비만,고도비만".split(",");
			String[] img = "under,normal,over,obese,extremely".split(",");
			double[] bmiCnt = {18.5, 24.9, 29.9, 34.9, 0}; 
			for (int i = 0; i < bmiResul.length; i++) {
				if(i < 4 && bmi <= bmiCnt[i]) {
					bmiResult = bmiResul[i];
					if(bmiResult.equals(bmiResul[i])) lblIcon.setIcon(new ImageIcon("images/" + img[i] + ".jpg")); 
					break;
				}
				else bmiResult = bmiResul[4];
				lblIcon.setIcon(new ImageIcon("images/" + img[i] + ".jpg")); 
			}
			
			lblResult.setText("<html><center>당신의 키는 " + vo.getHeight() + "cm, 체중은 " + vo.getWeight() + "kg이므로<br>bmi지수는 " + String.format("%.2f", bmi) + "㎏/㎡이며, " + bmiResult + "체중입니다.</center></html>");
		}
	};
}