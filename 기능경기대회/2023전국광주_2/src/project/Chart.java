package project;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Chart extends BaseFrame {
	DefaultTableModel model;
	
	ArrayList<Integer> arr = new ArrayList<>();
	public Chart() {
		super("chart", 800, 500);

		userId = 1;
		userName = "강다은";
		
		main.add(setBounds(lb[0] = new JLabel(userName + "님", 0), 5, 15, 85, 30));
		
		model = new DefaultTableModel("번호,약국명,제품명,가격,할인율,총 가격,별 점".split(","), 0 ) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		JPopupMenu pm = new JPopupMenu();
		JMenuItem review = new JMenuItem("후기작성");
		pm.add(review);

		table.setComponentPopupMenu(pm);
		
		createTabel();
		
		review.addActionListener(e -> {
			int row = table.getSelectedRow();
			try {
				var rs = getResult("select * from orderlist where o_no = ?", arr.get(row));
				if(rs.getInt("o_find") == 1) {
					changeFrame(new Review());
				}
				else {
					int yes = JOptionPane.showConfirmDialog(null, "아직 제품을 찾지 않으셨습니다. 찾으러 가겠습니까?", "질문", JOptionPane.YES_NO_OPTION);
					if(yes == JOptionPane.YES_OPTION) {
						changeFrame(new Map());
					}
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		int[] width = {50, 130, 200, 60, 60, 60, 60};
		for (int i = 0; i < width.length; i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(width[i]);
		}
		table.setRowHeight(40);
		
		main.add(setBounds(scroll, 10, 60, 500, 350));
	}
	
	public void createTabel() {
		model.setRowCount(0);
		
		int cnt = 1;
		try {
			var rs = getResult("SELECT * FROM vitamin.orderlist o\r\n"
					+ "join drugstore d on o.d_no = d.d_no\r\n"
					+ "join product p on o.p_no = p.p_no\r\n"
					+ "where u_no = ?;", userId);
			while(rs.next()) {
				arr.add(rs.getInt("o_no"));
				model.addRow(new Object[] {
					cnt++,
					rs.getString("d_name"),
					rs.getString("p_name"),
					rs.getInt("p_price"),
					rs.getInt("p_discount") + "%",
					String.format("%,d", (int)(rs.getInt("p_price") - (rs.getInt("p_price") * (rs.getInt("p_discount") * 0.01)))),
					"5.0"
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	public static void main(String[] args) {
		new Chart().setVisible(true);
	}

}
