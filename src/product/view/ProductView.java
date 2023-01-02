package product.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import product.vo.ProductVO;

public class ProductView extends JPanel {
	ArrayList<ProductVO> pvo;
	ArrayList<JLabel> lbList = new ArrayList<JLabel>();
	JTextField insertTf = new JTextField(10);
	JLabel lbResult = new JLabel("제품이 나오는 부분");
	JLabel eLbl;
	ProductVO vo = null;
	JFrame frame;
	
	public JPanel displayProducts(JFrame frame) {
		this.frame = frame;
		JPanel gnPn = new JPanel(new GridLayout(3, 3));
		for (ProductVO vo : pvo) {
			ImageIcon icon = new ImageIcon("images/" + vo.getImageName() + ".jpg");
			JLabel lb = new JLabel(icon);
			lb.setOpaque(true);
			lb.setBackground(Color.white);
			lb.addMouseListener(lbMouseAdater);
			lbList.add(lb);
			gnPn.add(lb);
		}
		return gnPn;
	}
	
	public JPanel inputPurchase() {
		JPanel panS = new JPanel();
		JLabel lbMoney = new JLabel("금액 : ");
		JButton btnInset = new JButton("투입");
		btnInset.addActionListener(btListen);
		panS.add(lbMoney); panS.add(insertTf); panS.add(btnInset);
		panS.add(lbResult);
		return panS;
	}
	
	public void setProductList(ArrayList<ProductVO> pvo) {
		this.pvo = pvo;
	}
	
	MouseAdapter lbMouseAdater = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			for(int i = 0; i < lbList.size(); i++) {
				eLbl = (JLabel)e.getSource();
				//이전 값 초기화
				for(int j = 0; j < lbList.size(); j++) lbList.get(i).setBackground(Color.white); 
				if(eLbl == lbList.get(i)) {
					eLbl.setBackground(Color.red);
					vo = pvo.get(i);
				}
			}
			JOptionPane.showMessageDialog(frame, "제품명 : " + vo.getName() + "\n제품 가격 : " + vo.getPrice());
		}
	};
	
	ActionListener btListen = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int money = Integer.parseInt(insertTf.getText());
			if(vo.getPrice() <= money) {
				JOptionPane.showMessageDialog(null, "거스름돈 : " + (money - vo.getPrice()));
				lbResult.setText("");
				lbResult.setIcon(new ImageIcon("images/" + vo.getImageName() + ".jpg"));
			}
			else
				JOptionPane.showMessageDialog(null, vo.getPrice() - money + "원이 부족합니다.");
			eLbl.setBackground(Color.white);
			insertTf.setText("");
			
		}
	};
}
