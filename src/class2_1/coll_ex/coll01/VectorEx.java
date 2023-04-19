package class2_1.coll_ex.coll01;

import java.util.Vector;

public class VectorEx {
	public static void main(String[] args) {
		// 기본 용량 : 10
		// v는 벡터클래스의 객체변수, 데이터는 정수 담음
		// Vector() 생성자에 의해 10개의 기억공간 만들어짐
		Vector<Integer> v = new Vector<>();
		
		v.add(5);		// 인덱스 : 0
		v.add(4);		// 인덱스 : 1
		v.add(-1);		// 인덱스 : 2
		
		v.add(2, 100);	// 인덱스 2번째에 100 삽입 이후 데이터는 자동으로 뒤로 이동
		
		// 5 -> 4 -> 100 -> -1
		
		
		// 실제 데이터가 저장되어 있는 데이터 갯수
		System.out.println("벡터 내의 요소 객체 수 : " + v.size());
		
		// 전체 용량
		System.out.println("벡터의 현재 용량 : " + v.capacity());
		
		// v.size() : 4
		for (int i = 0; i < v.size(); i++) {
			int n = v.get(i);
			System.out.println(n + " ");
		}
	}
}
