package project;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Cart extends BaseFrame {
	int price = 0;
	DefaultTableModel model;
	JTable table;

	public Cart() {
		super("cart", 600, 500);
		try {
			var rs = getResult("select * from cart c join product p on c.p_no = p.p_no where u_no = ?", userId);
			while(rs.next()) {
				if(rs.getInt("p_discount") > 0) price += rs.getInt("p_price") - (rs.getInt("p_price") * (rs.getInt("p_discount") * 0.01)) * rs.getInt("ca_count");
				else price += rs.getInt("p_price") * rs.getInt("ca_count");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		main.add(setBounds(lb[0] = new JLabel("CARTLIST", 0), 215, 15, 145, 20));

		model = new DefaultTableModel("이미지,제품명,가격,수량,평점".split(","), 0) {
			public boolean isCellEditable(int row, int column) { return false; };
			@Override
			public Class getColumnClass(int column) {
				if (column == 0) return ImageIcon.class;
				return Object.class;
			}
		};

		try {
			createTable();
		} catch (Exception e) {
			e.printStackTrace();
		}

		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);

		JPopupMenu pm = new JPopupMenu();
		JMenuItem order = new JMenuItem("주문하기");
		JMenuItem remove = new JMenuItem("삭제하기");
		pm.add(order);
		pm.add(remove);

		table.setComponentPopupMenu(pm);

		order.addActionListener(e -> {
			changeFrame(new Order());
		});
		
		remove.addActionListener(e -> {
			try {
				update("delete from cart where ca_no = ?", "?");
				createTable();
				table.revalidate();
				table.repaint();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		main.add(setBounds(scroll, 20, 60, 550, 340));
		int[] width = {50, 130, 70, 70, 70};
		for (int i = 0; i < width.length; i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(width[i]);
		}

		table.setRowHeight(60);

		main.add(setBounds(lb[1] = new JLabel("총 금액: " + String.format("%,d", price) + "원"), 10, 425, 155, 25));
		main.add(setBounds(btn[0] = actionbtn("전체 주문", e -> {
			changeFrame(new Order());
		}), 465, 425, 105, 20));

		setComponent(main);

		table.setGridColor(Color.black);

		lb[0].setFont(new Font("맑은 고딕", 1, 20));

		btn[0].setBackground(Color.green);
	}

	void createTable() throws Exception {
		model.setRowCount(0);
		var rs = getResult("select * from cart c join product p on c.p_no = p.p_no where u_no = ?", userId);
		while(rs.next()) {
			model.addRow(new Object[] {
					getIcon(("datafiles/제품/" + rs.getInt("p_no") + ".PNG"), 30, 30),
					rs.getString("p_name"),
					rs.getInt("p_price"),
					rs.getInt("ca_count"),
					"높음"
			});
		}
	}

	public static void main(String[] args) {
		new Cart().setVisible(true);
	}
}
