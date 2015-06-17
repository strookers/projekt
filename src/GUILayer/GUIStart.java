package GUILayer;
import CtrLayer.*;
import ModelLayer.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// this start here
public class GUIStart extends JFrame{
	private PersonCtr personCtr;
	//private ItemCtr itemCtr;
	//private OrderCtr orderCtr;
    private SaveLoadCtr saveLoadCtr;
	
	private String name;
	private String address;
	private String city;
	private int phone;
	private int ID;
	
	private JTextField txtNavn;
	private JTextField txtAdr;
	private JTextField txtCity;
	private JTextField txtPhone;
	private JTextField txtId;
	private JTextField txtBarcode;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUIStart();
	}
	
	public GUIStart()
	{
		saveLoadCtr = new SaveLoadCtr();
        try
        {
            saveLoadCtr.load();
        }
        catch(IOException e)
        { 
            e.printStackTrace();
        }
        catch(ClassNotFoundException e)
        { 
            e.printStackTrace();
        }
        //orderCtr = new OrderCtr();
        //itemCtr = new ItemCtr();
		personCtr = new PersonCtr();
		makeFrame();
	}
	//Her blive alle GUI elementer sat op
	public void makeFrame()
	{
		getContentPane().setLayout(null);
		
		JPanel customerPanel = new JPanel();
		setMinimumSize(new Dimension(1280, 720));
		setPreferredSize(new Dimension(1280, 720));
		setTitle("Gruppe 4 Projekt");
		customerPanel.setBorder(new TitledBorder(null, "Kunde Panel", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		customerPanel.setBounds(12, 87, 304, 252);
		getContentPane().add(customerPanel);
		customerPanel.setLayout(null);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(12, 33, 55, 16);
		customerPanel.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(80, 30, 46, 22);
		customerPanel.add(txtId);
		txtId.setColumns(10);
		
		// dette er en knap til findCustomer metoden
		JButton btnFind = new JButton("Find");
		btnFind.setBounds(212, 29, 80, 25);
		
		//Dette definere hvad knappen skal gøre når du klikker på den
		btnFind.addActionListener(new FindListener());
		customerPanel.add(btnFind);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 62, 280, 2);
		customerPanel.add(separator);
		
		JLabel lblNavn = new JLabel("Navn:");
		lblNavn.setBounds(12, 82, 55, 16);
		customerPanel.add(lblNavn);
		
		txtNavn = new JTextField();
		txtNavn.setBounds(80, 76, 115, 22);
		lblNavn.setLabelFor(txtNavn);
		customerPanel.add(txtNavn);
		txtNavn.setColumns(10);
		
		txtAdr = new JTextField();
		txtAdr.setColumns(10);
		txtAdr.setBounds(80, 108, 115, 22);
		customerPanel.add(txtAdr);
		
		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setBounds(12, 114, 55, 16);
		customerPanel.add(lblAdresse);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(80, 140, 115, 22);
		customerPanel.add(txtCity);
		
		JLabel lblBy = new JLabel("By:");
		lblBy.setBounds(12, 146, 55, 16);
		customerPanel.add(lblBy);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(80, 172, 115, 22);
		customerPanel.add(txtPhone);
		
		JLabel lblTlf = new JLabel("Tlf:");
		lblTlf.setBounds(12, 178, 55, 16);
		customerPanel.add(lblTlf);
		
		JButton btnOpret = new JButton("Opret");
		btnOpret.setBounds(212, 212, 80, 25);
		btnOpret.addActionListener(new OpretListener());
		customerPanel.add(btnOpret);
		
		JButton btnRet = new JButton("Ret");
		btnRet.setBounds(115, 212, 80, 25);
		btnRet.addActionListener(new RetListener());
		customerPanel.add(btnRet);
		
		JButton btnSlet = new JButton("Slet");
		btnSlet.setBounds(12, 212, 80, 25);
		btnSlet.addActionListener(new SletListener());
		customerPanel.add(btnSlet);
		
		JPanel itemPanel = new JPanel();
		itemPanel.setBorder(new TitledBorder(null, "Tilf\u00F8j Varer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		itemPanel.setBounds(12, 13, 304, 61);
		getContentPane().add(itemPanel);
		itemPanel.setLayout(null);
		
		JLabel lblStrejkode = new JLabel("Strejkode:");
		lblStrejkode.setBounds(12, 29, 68, 16);
		itemPanel.add(lblStrejkode);
		
		txtBarcode = new JTextField();
		txtBarcode.setBounds(80, 26, 100, 22);
		itemPanel.add(txtBarcode);
		txtBarcode.setColumns(10);
		
		JButton btnAddItem = new JButton("Tilf\u00F8j");
		btnAddItem.setBounds(212, 25, 80, 25);
		itemPanel.add(btnAddItem);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(328, 13, 922, 326);
		getContentPane().add(tabbedPane);
		
		JMenuItem mntmOrder = new JMenuItem("Order");
		tabbedPane.addTab("Order", null, mntmOrder, null);
		
		JMenuItem mntmPerson = new JMenuItem("Person");
		tabbedPane.addTab("Person", null, mntmPerson, null);
		
		JMenuItem mntmItem = new JMenuItem("Item");
		tabbedPane.addTab("Item", null, mntmItem, null);
		this.setVisible(true);
	}
	
	public void addCustomer()
	{
		String name = txtNavn.getText();
		String address = txtAdr.getText();
		String city = txtCity.getText();
		int phone = Integer.parseInt(txtPhone.getText());
		
		Person p = personCtr.createCustomer(name, phone, address, city, ModelLayer.Customer.Type.PRIVATE);
        if (p != null)
        {
        	System.out.println("Der er oprettet en ny kunde med ID: " + p.getID());
        	txtId.setText(Integer.toString(p.getID()));
        }
        else
        {
            System.out.println("Det lykkedes ikke at oprette en ny kunde");
        }
		
		System.out.println(name + " " + address + " " + city + " " + phone);
		
	}
	
	public void findCustomer()
	{
		int ID = Integer.parseInt(txtId.getText());
		
		if (personCtr.findPerson(ID) != null)
        {
            Person person = personCtr.findPerson(ID);
            System.out.println("Der er fundet en person med navn: " + person.getName());

    		txtNavn.setText(person.getName());
    		txtAdr.setText(person.getAddress());
    		txtCity.setText(person.getCity());
    		txtPhone.setText(Integer.toString(person.getPhone()));
        }
        else
        {
        	System.out.println("Det lykkedes ikke at finde en person med ID: " + ID);
        }
	}
	
	public void updateCustomer()
	{
		int ID = Integer.parseInt(txtId.getText());
		String name = txtNavn.getText();
		String address = txtAdr.getText();
		String city = txtCity.getText();
		int phone = Integer.parseInt(txtPhone.getText());
		
		personCtr.updatePerson(name, phone, address, city, ID);
	}
	
	public void deleteCustomer()
	{
		int ID = Integer.parseInt(txtId.getText());
		personCtr.deletePerson(ID);
		
		txtId.setText("");
		txtNavn.setText("");
		txtAdr.setText("");
		txtCity.setText("");
		txtPhone.setText("");
	}
	
	private class FindListener implements ActionListener
	{
        public void actionPerformed(ActionEvent e)
            {
        		findCustomer();
            }
	}
	
	private class OpretListener implements ActionListener
	{
        public void actionPerformed(ActionEvent e)
            {
        		addCustomer();
            }
	}
	
	private class RetListener implements ActionListener
	{
        public void actionPerformed(ActionEvent e)
            {
        		updateCustomer();
            }
	}
	
	private class SletListener implements ActionListener
	{
        public void actionPerformed(ActionEvent e)
            {
        		deleteCustomer();
            }
	}
}
