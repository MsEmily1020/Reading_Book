package class1_2.Class;

class Over {
	void show(String str) {
		System.out.println("매개변수가 전달됨 : " + str);
	}
	
	void show() {
		System.out.println("동일한 이름의 메서드가 있어도 오류x, 매개변수가 다른 오버로딩 메서드입니다.");
	}
}
public class Overloading {
	public static void main(String[] args) {
		Over t1 = new Over();
		t1.show();
		t1.show("mirim");
	}
}
