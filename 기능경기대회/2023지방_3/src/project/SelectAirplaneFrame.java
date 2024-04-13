package project;

import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SelectAirplaneFrame extends BaseFrame{
	public SelectAirplaneFrame() {
		super("항공권 조회", 300, 350);

		setLayout(null);
		add(setBounds(new JLabel("출발지"), 30, 50, 50, 30));
		add(setBounds(new JLabel("도착지"), 30, 110, 50, 30));
		add(setBounds(new JLabel("출발날짜"), 30, 170, 50, 30));

		var startCb = new JComboBox<>();
		var finishCb = new JComboBox<>();
		var date = new JTextField();

		add(setBounds(startCb, 90, 50, 130, 30));
		add(setBounds(finishCb, 90, 110, 130, 30));
		add(setBounds(date, 90, 170, 130, 30));
		date.setEnabled(false);

		var img = new ImageIcon("datafiles/달력.png");
		var image = img.getImage();
		var changeImg = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		var dateLb = new JLabel(new ImageIcon(changeImg));
		add(setBounds(dateLb, 230, 170, 30, 30));

		var rs = getRs("SELECT * FROM nation");
		startCb.addItem("");
		try {
			while(rs.next()) {
				startCb.addItem(rs.getString("n_name"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		startCb.addActionListener(e -> {
			finishCb.removeAllItems();
			String nation = startCb.getSelectedIndex() == 0 ? "" : startCb.getSelectedItem().toString();
			
			finishCb.addItem("");
			String nation2 = finishCb.getSelectedIndex() == 0 ? "" : finishCb.getSelectedItem().toString();
			
			var rs2 = getRs("SELECT * FROM nation WHERE NOT n_name = ?", nation);
			try {
				while(rs2.next()) {
					finishCb.addItem(rs2.getString("n_name"));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			finishCb.revalidate();
			finishCb.repaint();
			
		});

		dateLb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(startCb.getSelectedItem().equals("") || finishCb.getSelectedItem().equals("")) {
					showErr("출발지와 도착지를 선택하세요.");
					return;
				}

				dispose();
				new CalendarFrame().setVisible(true);
			}
		});
		
		
		var bt = new JButton("확인");
		add(setBounds(bt, 100, 250, 90, 30));
		bt.addActionListener(e -> {
			if(startCb.getSelectedItem().toString().equals("") ||
					finishCb.getSelectedItem().toString().equals("") ||
					date.getText().length() == 0) {
				showErr("빈칸이 있습니다");
				return;
			}
			//항공권 선택 페이지
		});
	}

	public static void main(String[] args) {
		new SelectAirplaneFrame().setVisible(true);
	}
}
