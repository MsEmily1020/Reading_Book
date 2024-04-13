package class2_1.coll_ex.coll04;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;


public class CollectionsEx {
	static void printList(LinkedList<String> link) { // link = myList
		Iterator<String> iterator = link.iterator(); // 순차적으로 접근
		while(iterator.hasNext()) {			// iterator가 가리키는 곳에 데이터 존재 여부
			String e = iterator.next();		// iterator가 가리키는 곳의 데이터를 e에게 넘겨줌 + 다음 데이터를 가리킴
			String separator;
			if(iterator.hasNext())
				separator = "=>";
			else
				separator = "\n";
			
			System.out.println(e+separator);
		}
	}
	
	public static void main(String[] args) {
		LinkedList<String> myList = new LinkedList<String>();
		myList.add("트랜스포머");
		myList.add("스타워즈");
		myList.add("매트릭스");
		
		printList(myList);

		myList.add(0, "터미네이터");		// 터미네이터 -> 트랜스포머 -> 스타워즈 -> 매트릭스
		myList.add(2, "아바타");			// 터미네이터 -> 트랜스포머 -> 아바타 -> 스타워즈 -> 매트릭스
		
		printList(myList);
		
		Collections.sort(myList);		// 오름차순(ascending sort)
		printList(myList);
		
		Collections.reverse(myList);	// 역순
		printList(myList);
		
		int index = Collections.binarySearch(myList, "아바타") + 1;
		System.out.println("아바타는 " + index + "번째 요소입니다.");
	}
}
