package product.controller;

import java.util.ArrayList;

import javax.swing.JFrame;

import product.view.ProductView;
import product.vo.ProductDAO;
import product.vo.ProductVO;

public class ProductController extends JFrame {
	ProductDAO dao = new ProductDAO();
	ArrayList<ProductVO> pvo = dao.select();
	ProductView view = new ProductView();

	public ProductController() {
		setTitle("음료수자판기");
		setSize(500, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(2);
		setResizable(false);
	}

	//제품 채우기
	public void fullProduct() {
		String[] menu = "초록매실,콜라,사이다,모구모구,생수,알로에,레몬에이드".split(",");
		int[] price = { 1500, 1400, 1400, 1500, 800, 1200, 1100 };
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
