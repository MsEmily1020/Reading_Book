package product.controller;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import product.view.ProductView;
import product.vo.ProductDAO;
import product.vo.ProductVO;

public class ProductController extends JFrame {
	public static final int STOP = 0;

	ArrayList<ProductVO> pvo;
	
	public ProductController() {
		ProductView view = new ProductView();
		fullProduct();
		view.setProductList(pvo);
		JPanel panC = view.displayProducts(this);
		JPanel panS = view.inputPurchase();
		
		add(panC, "Center");
		add(panS, "South");
		setTitle("음료수자판기");
		setSize(600, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(2);
		setResizable(false);
	}

	//제품 채우기
	public void fullProduct() {
		ProductDAO dao = new ProductDAO();
		String[] menu = "초록매실,콜라,사이다,모구모구,생수,알로에,레몬에이드,웰치스,포카리스웨트".split(",");
		int[] price = { 1500, 1400, 1400, 1500, 800, 1200, 1100, 1200, 1300 };
		ProductVO vo = null;
		pvo = dao.select();
		for (int i = 0; i < menu.length; i++) {
			vo = new ProductVO();
			vo.setName(menu[i]);
			vo.setPrice(price[i]);
			vo.setProductNum(i);
			vo.setStockNum(10);
			vo.setImageName(menu[i]);
			pvo.add(vo);
		}
	}
	
	public static void main(String[] args) {
		new ProductController().setVisible(true);
	}
}
