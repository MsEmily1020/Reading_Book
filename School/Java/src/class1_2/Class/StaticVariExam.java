package class1_2.Class;

class Student_Test {
	String name;
	int grade;
	static int count = 0;
	public Student_Test() {
		count++;
	}
}

public class StaticVariExam {
	public static void main(String[] args) {
		Student_Test kim = new Student_Test();
		System.out.println("생성된 학생 객체 수는 " + Student_Test.count + "입니다.");
		Student_Test jang = new Student_Test();
		System.out.println("생성된 학생 객체 수는 " + Student_Test.count + "입니다.");
		Student_Test bak = new Student_Test();
		System.out.println("생성된 학생 객체 수는 " + Student_Test.count + "입니다.");
		Student_Test min = new Student_Test();
		System.out.println("생성된 학생 객체 수는 " + Student_Test.count + "입니다.");
	}
}