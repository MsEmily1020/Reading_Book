package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class F상품 extends BaseFrame {

	String str = "";

	public F상품() {
		super("메인", 880, 640);
		try {
			rs = getResult("select *, (select count(*) from follower where store = post.store) as fwer from post where no = ?", p_no);
			rs.next();

			for (int i = 0; i < 3; i++) {
				str += category.get(filter.get(p_no).get(i)) == null ? "" : " > " + category.get(filter.get(p_no).get(i));
			}

			main.add(setBounds(lb[0] = new JLabel("홈" + str), 5, 5, 855, 20));
			main.add(setBounds(lb[1] = new JLabel(), 5, 30, 290, 260));
			main.add(setBounds(lb[2] = new JLabel(rs.getString("title")), 305, 30, 550, 30));
			main.add(setBounds(lb[3] = new JLabel(String.format("%,d원", rs.getInt("price"))), 305, 75, 550, 40));
			main.add(setBounds(lb[4] = new JLabel("찜: " + rs.getString("satae") + " | 조회수: " + rs.getString("view") + " | 배송비: 별도"), 305, 130, 550, 20));
			main.add(setBounds(lb[5] = new JLabel("연관상품"), 5, 305, 70, 15));
			main.add(setBounds(lb[6] = new JLabel("연관상품"), 5, 305, 70, 15));
			main.add(setBounds(lb[7] = new JLabel("1/4", 4), 815, 300, 40, 20));
			main.add(setBounds(lb[8] = new JLabel("상품정보"), 10, 510, 615, 30));
			main.add(setBounds(lb[9] = new JLabel("상점정보"), 630, 510, 225, 30));
			main.add(setBounds(lb[10] = new JLabel("<HTML><p>" + rs.getString("explanation") + "</p></HTML>"), 10, 550, 615, 80));
			
			main.add(setBounds(lb[11] = new JLabel(getIcon("./datafiles/image/store/" + rs.getString("store") + ".jpg", 45, 45)), 630, 550, 45, 45));
			main.add(setBounds(lb[12] = new JLabel(store.get(rs.getInt("store"))), 675, 550, 180, 20));
			main.add(setBounds(lb[13] = new JLabel("상품11 | 팔로워" + rs.getString("fwer")), 675, 580, 180, 20));

			main.add(setBounds(btn[0] = new JButton("♥찜 0"), 305, 240, 275, 50));
			main.add(setBounds(btn[1] = new JButton("바로구매"), 590, 240, 265, 50));
			main.add(setBounds(btn[2] = new JButton("팔로우"), 630, 610, 225, 35));

			main.add(setBounds(btn[3] = actbtn("◀", e -> 페이징(-1)), 5, 370, 40, 40));
			main.add(setBounds(btn[4] = actbtn("▶", e -> 페이징(1)), 815, 370, 40, 40));
			main.add(setBounds(jp[0] = new JPanel(new FlowLayout(0, 4, 0)), 5, 325, 860, 185));

			jp[0].setName("6");
			
			상품리스트(jp[0], getResult("select * from post where no != ? and category = ? order by rand() limit 24", p_no, filter.get(p_no).get(0)));
			
			var th = new Thread() {
				public void run() {
					try {
						while (true) {
							for (String file : new File("./datafiles/image/post/" + p_no).list()) {
								lb[1].setIcon(getIcon("./datafiles/image/post/" + p_no + "/" + file, 290, 260));
								Thread.sleep(1000);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				};
			};
			th.start();

			setCompoent(main);
			setCompoent(jp[0]);

			lb[1].setBorder(new LineBorder(Color.BLACK));
			lb[2].setFont(new Font("맑은 고딕", 1, 18));
			lb[3].setFont(new Font("맑은 고딕", 1, 24));
			lb[3].setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
			lb[8].setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
			lb[9].setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
			lb[13].setForeground(Color.LIGHT_GRAY);
			btn[0].setBackground(Color.GRAY);
			btn[1].setBackground(Color.RED);
			btn[0].setForeground(getBackground());
			btn[1].setForeground(getBackground());
			btn[2].setBorder(new LineBorder(Color.GRAY));
			btn[3].setMargin(new Insets(0, 0, 0, 0));
			btn[4].setMargin(new Insets(0, 0, 0, 0));
			btn[3].setBackground(Color.LIGHT_GRAY);
			btn[4].setBackground(Color.LIGHT_GRAY);
			btn[3].setBorder(null);
			btn[4].setBorder(null);
			jp[0].setBackground(Color.WHITE);
			jp[0].setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK), new EmptyBorder(0, 0, 30, 0)));
			
			Thread.sleep(800);
			
			페이징(0);
			
			main.setPreferredSize(new Dimension(850, 660));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void 페이징(int page) {
		lb[7].setText(Integer.parseInt(lb[7].getText().split("/")[0]) + page + "/4");
		int a = (Integer.parseInt(lb[7].getText().split("/")[0]) - 1) * 6;
		btn[3].setEnabled(!lb[7].getText().equals("1/4"));
		btn[4].setEnabled(!lb[7].getText().equals("4/4"));
		for (int i = 0; i < jp[0].getComponentCount(); i++) {
			jp[0].getComponent(i).setVisible(a <= i && a + 6 > i);
		}
		main.repaint();
		jp[0].repaint();
	}
	
	public static void main(String[] args) {
		new A메인().setVisible(true);
	}
}
