package student.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import student.vo.StudentVO_Practice;

public class StudentView_Practice extends JPanel {
	ArrayList<StudentVO_Practice> svo = new ArrayList<StudentVO_Practice>();
	JPanel gnPn = new JPanel(new GridLayout(5, 4));
	JTable table;
	DefaultTableModel model;
	String[] header = "학번,이름,학년,반,국어,영어,수학,과학,총점,평균".split(",");
	JTextField[] tf = new JTextField[header.length - 2];
	JButton bt = new JButton("추가");
	
	public StudentView_Practice() {
		setLayout(new BorderLayout());
		
		for (int i = 0; i < tf.length; i++) {
			gnPn.add(new JLabel(header[i]));
			gnPn.add(tf[i] = new JTextField());
		}
		
		for(int i = 0; i < 3; i++) gnPn.add(new JLabel());
		
		initTable();
		
		gnPn.add(bt);
	}
	
	public void initTable() {
		model = new DefaultTableModel(header, svo.size()) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table = new JTable(model);
		int[] columnSize = {50, 100, 50, 50, 100, 100, 100, 100, 100, 100};
		for (int i = 0; i < columnSize.length; i++) table.getColumnModel().getColumn(i).setPreferredWidth(columnSize[i]);
		
		JScrollPane scroll = new JScrollPane(table);
		
		add(scroll, "Center");
		add(gnPn, "South");
	}
	
	public void setData() {
		model.setRowCount(svo.size());
		
		StudentVO_Practice vo = null;
		
		for (int i = 0; i < svo.size(); i++) {
			vo = svo.get(i);
			
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
	
	public StudentVO_Practice returnData() {
		StudentVO_Practice vo = new StudentVO_Practice();
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
	
	public void getSvo(ArrayList<StudentVO_Practice> svo) {
		this.svo = svo;
	}
	
	public JButton addBt() {
		return bt;
	}
	
	public JTable table() {
		return table;
	}
	
	public void initInsetData() {
		for (int i = 0; i < tf.length; i++) tf[i].setText("");
	}
}
