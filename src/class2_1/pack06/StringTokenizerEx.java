package class2_1.pack06;

import java.util.StringTokenizer;

public class StringTokenizerEx {
	public static void main(String[] args) {
		// (String1, String2)
		// String1 : 토큰
		// String2 : 구분자
		// st는 첫번째 토큰가리킴(홍길동)
		StringTokenizer st = new StringTokenizer("홍길동/장화/홍련/콩쥐/팥쥐", "/");
		while(st.hasMoreTokens()) { // 토큰 존재 : true (아니면 false) 반환
			System.out.println(st.nextToken()); // 현재 토큰 출력 -> 다음 토큰 가리킴 반복
		}
	}																																								
}
