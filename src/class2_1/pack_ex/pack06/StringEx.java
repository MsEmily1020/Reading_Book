package class2_1.pack_ex.pack06;

public class StringEx {
	public static void main(String[] args) {
		String a = new String(" C#");
		String b = new String(",C++");
		
		System.out.println(a + "길이는 " + a.length()); //공백도 길이 포함
		System.out.println(a.contains("#")); //a 문자열에 #이 포함되어 있는지 true/false 
		
		a = a.concat(b); //a와 b를 이어줌
		System.out.println(a);
		
		a = a.trim(); //양쪽공백제거
		System.out.println(a);
		
		a = a.replace("C#", "JAVA"); //replace([기존문자],[바꿀문자])
		System.out.println(a);
		
		String[] s = a.split(","); //split(기준)으로 문자열 분리
		for (int i = 0; i < s.length; i++) {
			System.out.println("분리된 문자열 " + i + ": " + s[i]);
		}
		
		a = a.substring(5); //인덱스 5부터 ~ 마지막 인덱스 까지만 출력
		System.out.println(a);
		
		char c = a.charAt(2); //charAt(인덱스값) 해당 값 출력
		System.out.println(c);
	}
}
