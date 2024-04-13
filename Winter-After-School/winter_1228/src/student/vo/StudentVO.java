package student.vo;

public class StudentVO {
	int stuNum;
	String name;
	int grade;
	int classroom;
	int kor;
	int eng;
	int math;
	int science;
	int total;
	double avg;
	
	public StudentVO() {};
	
	public StudentVO(int stuNum, String name, int grade, int classroom, int kor, int eng, int math, int science) {
		this.stuNum = stuNum;
		this.name = name;
		this.grade = grade;
		this.classroom = classroom;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.science = science;
	}

	public int getStuNum() {
		return stuNum;
	}

	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassroom() {
		return classroom;
	}

	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal() {
		this.total = kor + eng + math + science;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg() {
		this.avg = total / 4.0;
	}
	
}
