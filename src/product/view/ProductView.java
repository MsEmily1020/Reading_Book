package product.view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import product.vo.ProductVO;

public class ProductView extends JPanel {
	ArrayList<ProductVO> pvo;
	ArrayList<JLabel> lbList = new ArrayList<JLabel>();
	
	public JPanel displayProducts() {
		JPanel gnPn = new JPanel(new GridLayout(3, 3));
		for (ProductVO vo : pvo) {
			ImageIcon icon = new ImageIcon("images/" + vo.getImageName() + ".jpg");
			JLabel lb = new JLabel(icon);
			lbList.add(lb);
			gnPn.add(lb);
		}
		return gnPn;
	}
	
	public void inputPurchase() {
	}
	
	public void setProductList(ArrayList<ProductVO> pvo) {
		this.pvo = pvo;
	}
}
