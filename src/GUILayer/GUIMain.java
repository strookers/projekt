package GUILayer;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.SystemColor;
public class GUIMain extends JFrame{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private GUIStart gStart;
	public static void main(String[] args) {
		new GUIMain();
	}
	
	public GUIMain() {
		gStart = new GUIStart();
		makeWindowFrame();
		setVisible(true);
	}
	
	public void makeWindowFrame()
	{
		getContentPane().setLayout(null);
		setMinimumSize(new Dimension(1200, 720));
		setPreferredSize(new Dimension(1200, 720));
		setTitle("Gruppe 4 Projekt");
		
		JMenuBar fileMenu = new JMenuBar();
		fileMenu.setBounds(0, 0, 1314, 26);
		getContentPane().add(fileMenu);
		
		JMenu mnFiler = new JMenu("Filer");
		fileMenu.add(mnFiler);
		
		JMenuItem mntmAfslut = new JMenuItem("Afslut");
		mntmAfslut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				gStart.makeFrame();
			}
		});
		mnFiler.add(mntmAfslut);
		
		JMenu mnHelp = new JMenu("Hj\u00E6lp");
		fileMenu.add(mnHelp);
		
		JMenuItem mntmOm = new JMenuItem("Om");
		mnHelp.add(mntmOm);
		
		JMenuItem mntmInstruktioner = new JMenuItem("Instruktioner");
		mnHelp.add(mntmInstruktioner);
	}
	
	public void makeLogInFrame()
	{
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBorder(new TitledBorder(null, "Log ind", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(361, 199, 373, 218);
		getContentPane().add(panel);
		panel.setLayout(null);
	}
}
