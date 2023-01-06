package notepad;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Notepad extends JFrame implements ActionListener {
	String[] menuName = "새로만들기,열기,저장,나가기".split(",");
	String[] formatName = "글꼴모양,글꼴크기,글꼴색".split(",");
	String[] font = "맑은고딕,굴림,돋움,10px,15px,20px,빨강,파랑,검정".split(",");
	JMenuItem[] item = new JMenuItem[menuName.length + font.length];
	JTextArea area = new JTextArea();

	public Notepad() {
		makeMenu();
		JScrollPane scroll = new JScrollPane(area);
		add(scroll);
		
		setTitle("메모장");
		setSize(800, 800);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);
	}

	public void makeMenu() {
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("File ▼");
		JMenu format = new JMenu("Format ▼");
		
		JMenu[] formatOp = new JMenu[3]; //Format - 글꼴모양, 글꼴크기, 글꼴색

		//File
		for (int i = 0; i < menuName.length; i++) {
			item[i] = new JMenuItem(menuName[i]);
			item[i].addActionListener(this);
			menu.add(item[i]);
		}
		
		//Format
		for (int i = 0; i < 3; i++) {
			formatOp[i] = new JMenu(formatName[i]);
			format.add(formatOp[i]);
		}
		
		//Format - shape
		for (int i = menuName.length; i < menuName.length + 3; i++) {
			item[i] = new JMenuItem(font[i - menuName.length]);
			item[i].addActionListener(this);
			formatOp[0].add(item[i]);
		}
		
		//Format - size
		for (int i = menuName.length + 3; i < menuName.length + 6; i++) {
			item[i] = new JMenuItem(font[i - menuName.length]);
			item[i].addActionListener(this);
			formatOp[1].add(item[i]);
		}
		
		//Format - color
		for (int i = menuName.length + 6; i < menuName.length + 9; i++) {
			item[i] = new JMenuItem(font[i - menuName.length]);
			item[i].addActionListener(this);
			formatOp[2].add(item[i]);
		}
		
		bar.add(menu);
		bar.add(format);
		
		
		setJMenuBar(bar);
	}

	public static void main(String[] args) {
		new Notepad().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < item.length; i++) {
			if(e.getSource() == item[i]) {
				//새로만들기
				if(i == 0) {
					area.setText("");
				}
				//열기
				else if(i == 1) {
					readFile();
				}
				//저장
				else if(i == 2) {
					saveFile();
				}
				//나가기
				else if(i == 3){
					System.exit(0);
				}
				//글꼴모양 - 맑은 고딕
				else if(i == 4) {
					area.setFont(new Font("맑은 고딕", Font.PLAIN, area.getFont().getSize()));
				}
				//글꼴모양 - 굴림
				else if(i == 5) {
					area.setFont(new Font("굴림", Font.PLAIN, area.getFont().getSize()));
				}
				//글꼴모양 - 돋움
				else if(i == 6) {
					area.setFont(new Font("돋움", Font.PLAIN, area.getFont().getSize()));
				}
				//글꼴크기 - 10px
				else if(i == 7) {
					area.setFont(new Font(area.getFont().getFamily(), Font.PLAIN, 10));
				}
				//글꼴크기 - 15px
				else if(i == 8) {
					area.setFont(new Font(area.getFont().getFamily(), Font.PLAIN, 15));
				}
				//글꼴크기 - 20px
				else if(i == 9) {
					area.setFont(new Font(area.getFont().getFamily(), Font.PLAIN, 20));
				}
				//글꼴색 - 빨강
				else if(i == 10) {
					area.setForeground(Color.red);
				}
				//글꼴색 - 파랑
				else if(i == 11) {
					area.setForeground(Color.blue);
				}
				//글꼴색 - 검정
				else if(i == 12) {
					area.setForeground(Color.black);
				}
			}
		}
	}
	
	//열기
	public void readFile() {
		FileDialog dialog = new FileDialog(this, "File Open" ,FileDialog.LOAD);
		dialog.setVisible(true);
		try {
			FileReader reader = new FileReader(new File(dialog.getDirectory() + "/" + dialog.getFile()));
			BufferedReader bfReader = new BufferedReader(reader);
			String line = "";
			while((line = bfReader.readLine()) != null) area.append(line + "\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//저장
	public void saveFile() {
		FileDialog dialog = new FileDialog(this, "File save", FileDialog.SAVE);
		dialog.setVisible(true);
		try {
			FileWriter writer = new FileWriter(new File(dialog.getDirectory() + "/" + dialog.getFile()));
			BufferedWriter bfWriter = new BufferedWriter(writer);
			bfWriter.write(area.getText());
			bfWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
