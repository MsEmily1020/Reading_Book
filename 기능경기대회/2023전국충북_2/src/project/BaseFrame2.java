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
import java.sql.SQLException;
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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class BaseFrame2 extends JFrame {
	static Connection con;
	static Statement stmt;

	public JScrollPane jsp;
	public JPanel page, main;
	public JPanel[] jp = new JPanel[30];
	public JLabel[] lb = new JLabel[30];
	public JButton[] btn = new JButton[30];
	public JTextField[] tf = new JTextField[30];
	public JComboBox[] com = new JComboBox[30];
	public JCheckBox[] ch = new JCheckBox[30];
	public JRadioButton[] rb =new JRadioButton[30];

//	public static ArrayList schlist = new ArrayList();

	public static String aaa;
	public static String jop;
	public static JComponent comp;

	public static HashMap<JPanel, ResultSet> product = new HashMap<JPanel, ResultSet>();
	public static HashMap<String, JFrame> list = new HashMap<String, JFrame>();

	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/2023전국_2?serverTimezone=UTC", "user", "1234");
			stmt = con.createStatement();
		} catch (SQLException e) {
			//			e.printStackTrace();
		}
	}

	public BaseFrame2(String title, int w, int h) {
		setTitle(title);
		setSize(w, h);
		setLayout(null);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);

//		for
		
		setCursor(new Cursor(CROSSHAIR_CURSOR));
		add(main = setBounds(new JPanel(null), 0, 0, w, h));

		main.setBackground(Color.WHITE);

		main.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				try {
					String[] asdf = ",JLabel,JButton,JTextField,JComboBox,JPanel".split(",");
					String[] as = ",lb[],btn[],tf[],cbx[],jp[]".split(",");

					jop = asdf[Integer.parseInt(e.getKeyChar()+"")];
					aaa = as[Integer.parseInt(e.getKeyChar()+"")];

					Class c = Class.forName("javax.swing." + jop);
					comp = (JComponent) c.newInstance();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		addMouseListener(new MouseAdapter() {
			int startX, endX;
			int startY, endY;


			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);

				startX = e.getX() - (e.getX() % 5);
				startY = e.getY() - (e.getY() % 5);
			}

			@Override
			public void mouseReleased(MouseEvent e){
				super.mouseReleased(e);

				endX = e.getX() - (e.getX() % 5);
				endY = e.getY() - (e.getY() %  5);

				int width = Math.abs(startX - endX);
				int height = Math.abs(startY - endY);

				comp.setBounds(startX - 5, startY - 30, width, height);

				main.add(comp);

				if (jop.equals("JLabel") || jop.equals("JPanel")) {
					comp.setBorder(new LineBorder(Color.BLACK));
				}

				main.revalidate();
				main.repaint();

				main.setFocusable(true);
				main.requestFocus();

				System.out.println("main.add(setBounds(" + aaa + " = new " + jop + "(), " + (startX - 5) + ", " + (startY - 30) + ", " + width + ", " + height + "));");
			}

		});
		main.setFocusable(true);
		main.requestFocus();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(title.equals("메인")) {
					dispose();
				} else if(!title.equals("메인")) {
					changeFrame(new A메인());
				}
			}
		});

	}
	public <T extends JComponent> T setBounds(T comp, int x, int y, int w, int h) {
		comp.setBounds(x, y, w, h); 
		return comp;
	}
	public <T extends JComponent> T setBounds(T comp, int w, int h) {
		comp.setPreferredSize(new Dimension(w, h)); 
		return comp;
	}

	public JLabel createLB(JLabel lb, Font font) {
		lb.setFont(font);
		return lb;
	}

	public static void showInfo(String m) {
		JOptionPane.showMessageDialog(null, m, "정보", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void showErr(String m) {
		JOptionPane.showMessageDialog(null, m, "에러", JOptionPane.ERROR_MESSAGE);
	}

	public JButton actbtn(String text, ActionListener action) {
		JButton jb = new JButton(text);
		jb.addActionListener(action);
		return jb;
	}

	public static ResultSet getResult(String sql, Object...p) throws Exception {
		var pst = con.prepareStatement(sql);
		for (int i = 0; i < p.length; i++) 
			pst.setObject(i + 1, p[i]);

		return pst.executeQuery();
	}

	public static void update(String sql, Object...p) throws Exception {
		var pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		for (int i = 0; i < p.length; i++) {
			pst.setObject(i + 1, p[i]);
			pst.executeUpdate();
		}
	}

	public ImageIcon getIcon(String path, int w, int h) {
		return new ImageIcon(Toolkit.getDefaultToolkit().getImage(path).getScaledInstance(w, h, Image.SCALE_SMOOTH));
	}

	public void changeFrame(JFrame frame) {
		dispose();
		list.put(frame.getTitle(), this);
		frame.setVisible(true);
		main.requestFocus();
	}

	public void setCompoent(JPanel jp) {
		for (Component comp : jp.getComponents()) {
			if (comp instanceof JButton) {
				((JButton) comp).setMargin(new Insets(0, 0, 0, 0));
				((JButton) comp).setCursor(new Cursor(HAND_CURSOR));
				
			}
			if (comp instanceof JTextField) {
				JTextField tf = (JTextField) comp;
				tf.setName(tf.getText());
				tf.setForeground(Color.GRAY);
				tf.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
				tf.addFocusListener(new FocusListener() {
					@Override
					public void focusLost(FocusEvent e) {
						tf.setForeground(tf.getText().isEmpty() ? Color.GRAY : Color.BLACK);
						tf.setText(tf.getText().isEmpty() ? tf.getName() : tf.getText());
					}
					@Override
					public void focusGained(FocusEvent e) {
						tf.setText("");
						tf.setForeground(Color.BLACK);
					}
				});
			}
			((JComponent) comp).setBorder(null);
			comp.setBackground(Color.WHITE);
			comp.setFont(new Font("맑은 고딕", 1, 12));
		}
	}

}
