package class2_1.coll_ex.coll03;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListEx {
	public static void main(String[] args) {
		// ArrayList<String> a = new ArrayList<String>();
		// ArrayList<String> a = new ArrayList<>();
		var a = new ArrayList<String>();
		
		// 키보드 입력 객체 생성
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 4; i++) {
			System.out.print("이름을 입력하시오>>");
			String s = sc.next();	// 키보드로 문자열을 입력받음
			a.add(s);
		}
		
		for (int i = 0; i < 4; i++) {
			String name = a.get(i);	// 0부터 데이터 가져온후 name에 저장
			System.out.print(name + " ");
		}
		
		// 각 요소 저장되어 있는 데이터 길이 값을 가지고
		// 그 길이의 최대값에 해당되는 인덱스를 구하는 알고리즘
		int longestindex = 0;
		for (int i = 1; i < a.size(); i++) {
			if(a.get(longestindex).length() < a.get(i).length()) {
				longestindex = i;
			}
		}
		
		System.out.println("\n가장 긴 이름은 : " + a.get(longestindex));
	}
}
