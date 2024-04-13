package project;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BaseFrame extends JFrame {
	static Connection con;
	static Statement stmt;
	
	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/2023지방_3?serverTimezone=UTC", "user", "1234");
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
		getContentPane().setBackground(Color.white);
	}
	
	public static void showErr(String m) {
		JOptionPane.showMessageDialog(null, m, "에러", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void showInfo(String m) {
		JOptionPane.showMessageDialog(null, m, "정보", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static ResultSet getRs(String sql, Object ...p) {
		try {
			var pst = con.prepareStatement(sql);
			for (int i = 0; i < p.length; i++) {
				pst.setObject(i + 1, p[i]);
			}
			
			return pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static ResultSet update(String sql, Object ...p) {
		try {
			var pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < p.length; i++) {
				pst.setObject(i + 1, p[i]);
			}
			pst.executeUpdate();
			
			return pst.getGeneratedKeys();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static JComponent setBounds(JComponent comp, int x, int y, int w, int h) {
		comp.setBounds(x, y, w, h);
		return comp;
	}
}
