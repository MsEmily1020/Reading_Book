package class2_1.coll_ex.coll02;

import java.util.Vector;

public class PointVectorEx {
	public static void main(String[] args) {
		Vector<Point> v = new Vector<Point>();
		v.add(new Point(2, 3));		// Point(int x, int y) 생성자 메서드에 의해서 데이터 삽입
		v.add(new Point(-5, 20));
		v.add(new Point(30, -8));
		
		for (int i = 0; i < v.size(); i++) {
			Point p = v.get(i);
			System.out.println(p); // toString() 메서드 호출
		}
	}
}
