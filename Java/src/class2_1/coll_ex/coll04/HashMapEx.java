package class2_1.coll_ex.coll04;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx {
	public static void main(String[] args) {
		// <key값, value값> = <String타입, String타입>
		HashMap<String, String> dic = new HashMap<String, String>();
		
		dic.put("baby", "아기");
		dic.put("love", "사랑");
		dic.put("apple", "사과");
		
		// 키보드 입력
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("찾고 싶은 단어는?");
			String eng = sc.next();
			// eng == exit : 문자열 주소값 비교
			if(eng.equals("exit")) {	// 문자열의 값 비교
				System.out.println("종료합니다...");
				break;
			}
		}
	}
}
