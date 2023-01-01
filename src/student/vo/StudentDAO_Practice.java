package student.vo;

import java.util.ArrayList;

public class StudentDAO_Practice {
	ArrayList<StudentVO_Practice> svo = new ArrayList<StudentVO_Practice>();
	
	public void insert(StudentVO_Practice svo) {
		this.svo.add(svo);
	}
	
	public ArrayList<StudentVO_Practice> select() {
		return this.svo;
	}
	
	public void delete(int row) {
		this.svo.remove(row);
	}
}
