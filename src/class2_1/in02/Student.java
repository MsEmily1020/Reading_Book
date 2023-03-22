package class2_1.in02;

public class Student extends Person {
	public void set() {
		age = 30;
		name = "홍길동";
		height = 175;
		// weight = 99; : private 접근 불가
		setWeight(99);
	} 
}
