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
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class BaseFrame extends JFrame {
	static Connection con;
	static Statement stmt;

	public static ArrayList<String> restaurant = new ArrayList<>(); // 가게
	public static ArrayList<Integer> store = new ArrayList<>(); // 검색 결과 store들
	public static Map<String, Double> score = new TreeMap(); // 가게 평점
	public static Map<String, Integer> favorite = new TreeMap<>(); // 가게 찜
	public static Map<String, Integer> order = new TreeMap<>(); // 가게 주문 순

	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/rider?serverTimezone=UTC", "user", "1234");
			stmt = con.createStatement();

			var rs = getResult("select * from restaurant");
			while (rs.next()) {
				restaurant.add(rs.getString("r_name"));
			}
			
			for (int i = 1; i <= 53; i++) {
				var rs1 = getResult("SELECT *\r\n" + "FROM rider.review re\r\n"
						+ "join rider.orderlist o on re.o_no = o.o_no \r\n"
						+ "where o.r_no = ?", i);

				double sum = 0, n = 0;
				while (rs1.next()) {
					n = rs1.getRow();
					sum += rs1.getInt("re_store");
				}

				sum /= n;

				score.put(restaurant.get(i - 1), sum);
			}

			for (int i = 1; i <= 53; i++) {
				favorite.put(restaurant.get(i - 1), 0);
				order.put(restaurant.get(i - 1), 0);
			}

			var rs2 = getResult("select * from information");

			while (rs2.next()) {
				for (String n : rs2.getString("i_mine").split(",")) {
					String res = restaurant.get(Integer.parseInt(n) - 1);
					favorite.put(res, favorite.get(res) + 1);
				}
			}
			
			for (int i = 1; i <= 53; i++) {
				var rs3 = getResult("select count(*) from orderlist where r_no = ?", i);

				if (rs3.next()) {
					order.put(restaurant.get(i - 1), rs3.getInt("count(*)"));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	JPanel main;
	JLabel[] lb = new JLabel[30];
	JButton[] btn = new JButton[30];
	JTextField[] tf = new JTextField[30];
	JCheckBox[] ch = new JCheckBox[30];
	JComboBox[] cb = new JComboBox[30];
	JPanel[] jp = new JPanel[30];

	String[] jcompArr = ",JLabel,JButton,JTextField,JCheckBox,JComboBox,JPanel".split(",");
	String[] valArr = ",lb[],btn[],tf[],ch[],cb[],jp[]".split(",");

	String jcomp, val;
	int startX, startY, endX, endY, width, height;
	public static int userNo;
	public static String userName;
	public static int riderNo;
	public static String riderName;

	public static int selectMain = 2; // 메인 폼 메뉴 선택
	public static int selectStore = 1; // 가게 폼 선택
	public static int selectMenu = 1; // 메뉴 폼 메뉴 선택
	String[] menu = "한식,양식,중식,일식,분식,아시안,피자,치킨,패스트푸드,디저트".split(",");

	JComponent comp;

	public static HashMap<String, JFrame> list = new HashMap<>();

	public BaseFrame(String title, int w, int h) {
		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

		try {
			setIconImage(ImageIO.read(new File("datafiles/logo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		add(main = setBounds(new JPanel(null), 0, 0, w, h));
		main.setBackground(Color.white);
		main.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				jcomp = jcompArr[e.getKeyChar() - 48];
				val = valArr[e.getKeyChar() - 48];

				try {
					comp = (JComponent) Class.forName("javax.swing." + jcomp).newInstance();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
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

				main.revalidate();
				main.repaint();

				main.setFocusable(true);
				main.requestFocus();

				if (jcomp.equals("JLabel") || jcomp.equals("JPanel")) {
					comp.setBorder(new LineBorder(Color.black));
				}

				System.out.println("main.add(setBounds(" + val + " = new " + jcomp + "(), " + startX + ", " + startY
						+ ", " + width + ", " + height + "));");
			}
		});

		main.setFocusable(true);
		main.requestFocus();
	}

	public static void showInfo(String m) {
		JOptionPane.showMessageDialog(null, m, "정보", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void showErr(String m) {
		JOptionPane.showMessageDialog(null, m, "경고", JOptionPane.ERROR_MESSAGE);
	}

	public static <T extends JComponent> T setBounds(T comp, int x, int y, int w, int h) {
		comp.setBounds(x, y, w, h);
		return comp;
	}

	public static <T extends JComponent> T setBounds(T comp, int w, int h) {
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

	public static void update(String sql, Object... p) throws Exception {
		var pst = con.prepareStatement(sql);
		for (int i = 0; i < p.length; i++) {
			pst.setObject(i + 1, p[i]);
		}

		pst.executeUpdate();
	}

	public JButton actbtn(String m, ActionListener action) {
		JButton btn = new JButton(m);
		btn.addActionListener(action);
		return btn;
	}

	public static ImageIcon getIcon(String path, int w, int h) {
		return new ImageIcon(Toolkit.getDefaultToolkit().getImage(path).getScaledInstance(w, h, Image.SCALE_SMOOTH));
	}

	public static void setComponent(JPanel jp) {
		for (Component comp : jp.getComponents()) {
			if (comp instanceof JButton) {
				((JButton) comp).setMargin(new Insets(0, 0, 0, 0));
				comp.setCursor(new Cursor(HAND_CURSOR));
			}

			if (comp instanceof JTextField) {
				JTextField tf = (JTextField) comp;
				tf.setName(tf.getText());
				tf.setForeground(Color.gray);
				tf.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
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

	public void changeFrame(JFrame frame) {
		dispose();
		list.put(frame.getTitle(), frame);
		frame.setVisible(true);
		main.requestFocus();
	}
}
