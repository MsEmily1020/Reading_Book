package class1_2.Class;

public class TwoBox {
	public static void main(String[] args) {
		Box box1 = new Box(3, 7, 5);
		Box box2 = new Box(4, 6, 3);
		Box box3 = new Box();
		
		System.out.println(box1.print() + box1.calc_vol());
		System.out.println(box2.print() + box2.calc_vol());
		System.out.println(box3.print() + box3.calc_vol());
	}
}

class Box {
	int width;
	int height;
	int depth;
	//전역 : 처음 ~ 끝 생존력 > 지역 : 중괄호 생존력
	static int cnt;
	
	//생성자
	// 1. 클래스 이름과 동일
	// 2. 리턴형 없음
	// 3. 오버로딩
	
	Box() { cnt++; System.out.println("객체 " + cnt + "생성"); }
	Box (int w, int h, int d) {
		this.width = w;
		this.height = h;
		this.depth = d;
		cnt++; System.out.println("객체 " + cnt + "생성");
	}
	
	int calc_vol() { return this.width * this.height * this.depth; }

	String print() { return "(" + this.width + ", " + this.height + ", " + this.depth + ")의 부피 : "; }
} 