package student.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import student.vo.StudentDAO;
import student.vo.StudentVO;

public class StudentView extends JPanel {
	JPanel gridPn = new JPanel(new GridLayout(5, 4));
	ArrayList<StudentVO> stuVoList;
	String[] header = "학번,성명,학년,반,국어,영어,수학,과학,총점,평균".split(",");
	JTextField[] tf = new JTextField[header.length - 2];
	JButton bt = new JButton("추가하기");
	DefaultTableModel model;
	JTable table;
	JScrollPane scroll;

	//GridPanel
	public StudentView() {
		setLayout(new BorderLayout());

		for (int i = 0; i < tf.length; i++) {
			gridPn.add(new JLabel(header[i]));
			gridPn.add(tf[i] = new JTextField());
		}

		for (int i = 0; i < 3; i++) gridPn.add(new JLabel());
		gridPn.add(bt);
	}

	//JTable
	public void setTable() {
		model = new DefaultTableModel(header, stuVoList.size()) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};

		table = new JTable(model);

		int[] columnSize = {50, 100, 50, 50, 100, 100, 100, 100, 100, 100};
		for(int i = 0; i < columnSize.length; i++) table.getColumnModel().getColumn(i).setPreferredWidth(columnSize[i]);
		scroll = new JScrollPane(table);
		
		setTableModel();

		add("Center", scroll);
		add("South", gridPn);
	}

	//JTable setting
	public void setTableModel() {
		model.setRowCount(stuVoList.size());
		StudentVO vo = null;
		for (int i = 0; i < stuVoList.size(); i++) {
			vo = stuVoList.get(i);

			model.setValueAt(vo.getStuNum(), i, 0);
			model.setValueAt(vo.getName(), i, 1);
			model.setValueAt(vo.getGrade(), i, 2);
			model.setValueAt(vo.getClassroom(), i, 3);
			model.setValueAt(vo.getKor(), i, 4);
			model.setValueAt(vo.getEng(), i, 5);
			model.setValueAt(vo.getMath(), i, 6);
			model.setValueAt(vo.getScience(), i, 7);
			model.setValueAt(vo.getTotal(), i, 8);
			model.setValueAt(vo.getAvg(), i, 9);
		}
	}

	public void setStudentVOList(ArrayList<StudentVO> stuVoList) {
		this.stuVoList = stuVoList;
	}

	public JButton getBtnAdd() {
		return bt;
	}

	public StudentVO neededInsertData() {
		StudentVO vo = new StudentVO();
		vo.setStuNum(Integer.parseInt(tf[0].getText()));
		vo.setName(tf[1].getText());
		vo.setGrade(Integer.parseInt(tf[2].getText()));
		vo.setClassroom(Integer.parseInt(tf[3].getText()));
		vo.setKor(Integer.parseInt(tf[4].getText()));
		vo.setEng(Integer.parseInt(tf[5].getText()));
		vo.setMath(Integer.parseInt(tf[6].getText()));
		vo.setScience(Integer.parseInt(tf[7].getText()));
		vo.setTotal();
		vo.setAvg();
		return vo;
	}

	public void initInsertData() {
		for (int i = 0; i < tf.length; i++) tf[i].setText("");
	}
	
	public JTable getTable() {
		return table;
	}
}
