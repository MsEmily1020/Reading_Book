package product.view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import product.vo.ProductVO;

public class ProductView extends JPanel {
	ArrayList<ProductVO> pvo;
	ArrayList<JLabel> jList = new ArrayList<JLabel>();
	
	public JPanel displayProducts() {
		JPanel gnPn = new JPanel(new GridLayout(3, 3));
		
		return gnPn;
	}
	
	public void inputPurchase() {
		
	}
	
	public void setProductList(ArrayList<ProductVO> pvo) {
		
	}
}
