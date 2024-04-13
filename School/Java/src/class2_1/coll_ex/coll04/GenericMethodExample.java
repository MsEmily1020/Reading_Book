package class2_1.coll_ex.coll04;

public class GenericMethodExample {
	// <T> : 특정메소드에 제네릭 적용하겠다
	// GStack<T> : reverse() 리턴 타입
	// reverse(GStack<T> a) : a는 GStack클래스 객체변수
	public static <T> GStack<T> reverse(GStack<T> a) {	// a = gs객체
		GStack<T> s = new GStack<T>(); // GStack클래스 새로운 객체 생성
		while(true) {
			T tmp;
			tmp = a .pop();	// 객체변수 a에 저장되어 있는 데이터 하나씩 읽어 tmp에 저장
			if(tmp == null) break;
			else s.push(tmp);
		}
		
		return s;
	}
	
	public static void main(String[] args) {
		GStack<Double> gs = new GStack<Double>();
		
		for (int i = 0; i < 5; i++) {
			gs.push(new Double(i));
		}
		
		gs = reverse(gs);
		
		for (int i = 0; i < 5; i++) {
			System.out.println(gs.pop());
		}
	}
}
