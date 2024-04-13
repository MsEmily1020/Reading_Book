package project;

import javax.swing.JLabel;

public class Map extends BaseFrame {
	public Map() {
		super("map", 700, 600);
		main.add(setBounds(lb[0] = new JLabel(getIcon("datafiles/map.PNG", 700, 300)), 0, 0, 700, 300));
		
	}
	
	public static void main(String[] args) {
		new Map().setVisible(true);
	}
}
