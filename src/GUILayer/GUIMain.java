package GUILayer;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class GUIMain extends JFrame{
	private GUIStart guistart;

	public static void main(String[] args) {
		new GUIMain();
	}
	
	public GUIMain() {
		guistart = new GUIStart();
		setMinimumSize(new Dimension(1200, 720));
		setVisible(true);
		getContentPane().setLayout(null);
		
		JMenuBar fileMenu = new JMenuBar();
		fileMenu.setBounds(0, 0, 1314, 26);
		getContentPane().add(fileMenu);
		
		JMenu mnFiler = new JMenu("Filer");
		fileMenu.add(mnFiler);
		
		JMenuItem mntmAfslut = new JMenuItem("Afslut");
		mntmAfslut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				guistart.makeFrame();
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
	
	public void makeFrame()
	{
		
	}
}
