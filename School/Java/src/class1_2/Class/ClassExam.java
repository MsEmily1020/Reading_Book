package class1_2.Class;

class Student {
	String name;
	int grade;
	int ban;
	int number;
	String telephone;
	
	void init(String n, int g) {
		name = n;
		grade = g;
	}
	
	String print() {
		return "학생의 이름은 " + name + "이고, " + grade + "학년입니다.";
	}
}

public class ClassExam {
	public static void main(String[] args) {
		Student kim = new Student();
		Student hong = new Student();
		kim.init("김현우", 2);
		hong.init("홍길동", 1);
		System.out.println(kim.print());
		System.out.println(hong.print());
	}
}
