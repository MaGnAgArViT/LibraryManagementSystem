package library;

import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Book {
    public String bName;
    public String isbn1;
    public String isbn2;
    public int bCopies;
    public String edition;
    public String language;
    public String publication;
    public String author;
    public String genere1;
    public String genere2;
    public String genere3;
    public String position;
    public int year;
    public Book ()
    {
	bName = isbn1 = isbn2 = edition = publication = author = genere1 = genere2 = genere3 = position = language = "";
	year = bCopies = 0;
    }
    void bGetData ()
    {
	JFrame frame = new JFrame();
	frame.setLayout(new FlowLayout());
	frame.setSize(420,620);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
		System.exit(0);
            }        
	});
	JPanel controlPanel = new JPanel();
	controlPanel.setLayout(new GridLayout(10,1));
	controlPanel.setPreferredSize(new Dimension(400,600));
	JLabel label1 = new JLabel("ENTER BOOK INFO" , JLabel.CENTER);
	JLabel label2 = new JLabel("Enter Genere :- " , JLabel.LEFT);
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
	controlPanel6.setLayout(new GridLayout(2,1,5,5));
	JPanel controlPanel7 = new JPanel();
	controlPanel7.setLayout(new GridLayout(2,2,5,5));
	JPanel controlPanel8 = new JPanel();
	controlPanel8.setLayout(new GridLayout(1,2,5,5));
	JPanel controlPanel9 = new JPanel();
	controlPanel9.setLayout(new GridLayout(1,2,5,5));
        JPanel controlPanel10 = new JPanel();
	controlPanel10.setLayout(new FlowLayout(2));
        JPanel controlPanel11 = new JPanel();
	controlPanel11.setLayout(new FlowLayout(3));
	controlPanel.add(label1);
	controlPanel6.add(label2);
	controlPanel6.add(controlPanel9);
        controlPanel8.add(controlPanel10);
        controlPanel8.add(controlPanel11);
	controlPanel.add(controlPanel1);
	controlPanel.add(controlPanel2);
	controlPanel.add(controlPanel3);
	controlPanel.add(controlPanel4);
	controlPanel.add(controlPanel5);
	controlPanel.add(controlPanel6);
	controlPanel.add(controlPanel7);
	controlPanel.add(controlPanel8);
	controlPanel.add(label3);
	frame.add(controlPanel);
	JLabel L1 = new JLabel("Name * : ",JLabel.LEFT);
	JLabel L2 = new JLabel("ISBN-10 * : ",JLabel.LEFT);
	JLabel L3 = new JLabel("ISBN-13 * : ",JLabel.LEFT);
	JLabel L4 = new JLabel("Available Copies :",JLabel.LEFT);
	JLabel L5 = new JLabel("Edition : ",JLabel.LEFT);
	JLabel L6 = new JLabel("Publication : ",JLabel.LEFT);
	JLabel L7 = new JLabel("Author : ",JLabel.LEFT);
	JLabel L8 = new JLabel("Shelf Number : ",JLabel.LEFT);
	JLabel L9 = new JLabel("Language : ",JLabel.LEFT);
	JLabel L10 = new JLabel("Year Of Re-print : ",JLabel.LEFT);
	JLabel L11 = new JLabel("1 : ",JLabel.CENTER);
	JLabel L12 = new JLabel("2 : ",JLabel.CENTER);
	JLabel L13 = new JLabel("3 : ",JLabel.CENTER);
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
	TextField T10 = new TextField();
	TextField T11 = new TextField();
	TextField T12 = new TextField();
	TextField T13 = new TextField();
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
                String s8 = T9.getText();
                String s9 = T11.getText();
                String s10 = T12.getText();
                String s11 = T13.getText();
                int i1 = 0;
                int i2 = 0;
                if(!T4.getText().trim().isEmpty())
                    i1 = Integer.parseInt(String.valueOf(T4.getText()));
                if(!T10.getText().trim().isEmpty())
                    i2 = Integer.parseInt(String.valueOf(T10.getText()));
                try
                {
                    String S1 = "SELECT * FROM BOOKS WHERE isbn1 = '" + s2 +"' OR isbn2 = '" + s3 + "'";
                    ResultSet rs = C.s.executeQuery(S1);
                    if(rs.next())
                        JOptionPane.showMessageDialog(null,"Invalid ISBN-10 OR ISBN-13 Code");
                    else
                    {
                        if((!T1.getText().trim().isEmpty()) && (!T2.getText().trim().isEmpty()) && (!T3.getText().trim().isEmpty()))
                        {  
                            String S =  "INSERT INTO BOOKS ( bName , isbn1 , isbn2 , edition , publication , author , position , language , genere1 , genere2 , genere3 , bCopies , year)" +
                                        "VALUES ('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "','" + s9 + "','" + s10 + "','" + s11 + "'," + i1 + "," + i2 + ")";
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
                            m.menu4();
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
                m.menu4();
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
	controlPanel3.add(L5);
	controlPanel3.add(T5);
	controlPanel3.add(L6);
	controlPanel3.add(T6);
	controlPanel4.add(L7);
	controlPanel4.add(T7);
	controlPanel4.add(L8);
	controlPanel4.add(T8);
	controlPanel5.add(L9);
	controlPanel5.add(T9);
	controlPanel5.add(L10);
	controlPanel5.add(T10);
	controlPanel9.add(L11);
	controlPanel9.add(T11);
	controlPanel7.add(L12);
	controlPanel7.add(T12);
	controlPanel7.add(L13);
	controlPanel7.add(T13);
	controlPanel10.add(submitButton);
        controlPanel11.add(cancelButton);
	frame.setVisible(true);
    }
    void bShowData (Book b) throws IOException , ClassNotFoundException
    {
	FileHandling f = new FileHandling();
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
	controlPanel.setPreferredSize(new Dimension(350,420));
	controlPanel.setLayout(new GridLayout(13,2));
	JPanel controlPanel1 = new JPanel();
	controlPanel1.setLayout(new FlowLayout(2));
	frame.add(controlPanel);
	JLabel headLabel = new JLabel("Required Book Info" , JLabel.RIGHT);
	JLabel emptyLabel = new JLabel("");
	JLabel L1 = new JLabel("Name : " , JLabel.LEFT);
	JLabel L2 = new JLabel("ISBN-10 : " , JLabel.LEFT);
	JLabel L3 = new JLabel("ISBN-13 : " , JLabel.LEFT);
	JLabel L4 = new JLabel("No. of books Available : " , JLabel.LEFT);
	JLabel L5 = new JLabel("Edition : " , JLabel.LEFT);
	JLabel L6 = new JLabel("Language : " , JLabel.LEFT);
	JLabel L7 = new JLabel("Publication : " , JLabel.LEFT);
	JLabel L8 = new JLabel("Author : " , JLabel.LEFT);
	JLabel L9 = new JLabel("Genere : " , JLabel.LEFT);
	JLabel L10 = new JLabel("Shelf No. : " , JLabel.LEFT);
	JLabel L11 = new JLabel("Year Of Re-print : " , JLabel.LEFT);
	JLabel l1 = new JLabel(b.bName , JLabel.LEFT);
	JLabel l2 = new JLabel(b.isbn1 , JLabel.LEFT);
	JLabel l3 = new JLabel(b.isbn2 , JLabel.LEFT);
	JLabel l4 = new JLabel(String.valueOf(b.bCopies) , JLabel.LEFT);
	JLabel l5 = new JLabel(b.edition , JLabel.LEFT);
	JLabel l6 = new JLabel(b.language , JLabel.LEFT);
	JLabel l7 = new JLabel(b.publication , JLabel.LEFT);
	JLabel l8 = new JLabel(b.author , JLabel.LEFT);
	JLabel l9 = new JLabel(b.genere1 + "," + b.genere2 + "," + b.genere3 , JLabel.LEFT);
	JLabel l10 = new JLabel(b.position , JLabel.LEFT);
        String s = "-";
        if(b.year != 0)
            s = String.valueOf(b.year);
	JLabel l11 = new JLabel(s , JLabel.LEFT);
	JButton doneButton = new JButton("Done");
        doneButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
            }
        });
	controlPanel.add(headLabel);
	controlPanel.add(emptyLabel);
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
	controlPanel.add(L6);
	controlPanel.add(l6);
	controlPanel.add(L7);
	controlPanel.add(l7);
	controlPanel.add(L8);
	controlPanel.add(l8);
	controlPanel.add(L9);
	controlPanel.add(l9);
	controlPanel.add(L10);
	controlPanel.add(l10);
	controlPanel.add(L11);
	controlPanel.add(l11);
	controlPanel1.add(doneButton);
	controlPanel.add(controlPanel1);
	frame.setVisible(true);
    }
    void rCopy ()
    {
    	bCopies--;
    }
    void iCopy ()
    {
	bCopies++;
    }
}