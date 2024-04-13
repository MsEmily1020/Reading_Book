package class1_2.Class;

class First {
	String name = "class First";
	void show() {
		System.out.println("이름 : " + name);
	}
}

class Second extends First {
	void show() {
		System.out.println("이름이 출력될까요 ? : " + name);
	}
}

public class OverRiding {
	public static void main(String[] args) {
		First first = new First();
		Second second = new Second();
		
		first.show();
		second.show();
	}
}