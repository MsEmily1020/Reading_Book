package class1_2.Class;

class Box_Test {
	int width;
	int height;
	int depth;
	
	Box_Test(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
	
	public void volume() {
		int volume = this.width * this.height * this.depth;
		System.out.println("부피:" + volume);
	}
}

public class BoxTest {
	public static void main(String[] args) {
		Box_Test box1 = new Box_Test(5, 3, 7);
		box1.volume();
		
		System.out.println(box1.width);
	}
}