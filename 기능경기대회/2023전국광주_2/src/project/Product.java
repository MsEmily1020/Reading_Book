package project;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;

public class Product extends BaseFrame {
	public static int p_no = 1;
	int incense, taste, effect, money, throat;

	JScrollPane scroll;
	JSpinner spin;

	int cnt;

	public Product() {
		super("product", 600, 500);
		
		userId = 1;

		try {
			var rs = getResult("select * from product where p_no = ?", p_no);
			if (rs.next()) {
				main.add(setBounds(lb[0] = new JLabel(getIcon("datafiles/제품/" + p_no + ".PNG", 140, 170)), 15, 15, 140,
						170));
				main.add(setBounds(lb[1] = new JLabel(rs.getString("p_name")), 165, 15, 270, 25));
				main.add(setBounds(lb[2] = new JLabel(rs.getInt("p_price") + "원"), 165, 45, 125, 30));
				main.add(setBounds(btn[0] = actionbtn("장바구니", e -> {
					try {
						update("insert into cart (p_no, u_no, ca_count) values (?, ?, ?)", p_no, userId,
								Integer.parseInt(spin.getValue().toString()));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					int num = JOptionPane.showConfirmDialog(null, "장바구니에 담겼습니다. 장바구니로 이동하시겠습니까?", "정보",
							JOptionPane.YES_NO_OPTION);
					if (num == JOptionPane.YES_OPTION) {
						changeFrame(new Cart());
					} else {
						showInfo("장바구니에 담겼습니다.");
					}

				}), 455, 10, 115, 25));

				main.add(setBounds(btn[1] = actionbtn("주문하기", e -> changeFrame(new Order())), 455, 50, 115, 25));
				main.add(setBounds(lb[3] = new JLabel("<html><p>" + rs.getString("p_detail") + "</p></html>"), 170, 110,
						245, 80));

				main.add(setBounds(spin = new JSpinner(new SpinnerNumberModel(1, 1, 20, 1)), 220, 51, 45, 20));

				main.add(setBounds(lb[4] = new JLabel("만족도"), 30, 200, 60, 30));
				main.add(setBounds(lb[5] = new JLabel("향", JLabel.RIGHT), 30, 235, 40, 25));
				main.add(setBounds(lb[6] = new JLabel("맛", JLabel.RIGHT), 30, 275, 40, 25));
				main.add(setBounds(lb[7] = new JLabel("효과", JLabel.RIGHT), 30, 315, 40, 25));
				main.add(setBounds(lb[8] = new JLabel("가성비", JLabel.RIGHT), 30, 355, 40, 25));
				main.add(setBounds(lb[9] = new JLabel("목넘김", JLabel.RIGHT), 30, 395, 40, 25));

				main.add(setBounds(lb[10] = new JLabel(), 75, 235, 350, 30));
				main.add(setBounds(lb[11] = new JLabel(), 75, 275, 350, 30));
				main.add(setBounds(lb[12] = new JLabel(), 75, 315, 350, 30));
				main.add(setBounds(lb[13] = new JLabel(), 75, 355, 350, 30));
				main.add(setBounds(lb[14] = new JLabel(), 75, 395, 350, 30));

				main.add(setBounds(lb[15] = new JLabel(), 300, 210, 1, 220));

				main.add(setBounds(lb[16] = new JLabel("후기"), 330, 200, 100, 15));
				scroll = new JScrollPane(pn[0], ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
						ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				main.add(setBounds(pn[0] = new JPanel(null), 330, 230, 240, 195));

				rs = getResult("select *, count(*) from review where p_no = ?", p_no);

				while (rs.next()) {
					incense += rs.getInt("r_incense");
					taste += rs.getInt("r_taste");
					effect += rs.getInt("r_effect");
					money += rs.getInt("r_money");
					throat += rs.getInt("r_throat");

					if (rs.isLast()) {
						incense /= rs.getInt("count(*)");
						taste /= rs.getInt("count(*)");
						effect /= rs.getInt("count(*)");
						money /= rs.getInt("count(*)");
						throat /= rs.getInt("count(*)");

						lb[10].setSize((int) (lb[10].getWidth() * incense / 100.0), lb[10].getHeight());
						lb[11].setSize((int) (lb[11].getWidth() * taste / 100.0), lb[11].getHeight());
						lb[12].setSize((int) (lb[12].getWidth() * effect / 100.0), lb[12].getHeight());
						lb[13].setSize((int) (lb[13].getWidth() * money / 100.0), lb[13].getHeight());
						lb[14].setSize((int) (lb[14].getWidth() * throat / 100.0), lb[14].getHeight());

						main.add(setBounds(lb[17] = new JLabel((incense * 2) + "%"),
								lb[10].getX() + lb[10].getWidth() + 10, 235, 40, 30));
						main.add(setBounds(lb[18] = new JLabel((taste * 2) + "%"),
								lb[11].getX() + lb[11].getWidth() + 10, 275, 40, 30));
						main.add(setBounds(lb[19] = new JLabel((effect * 2) + "%"),
								lb[12].getX() + lb[12].getWidth() + 10, 315, 40, 30));
						main.add(setBounds(lb[20] = new JLabel((money * 2) + "%"),
								lb[13].getX() + lb[13].getWidth() + 10, 355, 40, 30));
						main.add(setBounds(lb[21] = new JLabel((throat * 2) + "%"),
								lb[14].getX() + lb[14].getWidth() + 10, 395, 40, 30));
					}
				}

				rs = getResult(
						"select * \r\n" + "from review r\r\n" + "join user u on r.u_no = u.u_no\r\n" + "where p_no = ?",
						p_no);

				while (rs.next()) {
					pn[0].add(setBounds(
							lb[17] = new JLabel(rs.getInt("r_open") == 2 ? rs.getString("u_name").charAt(0) + "**"
									: rs.getString("u_name")),
							10, 10 + cnt * 90, 40, 20));

					pn[0].add(setBounds(lb[18] = new JLabel((rs.getInt("u_age") + "").charAt(0) + "0대"), 80,
							10 + cnt * 90, 40, 20));

					switch ((rs.getInt("u_age") + "").charAt(1)) {
					case '0':
					case '1':
					case '2':
					case '3':
						pn[0].add(setBounds(lb[19] = new JLabel("초반"), 110, 10 + cnt * 90, 40, 20));
						break;
					case '4':
					case '5':
					case '6':
						pn[0].add(setBounds(lb[19] = new JLabel("중반"), 110, 10 + cnt * 90, 40, 20));
						break;
					case '7':
					case '8':
					case '9':
						pn[0].add(setBounds(lb[19] = new JLabel("후반"), 110, 10 + cnt * 90, 40, 20));
						break;
					}

					pn[0].add(setBounds(
							lb[20] = new JLabel(rs.getInt("u_gender") == 1 || rs.getInt("u_gender") == 3 ? "남성" : "여성"),
							140, 10 + cnt * 90, 40, 20));

					pn[0].add(setBounds(lb[21] = new JLabel(rs.getString("r_date")), 80, 30 + cnt * 90, 100, 20));

					pn[0].add(setBounds(lb[22] = new JLabel(rs.getString("r_detail")), 10, 70 + cnt * 90, 250, 30));

					cnt++;
				}
			}

			btn[0].setBackground(Color.green);
			btn[1].setBackground(Color.green);

			lb[10].setOpaque(true);
			lb[11].setOpaque(true);
			lb[12].setOpaque(true);
			lb[13].setOpaque(true);
			lb[14].setOpaque(true);
			lb[15].setOpaque(true);

			lb[10].setBackground(Color.red);
			lb[11].setBackground(Color.orange);
			lb[12].setBackground(Color.yellow);
			lb[13].setBackground(Color.green);
			lb[14].setBackground(Color.blue);
			lb[15].setBackground(Color.black); 

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Product().setVisible(true);
	}

}
