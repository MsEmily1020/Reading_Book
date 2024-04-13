package project;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class BaseFrame extends JFrame {
	static Connection con;
	static Statement stmt;
	
	public JPanel main;
	public static JLabel[] lb = new JLabel[300];
	public static JButton[] btn = new JButton[300];
	public static JPanel[] pn = new JPanel[300];
	public static JCheckBox[] ch = new JCheckBox[300];
	public static JComboBox[] cb = new JComboBox[300];
	public static JScrollPane jpan;
	public static JScrollBar jbar;
	
	JComponent comp;
	
	String[] jcompArr = ",JLabel,JButton,JPanel,JCheckBox,JCombobox".split(",");
	String[] valArr = ",lb[],btn[],pn[],ch[],cb[]".split(",");
	
	String jcomp;
	String val;
	
	int startX, startY, endX, endY, width, height;
	
	public static HashMap<String, JFrame> list = new HashMap<>();
	
	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/2023전국_2?serverTimezone=UTC","root", "1234");
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public BaseFrame(String title, int w, int h) {
		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);
		setLayout(null);
		
		setCursor(new Cursor(CROSSHAIR_CURSOR));
		
		add(setBounds(main = new JPanel(null), 0, 0, w, h));
		main.setBackground(Color.white);
		
		main.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				jcomp = jcompArr[e.getKeyChar() - 48];
				val = valArr[e.getKeyChar() - 48];
				
				try {
					comp = (JComponent) Class.forName("javax.swing." + jcomp).newInstance();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
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
				height= Math.abs(startY - endY);
				
				comp.setBounds(startX, startY, width, height);
				
				main.add(comp);
				
				if(jcomp.equals("JLabel") || jcomp.equals("JPanel")) {
					comp.setBorder(new LineBorder(Color.black));
				}
				
				main.revalidate();
				main.repaint();
				
				main.setFocusable(true);
				main.requestFocus();
				
				System.out.println("add(setBounds(" + val + " = new " + jcomp + "(), " + startX + ", " + startY + ", " + width + ", " + height + "));");
			}
		});
		
		main.setFocusable(true);
		main.requestFocus();
		
		addWindowFocusListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(!title.equals("로그인"))
					changeFrame(list.get(title));
			}
		});
		
	}
	
	public static JButton actbtn(String m, ActionListener action) {
		JButton btn = new JButton(m);
		btn.addActionListener(action);
		return btn;
	}
	
	public static <T extends JComponent> T setBounds(T comp, int x, int y, int w, int h) {
		comp.setBounds(x, y, w, h);
		return comp;
	}
	
	public static ResultSet getResult(String sql, Object ...p) throws Exception {
		var pst = con.prepareStatement(sql);
		
		for (int i = 0; i < p.length; i++) {
			pst.setObject(i + 1, p[i]);
		}
		
		return pst.executeQuery();
	}


	public static void update(String sql, Object ...p) throws Exception {
		var pst = con.prepareStatement(sql);
		
		for (int i = 0; i < p.length; i++) {
			pst.setObject(i + 1, p[i]);
		}
		
		pst.executeUpdate();
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
		JOptionPane.showMessageDialog(null, m, "에러", JOptionPane.ERROR_MESSAGE);
	}
	
	public void setComponent(Component jp) {
		for(Component comp : ((Container) jp).getComponents()) {
			if(comp instanceof JButton) {
				((JButton) comp).setMargin(new Insets(0, 0, 0, 0));
			}
			
			if (comp instanceof JCheckBox) {
				comp.setBackground(Color.white);
			}
			
			if (comp instanceof JPanel) {
				comp.setBackground(Color.white);
			}
			
			if (comp instanceof JTextField) {
				JTextField tf = (JTextField) comp;
				tf.setName(tf.getText());
				tf.setForeground(Color.gray);
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
			
			comp.setFont(new Font("맑은 고딕", 1, 14));
		}
	}
}
