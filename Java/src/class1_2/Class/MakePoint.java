package class1_2.Class;

import java.util.Scanner;

class Point {
	int no;
	int x, y;
	static int cnt;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
		this.no = ++cnt;
		printPoint();
	}
	
	void printPoint() {
		System.out.println(this.no + "번째 점의 좌표 : (" + this.x + ", " + this.y + ")");
	}
	
	void move(int x, int y) {
		this.x += x;
		this.y += y;
		System.out.print("이동한 ");
		printPoint();
	}
}

public class MakePoint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Point[] point = new Point[3];
		
		for(int i = 0; i < point.length; i++) {
			System.out.print((i + 1) + "번째 x좌표, y좌표 입력하세요 : ");
			point[i] = new Point(sc.nextInt(), sc.nextInt());
		}
		
		System.out.print("이동할 점을 선택하세요.");
		int sel_point = sc.nextInt();
		System.out.print("이동할 x좌표, y좌표 입력하세요 : ");
		point[sel_point - 1].move(sc.nextInt(), sc.nextInt());
	}
}