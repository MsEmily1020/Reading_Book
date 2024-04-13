package student.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import student.view.StudentView;
import student.vo.StudentDAO;
import student.vo.StudentVO;

public class StudentController extends JFrame {
	StudentDAO dao = new StudentDAO();
	ArrayList<StudentVO> stuList = dao.getDAO();
	StudentView view = new StudentView();
	JTable table;
	
	public StudentController() {
		view.setStudentVOList(stuList);
		view.setTable();
		JButton bt = view.getBtnAdd();
		bt.addActionListener(e -> {
			//neededInsertData() : panS에 있는 JTextField에 입력된 값들과 JCombobox의 값
			//BookVO 필드값들을 초기화하여 BookVO 객체 참조값을 반환하는 메소드
			StudentVO vo = view.neededInsertData();
			dao.setDAO(vo);
			stuList = dao.getDAO();
			view.setStudentVOList(stuList);
			view.setTableModel();
			view.initInsertData();
		});
	
		table = view.getTable();
		table.addMouseListener(tableL);
		
		add(view, "Center");
		setTitle("성적관리프로그램");
		setDefaultCloseOperation(2);
		setSize(600, 500);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new StudentController().setVisible(true);
	}

	MouseAdapter tableL = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			int state = 1;
			if(e.getClickCount() == 2) {
				state =	JOptionPane.showConfirmDialog(null, "정말로 삭제 하시겠습니까?", "행을 삭제하기", JOptionPane.YES_NO_OPTION);
				if(state == JOptionPane.YES_OPTION) {
					dao.delete(table.getSelectedRow());
					stuList = dao.getDAO();
					view.setStudentVOList(stuList);
					view.setTableModel();
					view.initInsertData();
				}
			}
		}
	};
}
