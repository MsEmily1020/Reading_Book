package class2_1.coll_ex.coll03;

import java.util.Iterator;
import java.util.Vector;

public class IteratorEx {
	public static void main(String[] args) {
		int sum = 0;
		Vector<Integer> v = new Vector<Integer>();
		v.add(5);		// 인덱스 0번째 5 삽입	
		v.add(4);		// 인덱스 1번째 4 삽입
		v.add(-1);		// 인덱스 2번째 -1 삽입
		v.add(2, 100);	// 인덱스 2번째 100 삽입 후 -1은 뒤로

		// Iterator it 객체변수는 v객체변수의 iterator()메서드에 의해서 객체 생성
		// it는 v객체 데이터의 첫번째 요소를 가리킴
		Iterator<Integer> it = v.iterator();
		while(it.hasNext()) {
			// N번째 요소에 데이터가 존재하면 true 값 변환 (없으면 false)
			int n = it.next();	// n에 N번째 요소 넘겨주고 다음 요소 가리킴
			sum += n;
			System.out.print(n + " ");
		}
		System.out.println("\n벡터에 있는 정수의 합 : " + sum);
	}
}
