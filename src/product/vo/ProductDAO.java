package product.vo;

import java.util.ArrayList;

public class ProductDAO {
	ArrayList<ProductVO> pvoList = new ArrayList<ProductVO>();

	public void insert(ProductVO pvoList) {
		this.pvoList.add(pvoList);
	}

	public ArrayList<ProductVO> select() {
		return pvoList;
	}
}
