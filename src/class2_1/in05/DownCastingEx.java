package class2_1.in05;

public class DownCastingEx {
	public static void main(String[] args) {
		Person p = new Student("이재문");
		Person p1 = new Person();
		
		Student s, s1;
		
		s = (Student)p;
		// s1 = (Student)p1;
		
		System.out.println(s.name);
		s.grade = "A";
		System.out.println(s.grade);
	}
}
