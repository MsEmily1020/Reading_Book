package class2_1.interface_ex.in01;

public class Point {
	private int x, y;
	public void set(int x, int y) {
		this.x = x; // 멤버 변수 x에 int값 저장
		this.y = y; // 멤버 변수 y에 int값 저장
	} 
	
	public void showPoint() {
		// 멤버 변수 x, y값 출력
		System.out.println("(" + x + ", " + y + ")");
	}
}
