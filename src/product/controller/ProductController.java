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
		add(view, "Center");
		setTitle("음료수자판기");
		setSize(500, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(2);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		new ProductController().setVisible(true);
	}
}
