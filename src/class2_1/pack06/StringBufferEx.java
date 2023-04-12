package class2_1.pack06;

public class StringBufferEx {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("This");
		
		// 문자열 연결 ex) This + is pencil
		sb.append(" is pencil");
		System.out.println(sb);
		
		// (index, 문자열)
		// index : 어디 위치에 문자열을 추가할 것인지
		// T(0) h(1) i(2) s(3) ' '(4) i(5) s(6) ' '(7) ...
		// -> T(0) h(1) i(2) s(3) ' '(4) i(5) s(6) +m(7)y(8) ' '(기존 7 -> 후 9) ... 
		sb.insert(7, " my");
		System.out.println(sb);
				
		// (index1, index2, 문자열)
		// index1 ~ index2미만
		// 문자열 8~9까지 문자열을 입력받은 문자열로 변환
		sb.replace(8, 10, "your");
		System.out.println(sb);
		
		// (index1 ,index2) : index1 ~ index2미만까지
		// your' '을 삭제
		sb.delete(8, 13);
		System.out.println(sb);
		
		// sb의 문자열 길이를 index로 지정 (초과한 문자열은 삭제)
		sb.setLength(4);
		System.out.println(sb);
	}
}
