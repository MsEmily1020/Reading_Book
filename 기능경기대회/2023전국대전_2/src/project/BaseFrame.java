package project;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class BaseFrame extends JFrame {
	static Connection con;
	static Statement stmt;

	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/에더랜드?serverTimezone=UTC", "user", "1234");
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	JPanel page, main;
	JPanel[] jp = new JPanel[30];
	JLabel[] lb = new JLabel[30];
	JButton[] btn = new JButton[30];
	JTextField[] tf = new JTextField[30];
	JCheckBox[] ch = new JCheckBox[30];
	JComboBox[] cb = new JComboBox[30];
	JRadioButton[] rb = new JRadioButton[30];

	String[] jcompArr = ",JLabel,JButton,JTextField,JCheckBox,JComboBox,JRadioButton".split(",");
	String[] valArr = ",lb[],btn[],tf[],ch[],cb[],rb[]".split(",");

	String jcomp, val;

	JComponent comp;

	int startX, startY, endX, endY, width, height;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static ArrayList schlist = new ArrayList();

	public static HashMap<String, JFrame> list = new HashMap<>();

	public BaseFrame(String title, int w, int h) {
		setTitle(title);
		setSize(w, h);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(2);
		setLayout(null);

		try {
			setIconImage(ImageIO.read(new File("datafiles/logo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		setCursor(new Cursor(CROSSHAIR_CURSOR));

		add(main = setBounds(new JPanel(null), 0, 0, w, h));
		
		main.setBackground(Color.WHITE);
		
		main.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				try {
					jcomp = jcompArr[e.getKeyChar() - 48];
					val = valArr[e.getKeyChar() - 48];

					comp = (JComponent) Class.forName("javax.swing." + jcomp).newInstance();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				startX = e.getX() - (e.getX() % 5);
				startY = e.getY() - (e.getY() % 5);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				endX = e.getX() - (e.getX() % 5);
				endY = e.getY() - (e.getY() % 5);
				
				width = Math.abs(startX - endX);
				height = Math.abs(startY - endY);

				comp.setBounds(startX -= 5, startY -= 30, width, height);
				
				main.add(comp);
				
				if (jcomp.equals("JLabel") || jcomp.equals("JPanel")) {
					comp.setBorder(new LineBorder(Color.black));
				}
				
				main.revalidate();
				main.repaint();
				
				main.setFocusable(true);
				main.requestFocus();
				
				System.out.println("main.add(setBounds(" + val + " = new " + jcomp + "(), " + startX + ", " + startY + ", " + width + ", " + height + "));");
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(title.equals("메인")) dispose();
				else changeFrame(new 메인());
			}
		});
	}

	public <T extends JComponent> T setBounds(T comp, int x, int y, int w, int h) {
		comp.setBounds(x, y, w, h); 
		return comp;
	}

	public static void showInfo(String m) {
		JOptionPane.showMessageDialog(null, m, "정보", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void showErr(String m) {
		JOptionPane.showMessageDialog(null, m, "에러", JOptionPane.ERROR_MESSAGE);
	}

	public static ResultSet resultSet(String sql, Object... p) throws Exception {
		var pst = con.prepareStatement(sql);
		for (int i = 0; i < p.length; i++) pst.setObject(i + 1, p[i]);
		return pst.executeQuery();
	}

	public static void update(String sql, Object... p) throws Exception {
		var pst = con.prepareStatement(sql);
		for (int i = 0; i < p.length; i++) pst.setObject(i + 1, p[i]);
		pst.executeUpdate();
	}

	public ImageIcon getIcon(String path, int w, int h) {
		return new ImageIcon(Toolkit.getDefaultToolkit().getImage(path).getScaledInstance(w, h, Image.SCALE_SMOOTH));
	}

	public void changeFrame(JFrame frame) {
		dispose();
		list.put(frame.getTitle(), frame);
		frame.setVisible(true);
		main.requestFocus();
	}
	
	public JLabel createLB(JLabel lb, Font font) {
		lb.setFont(font);
		return lb;
	}
	
	public JButton actbtn(String text, ActionListener action) {
		JButton jb = new JButton(text);
		jb.addActionListener(action);
		return jb;
	}
	
	public void changeWhite(JPanel jp) {
		for (Component comp : jp.getComponents()) {
			if (comp instanceof JButton) return;
//			{
//				comp.setForeground(getBackground() == comp.getBackground() ? Color.BLACK : getBackground()); 
//			}
			comp.setBackground(Color.WHITE);
//			comp.setFont(new Font("맑은 고딕", 1, 12));
			jp.repaint();
		}
	}
}

class RoundLabel extends JLabel {
	public RoundLabel(String string) {
		setText(string);
	}

	@Override
	public void paintComponents(Graphics g) {
		g.setColor(Color.pink);
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 60);
		g.setColor(Color.white);
		g.setFont(new Font("HY견고딕", 1, 14));
		g.drawString(getText(), getWidth() / 2 - 5, 20);
	}
}

class RoundButton extends JButton {
	public RoundButton(String string, ActionListener action) {
		setText(string);
		addActionListener(action);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.pink);
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 60);
		g.setColor(Color.white);
		g.setFont(new Font("HY견고딕", 1, 14));
		g.drawString(getText(), getWidth() / 2 - 14, 20);
	}
}
