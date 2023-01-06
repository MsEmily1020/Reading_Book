package notepad;

import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
	JMenuItem[] item = new JMenuItem[7];
	JTextArea area = new JTextArea();

	String[] itemName = "새로만들기,열기,저장,나가기,글꼴모양,글꼴크기,글꼴색".split(",");
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

		//File menu
		for (int i = 0; i < item.length; i++) {
			item[i] = new JMenuItem(itemName[i]);
			item[i].addActionListener(this);
			if(i < 4) menu.add(item[i]);
			else format.add(item[i]);
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
				//글꼴모양
				else if(i == 4) {
					setFontShape();
				}
				//글꼴크기
				else if(i == 5) {
					setFontSize();
				}
				//글꼴색
				else if(i == 6) {
					setFontColor();
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
	
	//글꼴모양
	public void setFontShape() {
		
	}
	
	//글꼴크기
	public void setFontSize() {
		
	}
	
	//글꼴색
	public void setFontColor() {
		
	}
}
