package project;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class BaseFrame extends JFrame {
	static Connection con;
	static Statement stmt;
	static ResultSet rs;
	
	public static HashMap<Integer, ArrayList<String>> qList = new HashMap();
	
	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/vitamin?serverTimezone=UTC", "root", "1234");
			stmt = con.createStatement();
			
			rs = getResult("select * from question");
			for (int i = 1; rs.next(); i++) {
				ArrayList<String> arr = new ArrayList();
				var rs1 = getResult("select * from item where q_no = ?", i);
				while(rs1.next()) arr.add(rs1.getString("i_detail"));
				qList.put(i, arr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	JComponent comp;

	JPanel main;
	JPanel[] pn = new JPanel[200];
	JLabel[] lb = new JLabel[200];
	JButton[] btn = new JButton[200];
	JTextField[] tf = new JTextField[200];
	JCheckBox[] ch = new JCheckBox[200];
	JComboBox[] cb = new JComboBox[200];

	String[] jcompArr = ",JLabel,JButton,JTextField,JCheckBox,JComboBox,JPanel".split(",");
	String[] valArr = ",lb[],btn[],tf[],ch[],cb[],pn[]".split(",");

	String jcomp, val;
	int startX, startY, endX, endY, width, height;
	
	public static int userId;
	public static String userName;
	public static int userAge;
	public static String userGender;
	
	public static String storeName;
	public static String storeAddress;

	public static HashMap<String, JFrame> list = new HashMap<>();

	public BaseFrame(String title, int w, int h) {
		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);
		setLayout(null);

		setCursor(new Cursor(CROSSHAIR_CURSOR));
		add(main = setBounds(new JPanel(null), 0, 0, w, h));
		main.setBackground(Color.white);

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

				System.out.println("main.add(setBounds(" + val + " = new " + jcomp + "(), " + startX + ", " + startY
						+ ", " + width + ", " + height + "));");
			}
		});

		main.setFocusable(true);
		main.requestFocus();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (title.equals("login") || title.equals("main"))
					dispose();
				else
					if(유저메인.userId > 0) changeFrame(new 유저메인());
					else changeFrame(new 약국메인());
			}
		});
	}

	public void changeFrame(JFrame frame) {
		dispose();
		list.put(frame.getTitle(), this);
		frame.setVisible(true);
		main.requestFocus();
	}

	public static void showInfo(String m) {
		JOptionPane.showMessageDialog(null, m, "정보", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void showErr(String m) {
		JOptionPane.showMessageDialog(null, m, "경고", JOptionPane.ERROR_MESSAGE);
	}

	public <T extends JComponent> T setBounds(T comp, int x, int y, int w, int h) {
		comp.setBounds(x, y, w, h);
		return comp;
	}
	
	public <T extends JComponent> T setBounds(T comp, int w, int h) {
		comp.setPreferredSize(new Dimension(w, h));
		return comp;
	}

	public static ResultSet getResult(String sql, Object... p) throws Exception {
		var pst = con.prepareStatement(sql);
		for (int i = 0; i < p.length; i++) {
			pst.setObject(i + 1, p[i]);
		}

		return pst.executeQuery();
	}

	public void update(String sql, Object... p) throws Exception {
		var pst = con.prepareStatement(sql);
		for (int i = 0; i < p.length; i++) {
			pst.setObject(i + 1, p[i]);
		}

		pst.executeUpdate();
	}

	public static ImageIcon getIcon(String path, int w, int h) {
		return new ImageIcon(Toolkit.getDefaultToolkit().getImage(path).getScaledInstance(w, h, Image.SCALE_SMOOTH));
	}

	public static JButton actionbtn(String text, ActionListener action) {
		JButton btn = new JButton(text);
		btn.addActionListener(action);
		return btn;
	}

	public void setComponent(JPanel jp) {
		for (Component comp : jp.getComponents()) {
			if (comp instanceof JButton) {
				((JButton) comp).setMargin(new Insets(0, 0, 0, 0));
				comp.setCursor(new Cursor(HAND_CURSOR));
			}

			if (comp instanceof JTextField) {
				JTextField tf = (JTextField) comp;
				tf.setName(tf.getText());
				tf.setForeground(Color.gray);
				tf.setBorder(new MatteBorder(0, 0, 1, 0, Color.lightGray));
				tf.addFocusListener(new FocusListener() {
					@Override
					public void focusLost(FocusEvent e) {
						tf.setForeground(tf.getText().isEmpty() ? Color.gray : Color.black);
						tf.setText(tf.getText().isEmpty() ? tf.getName() : tf.getText());
					}

					@Override
					public void focusGained(FocusEvent e) {
						tf.setText("");
						tf.setForeground(Color.black);
					}
				});
			}

			((JComponent) comp).setBorder(null);
			comp.setBackground(Color.white);
			comp.setFont(new Font("맑은 고딕", 1, 12));
		}
	}
}
