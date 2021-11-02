package library;

import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Member {
    public String mName;
    public String mCode;
    public String mNumber;
    public int age;
    public int counter;
    public String ibCode;
    public String hno;
    public String locality;
    public String city;
    public String state;
    public int pincode;
    public Member ()
    {
    	mName = mCode = mNumber = ibCode = hno = locality = city = state = "";
	age = counter = pincode = 0;
    }
    void mGetData ()
    {
	JFrame frame = new JFrame();
	frame.setLayout(new FlowLayout());
	frame.setSize(420,500);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
		System.exit(0);
            }        
	});
	JPanel controlPanel = new JPanel();
	controlPanel.setLayout(new GridLayout(9,1));
	controlPanel.setPreferredSize(new Dimension(400,480));
	JLabel label1 = new JLabel("ENTER MEMBER INFO" , JLabel.CENTER);
	JLabel label2 = new JLabel("Entrer Address :- " , JLabel.LEFT);
	JLabel label3 = new JLabel("" , JLabel.CENTER);
	JPanel controlPanel1 = new JPanel();
	controlPanel1.setLayout(new GridLayout(2,2,5,5));
	JPanel controlPanel2 = new JPanel();
	controlPanel2.setLayout(new GridLayout(2,2,5,5));
	JPanel controlPanel3 = new JPanel();
	controlPanel3.setLayout(new GridLayout(2,2,5,5));
	JPanel controlPanel4 = new JPanel();
	controlPanel4.setLayout(new GridLayout(2,2,5,5));
	JPanel controlPanel5 = new JPanel();
	controlPanel5.setLayout(new GridLayout(2,2,5,5));
	JPanel controlPanel6 = new JPanel();
	controlPanel6.setLayout(new GridLayout(1,2,5,5));
	JPanel controlPanel7 = new JPanel();
	controlPanel7.setLayout(new GridLayout(1,2,5,5));
        JPanel controlPanel8 = new JPanel();
        controlPanel8.setLayout(new FlowLayout(2));
        JPanel controlPanel9 = new JPanel();
        controlPanel9.setLayout(new FlowLayout(3));
	controlPanel.add(label1);
	controlPanel3.add(label2);
	controlPanel3.add(controlPanel7);
        controlPanel6.add(controlPanel8);
        controlPanel6.add(controlPanel9);
	controlPanel.add(controlPanel1);
	controlPanel.add(controlPanel2);
	controlPanel.add(controlPanel3);
	controlPanel.add(controlPanel4);
	controlPanel.add(controlPanel5);
	controlPanel.add(controlPanel6);
	controlPanel.add(label3);
	frame.add(controlPanel);
	JLabel L1 = new JLabel("Name * : ",JLabel.LEFT);
	JLabel L2 = new JLabel("Code * : ",JLabel.LEFT);
	JLabel L3 = new JLabel("contact No. * : ",JLabel.LEFT);
	JLabel L4 = new JLabel("age * :",JLabel.LEFT);
	JLabel L5 = new JLabel("Hno * : ",JLabel.LEFT);
	JLabel L6 = new JLabel("Locality * : ",JLabel.LEFT);
	JLabel L7 = new JLabel("City * : ",JLabel.LEFT);
	JLabel L8 = new JLabel("State * : ",JLabel.LEFT);
	JLabel L9 = new JLabel("Pincode * : ",JLabel.LEFT);
	JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("cancel");
	TextField T1 = new TextField();
	TextField T2 = new TextField();
	TextField T3 = new TextField();
	TextField T4 = new TextField();
	TextField T5 = new TextField();
	TextField T6 = new TextField();
	TextField T7 = new TextField();
	TextField T8 = new TextField();
	TextField T9 = new TextField();
	submitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                Conn C = new Conn();
		String s1 = T1.getText();
		String s2 = T2.getText();
		String s3 = T3.getText();
		String s4 = T5.getText();
		String s5 = T6.getText();
		String s6 = T7.getText();
		String s7 = T8.getText();
                int i1 = 0;
                int i2 = 0;
		if(!T4.getText().trim().isEmpty())
                    i1 = Integer.parseInt(String.valueOf(T4.getText()));
                if(!T9.getText().trim().isEmpty())
                    i2 = Integer.parseInt(String.valueOf(T9.getText()));
                String S1 = "SELECT * FROM MEMBERS WHERE mCode = '" + s2 +"'";
                try
                {
                    ResultSet rs = C.s.executeQuery(S1);
                    if(rs.next())
                        JOptionPane.showMessageDialog(null,"Member Code : " + s2 +" Is Already Used !!");
                    else
                    {
                        if((!T1.getText().trim().isEmpty()) && (!T2.getText().trim().isEmpty()) && (!T3.getText().trim().isEmpty())
                            && (!T5.getText().trim().isEmpty()) && !T6.getText().trim().isEmpty() && (!T7.getText().trim().isEmpty()) 
                            && (!T8.getText().trim().isEmpty()) && (i1 != 0) && i2 != 0)
                        {  
                            String S =  "INSERT INTO MEMBERS ( mName , mCode , mNumber , hno , locality , city , state , age , pincode , counter)" +
                                        "VALUES ('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "'," + i1 + "," + i2 + "," + 0 +")";
                            try
                            {
                                C.s.executeUpdate(S);
                            }
                            catch(Exception E)
                            {
                                E.printStackTrace();
                            }
                            frame.dispose();
                            Menu m = new Menu();
                            m.menu3();
                        }
                        else
                            JOptionPane.showMessageDialog(null,"Incomplete Information!!");
                    }
                }
                catch(Exception E)
                {
                    E.printStackTrace();
                }
            }
	});
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.menu3();
            }
        });
	controlPanel1.add(L1);
	controlPanel1.add(T1);
	controlPanel1.add(L2);
	controlPanel1.add(T2);
	controlPanel2.add(L3);
	controlPanel2.add(T3);
	controlPanel2.add(L4);
	controlPanel2.add(T4);
	controlPanel7.add(L5);
	controlPanel7.add(T5);
	controlPanel4.add(L6);
	controlPanel4.add(T6);
	controlPanel4.add(L7);
	controlPanel4.add(T7);
	controlPanel5.add(L8);
	controlPanel5.add(T8);
	controlPanel5.add(L9);
	controlPanel5.add(T9);
	controlPanel8.add(submitButton);
        controlPanel9.add(cancelButton);
	frame.setVisible(true);
    }
    void mShowData (Member m) throws IOException , ClassNotFoundException
    {
	FileHandling f = new FileHandling();
	JFrame frame = new JFrame();
	frame.setLayout(new FlowLayout());
	frame.setSize(420,365);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
		System.exit(0);
            }        
	});
	JPanel controlPanel = new JPanel();
	controlPanel.setPreferredSize(new Dimension(350,285));
	controlPanel.setLayout(new GridLayout(8,2));
	JPanel controlPanel1 = new JPanel();
	controlPanel1.setLayout(new FlowLayout(2));
	frame.add(controlPanel);
	JLabel headLabel = new JLabel("Required Member Info" , JLabel.RIGHT);
	JLabel L1 = new JLabel("Name : " , JLabel.LEFT);
	JLabel L2 = new JLabel("Code : " , JLabel.LEFT);
	JLabel L3 = new JLabel("Contact No. : " , JLabel.LEFT);
	JLabel L4 = new JLabel("Age : " , JLabel.LEFT);
	JLabel L5 = new JLabel("Address : " , JLabel.LEFT);
	JLabel L6 = new JLabel(" ");
	JLabel L7 = new JLabel(" ");
	JLabel l1 = new JLabel(m.mName , JLabel.LEFT);
	JLabel l2 = new JLabel(m.mCode , JLabel.LEFT);
	JLabel l3 = new JLabel(m.mNumber , JLabel.LEFT);
	JLabel l4 = new JLabel(String.valueOf(m.age) , JLabel.LEFT);
	JLabel l5 = new JLabel(m.hno + "," + m.locality + "," , JLabel.LEFT);
	JLabel l6 = new JLabel(m.city + "," + m.state + "," + String.valueOf(m.pincode) , JLabel.LEFT);
	JButton doneButton = new JButton("Done");
        doneButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
            }
        });
	controlPanel.add(headLabel);
	controlPanel.add(L6);
	controlPanel.add(L1);
	controlPanel.add(l1);
	controlPanel.add(L2);
	controlPanel.add(l2);
	controlPanel.add(L3);
	controlPanel.add(l3);
	controlPanel.add(L4);
	controlPanel.add(l4);
	controlPanel.add(L5);
	controlPanel.add(l5);
	controlPanel.add(L7);
	controlPanel.add(l6);
	controlPanel1.add(doneButton);
	controlPanel.add(controlPanel1);
	frame.setVisible(true);
    }
    void setCounter ()
    {
	counter=0;
    }
    void incCounter ()
    {
	counter++;
    }
}