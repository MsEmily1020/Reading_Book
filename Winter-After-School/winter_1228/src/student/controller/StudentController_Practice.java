package student.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import student.view.StudentView_Practice;
import student.vo.StudentDAO_Practice;
import student.vo.StudentVO_Practice;

public class StudentController_Practice extends JFrame {
	StudentDAO_Practice dao = new StudentDAO_Practice();
	ArrayList<StudentVO_Practice> svo = dao.select();
	StudentView_Practice view = new StudentView_Practice();
	JButton bt = view.addBt();
	JTable table = view.table();
	
	public StudentController_Practice() {
		bt.addActionListener(e -> {
			dao.insert(view.returnData());
			svo = dao.select();
			view.getSvo(svo);
			view.setData();
			view.initInsetData();
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					int state =	JOptionPane.showConfirmDialog(null, "정말로 삭제 하시겠습니까?", "행을 삭제하기", JOptionPane.YES_NO_OPTION);
					if(state == JOptionPane.YES_OPTION) {
						dao.delete(table.getSelectedRow());
						svo = dao.select();
						view.getSvo(svo);
						view.setData();
						view.initInsetData();
					}
				}
			}
		});
		
		add(view, "Center");
		setTitle("성적처리프로그램");
		setSize(600, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(2);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		new StudentController_Practice().setVisible(true);
	}
}
