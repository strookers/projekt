package GUILayer;

import javax.swing.*;
import java.awt.Component;

public class GUITab extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public GUITab()
	{
		setVisible(true);
		setTitle("test");
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 0, 988, 442);
		getContentPane().add(tabbedPane_1);
		
	}
}
