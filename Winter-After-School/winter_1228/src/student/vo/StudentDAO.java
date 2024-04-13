package student.vo;

import java.util.ArrayList;

public class StudentDAO {
	ArrayList<StudentVO> stuList = new ArrayList<StudentVO>();
	
	public void setDAO(StudentVO stu) {
		stuList.add(stu);
	}
	
	public ArrayList<StudentVO> getDAO() {
		return stuList;
	}
	
	public void delete(int row) {
		stuList.remove(row);
	}
}
