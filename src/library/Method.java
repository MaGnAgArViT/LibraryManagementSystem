package library;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Method {
    public String setwR(String str, int width)
    {
        String s = str;
	for (int x = str.length(); x < width; ++x) 
	{
            s += " ";	
	}
        return s;
    }
    void showTextArea (TextArea text , JLabel l)
    {
        Font font = new Font("Monospaced", Font.PLAIN, 12);
        text.setFont(font);
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(1030,550);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }        
        });
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout());
        controlPanel.setPreferredSize(new Dimension(1000,500));
        JPanel controlPanel1 = new JPanel();
        controlPanel1.setLayout(new FlowLayout());
        frame.add(controlPanel);
        JButton b = new JButton("OK");
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
            }
	});
        controlPanel1.add(b);
        controlPanel.add(l,BorderLayout.NORTH);
        controlPanel.add(controlPanel1,BorderLayout.SOUTH);
        controlPanel.add(text,BorderLayout.CENTER);
        frame.setVisible(true);
    }
    void mSearchCode ()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(400,200);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }        
        });
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3,1,0,5));
        controlPanel.setPreferredSize(new Dimension(350,150));
        JPanel controlPanel1 = new JPanel();
        controlPanel1.setLayout(new FlowLayout());
        JPanel controlPanel2 = new JPanel();
        controlPanel2.setLayout(new GridLayout(2,2,5,5));
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new GridLayout(1,2));
        JPanel controlPanel4 = new JPanel();
        controlPanel4.setLayout(new FlowLayout(2));
        JPanel controlPanel5 = new JPanel();
        controlPanel5.setLayout(new FlowLayout(3));
        controlPanel3.add(controlPanel4);
        controlPanel3.add(controlPanel5);
        controlPanel.add(controlPanel1);
        controlPanel.add(controlPanel2);
        controlPanel.add(controlPanel3);
        frame.add(controlPanel);
        JLabel headLabel = new JLabel("SEARCH : CODE" , JLabel.CENTER);
        TextField t1 = new TextField();
        JLabel l1 = new JLabel("Enter Member Code : " , JLabel.LEFT);
        JLabel l2 = new JLabel("" , JLabel.LEFT);
        JLabel l3 = new JLabel("" , JLabel.LEFT);
        JButton b1 = new JButton("submit");
        JButton b2 = new JButton("cancel");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                Member m = new Member();
                String s = new String(t1.getText());
                String S = "SELECT * FROM MEMBERS WHERE mCode = '" + s +"'";
                Conn C = new Conn();
                try
                {
                    ResultSet rs = C.s.executeQuery(S);
                    if(rs.next())
                    {
                        m.mName = rs.getString("mName");
                        m.mCode = rs.getString("mCode");
                        m.mNumber = rs.getString("mNumber");
                        m.hno = rs.getString("hno");
                        m.locality = rs.getString("locality");
                        m.city = rs.getString("city");
                        m.state = rs.getString("state");
                        m.age = rs.getInt("age");
                        m.pincode = rs.getInt("pincode");
                        m.mShowData(m);
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Code Not Found!!");
                }
                catch(Exception E)
                {
                    E.printStackTrace();
                }
            }
	});
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.mSmenu();
            }
	});
        controlPanel1.add(headLabel);
        controlPanel2.add(l1);
        controlPanel2.add(t1);
        controlPanel2.add(l2);
        controlPanel2.add(l3);
        controlPanel4.add(b1);
        controlPanel5.add(b2);
        frame.setVisible(true);
    }
    void mSearchName ()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(400,200);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }        
        });
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3,1,0,5));
        controlPanel.setPreferredSize(new Dimension(350,150));
        JPanel controlPanel1 = new JPanel();
        controlPanel1.setLayout(new FlowLayout());
        JPanel controlPanel2 = new JPanel();
        controlPanel2.setLayout(new GridLayout(2,2,5,5));
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new GridLayout(1,2));
        JPanel controlPanel4 = new JPanel();
        controlPanel4.setLayout(new FlowLayout(2));
        JPanel controlPanel5 = new JPanel();
        controlPanel5.setLayout(new FlowLayout(3));
        controlPanel3.add(controlPanel4);
        controlPanel3.add(controlPanel5);
        controlPanel.add(controlPanel1);
        controlPanel.add(controlPanel2);
        controlPanel.add(controlPanel3);
        frame.add(controlPanel);
        JLabel headLabel = new JLabel("SEARCH : NAME" , JLabel.CENTER);
        TextField t1 = new TextField();
        JLabel l1 = new JLabel("Enter Member Name : " , JLabel.LEFT);
        JLabel l2 = new JLabel("" , JLabel.LEFT);
        JLabel l3 = new JLabel("" , JLabel.LEFT);
        JButton b1 = new JButton("submit");
        JButton b2 = new JButton("cancel");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                Member m = new Member();
                String s = new String(t1.getText());
                s = s.toUpperCase();
                String txt = setwR("Name",30) + setwR("Code" ,19) + setwR("Number",14) + setwR("Age",7) + "Address\n";
                String S = "SELECT * FROM MEMBERS WHERE mName = '" + s +"'";
                Conn C = new Conn();
                try
                {
                    ResultSet rs = C.s.executeQuery(S);
                    while(rs.next())
                    {
                        m.mName = rs.getString("mName");
                        m.mCode = rs.getString("mCode");
                        m.mNumber = rs.getString("mNumber");
                        m.hno = rs.getString("hno");
                        m.locality = rs.getString("locality");
                        m.city = rs.getString("city");
                        m.state = rs.getString("state");
                        m.age = rs.getInt("age");
                        m.pincode = rs.getInt("pincode");
                        txt += (setwR(m.mName,30) + setwR(m.mCode,19) + setwR(m.mNumber,14) + setwR(Integer.toString(m.age),7) +
                                m.hno + "," + m.locality + "," + m.city + "," + m.state + "," + Integer.toString(m.pincode) + "\n");
                        
                    }
                    JLabel l = new JLabel("MEMBERS BY NAME : " + s , JLabel.CENTER);
                    TextArea text = new TextArea(txt,10,10);
                    showTextArea(text,l);
                }
                catch(Exception E)
                {
                    E.printStackTrace();
                }
            }
	});
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.mSmenu();
            }
	});
        controlPanel1.add(headLabel);
        controlPanel2.add(l1);
        controlPanel2.add(t1);
        controlPanel2.add(l2);
        controlPanel2.add(l3);
        controlPanel4.add(b1);
        controlPanel5.add(b2);
        frame.setVisible(true);
    }
    void bSearchCode ()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(400,200);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }        
        });
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3,1,0,5));
        controlPanel.setPreferredSize(new Dimension(350,150));
        JPanel controlPanel1 = new JPanel();
        controlPanel1.setLayout(new FlowLayout());
        JPanel controlPanel2 = new JPanel();
        controlPanel2.setLayout(new GridLayout(2,2,5,5));
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new GridLayout(1,2));
        JPanel controlPanel4 = new JPanel();
        controlPanel4.setLayout(new FlowLayout(2));
        JPanel controlPanel5 = new JPanel();
        controlPanel5.setLayout(new FlowLayout(3));
        controlPanel3.add(controlPanel4);
        controlPanel3.add(controlPanel5);
        controlPanel.add(controlPanel1);
        controlPanel.add(controlPanel2);
        controlPanel.add(controlPanel3);
        frame.add(controlPanel);
        JLabel headLabel = new JLabel("SEARCH : CODE" , JLabel.CENTER);
        TextField t1 = new TextField();
        JLabel l1 = new JLabel("Enter ISBN-10 : " , JLabel.LEFT);
        JLabel l2 = new JLabel("" , JLabel.LEFT);
        JLabel l3 = new JLabel("" , JLabel.LEFT);
        JButton b1 = new JButton("submit");
        JButton b2 = new JButton("cancel");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                Book b = new Book();
                String s = new String(t1.getText());
                String S = "SELECT * FROM BOOKS WHERE isbn1 = '" + s +"'";
                Conn C = new Conn();
                try
                {
                    ResultSet rs = C.s.executeQuery(S);
                    if(rs.next())
                    {
                        b.bName = rs.getString("bName");
                        b.isbn1 = rs.getString("isbn1");
                        b.isbn2 = rs.getString("isbn2");
                        b.edition = rs.getString("edition");
                        b.publication = rs.getString("publication");
                        b.author = rs.getString("author");
                        b.genere1 = rs.getString("genere1");
                        b.genere2 = rs.getString("genere2");
                        b.genere3 = rs.getString("genere3");
                        b.position = rs.getString("position");
                        b.language = rs.getString("language");
                        b.bCopies = rs.getInt("bCopies");
                        b.year = rs.getInt("year");
                        b.bShowData(b);
                    }
                    else
                        JOptionPane.showMessageDialog(null,"ISNB-10 Not Found!!");
                }
                catch(Exception E)
                {
                    E.printStackTrace();
                }
            }
	});
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.bSmenu();
            }
	});
        controlPanel1.add(headLabel);
        controlPanel2.add(l1);
        controlPanel2.add(t1);
        controlPanel2.add(l2);
        controlPanel2.add(l3);
        controlPanel4.add(b1);
        controlPanel5.add(b2);
        frame.setVisible(true);
    }
    void bSearchName ()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(400,200);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }        
        });
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3,1,0,5));
        controlPanel.setPreferredSize(new Dimension(350,150));
        JPanel controlPanel1 = new JPanel();
        controlPanel1.setLayout(new FlowLayout());
        JPanel controlPanel2 = new JPanel();
        controlPanel2.setLayout(new GridLayout(2,2,5,5));
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new GridLayout(1,2));
        JPanel controlPanel4 = new JPanel();
        controlPanel4.setLayout(new FlowLayout(2));
        JPanel controlPanel5 = new JPanel();
        controlPanel5.setLayout(new FlowLayout(3));
        controlPanel3.add(controlPanel4);
        controlPanel3.add(controlPanel5);
        controlPanel.add(controlPanel1);
        controlPanel.add(controlPanel2);
        controlPanel.add(controlPanel3);
        frame.add(controlPanel);
        JLabel headLabel = new JLabel("SEARCH : NAME" , JLabel.CENTER);
        TextField t1 = new TextField();
        JLabel l1 = new JLabel("Enter Book Name : " , JLabel.LEFT);
        JLabel l2 = new JLabel("" , JLabel.LEFT);
        JLabel l3 = new JLabel("" , JLabel.LEFT);
        JButton b1 = new JButton("submit");
        JButton b2 = new JButton("cancel");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                Book b = new Book();
                String s = new String(t1.getText());
                s = s.toUpperCase();
                String txt = setwR("Name",40) + setwR("ISBN-10",14) + setwR("ISBN-13" , 17) + setwR("Edition",14) + setwR("Publication",40) + setwR("Author",30) + setwR("Shelf No.",14) + setwR("Language",24) + setwR("Copies",10) + "Genere\n";
                String S = "SELECT * FROM BOOKS WHERE bName = '" + s +"'";
                Conn C = new Conn();
                try
                {
                    ResultSet rs = C.s.executeQuery(S);
                    while(rs.next())
                    {
                        b.bName = rs.getString("bName");
                        b.isbn1 = rs.getString("isbn1");
                        b.isbn2 = rs.getString("isbn2");
                        b.edition = rs.getString("edition");
                        b.publication = rs.getString("publication");
                        b.author = rs.getString("author");
                        b.genere1 = rs.getString("genere1");
                        b.genere2 = rs.getString("genere2");
                        b.genere3 = rs.getString("genere3");
                        b.position = rs.getString("position");
                        b.language = rs.getString("language");
                        b.bCopies = rs.getInt("bCopies");
                        b.year = rs.getInt("year");
                        txt += setwR(b.bName,40) + setwR(b.isbn1,14) + setwR(b.isbn2,17) + setwR(b.edition,14) +
                               setwR(b.publication,40) + setwR(b.author,30) + setwR(b.position,14) + setwR(b.language,24) +
                               setwR(Integer.toString(b.bCopies),10) + b.genere1 + "," + b.genere2 + "," + b.genere3 + "\n";
                    }
                    JLabel l = new JLabel("BOOKS BY NAME : " + s , JLabel.CENTER);
                    TextArea text = new TextArea(txt,10,10);
                    showTextArea(text,l);
                }
                catch(Exception E)
                {
                    E.printStackTrace();
                }
            }
	});
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.bSmenu();
            }
	});
        controlPanel1.add(headLabel);
        controlPanel2.add(l1);
        controlPanel2.add(t1);
        controlPanel2.add(l2);
        controlPanel2.add(l3);
        controlPanel4.add(b1);
        controlPanel5.add(b2);
        frame.setVisible(true);
    }
    void bSearchGenere ()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(400,200);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }        
        });
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3,1,0,5));
        controlPanel.setPreferredSize(new Dimension(350,150));
        JPanel controlPanel1 = new JPanel();
        controlPanel1.setLayout(new FlowLayout());
        JPanel controlPanel2 = new JPanel();
        controlPanel2.setLayout(new GridLayout(2,2,5,5));
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new GridLayout(1,2));
        JPanel controlPanel4 = new JPanel();
        controlPanel4.setLayout(new FlowLayout(2));
        JPanel controlPanel5 = new JPanel();
        controlPanel5.setLayout(new FlowLayout(3));
        controlPanel3.add(controlPanel4);
        controlPanel3.add(controlPanel5);
        controlPanel.add(controlPanel1);
        controlPanel.add(controlPanel2);
        controlPanel.add(controlPanel3);
        frame.add(controlPanel);
        JLabel headLabel = new JLabel("SEARCH : GENERE" , JLabel.CENTER);
        TextField t1 = new TextField();
        JLabel l1 = new JLabel("Enter Genere : " , JLabel.LEFT);
        JLabel l2 = new JLabel("" , JLabel.LEFT);
        JLabel l3 = new JLabel("" , JLabel.LEFT);
        JButton b1 = new JButton("submit");
        JButton b2 = new JButton("cancel");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                Book b = new Book();
                String s = new String(t1.getText());
                s = s.toUpperCase();
                String empty = "";
                String txt = setwR("Name",40) + setwR("ISBN-10",14) + setwR("ISBN-13" , 17) + setwR("Edition",14) + setwR("Publication",40) + setwR("Author",30) + setwR("Shelf No.",14) + setwR("Language",24) + setwR("Copies",10) + "Genere\n";
                String S = "SELECT * FROM BOOKS WHERE genere1 = '" + s + "'OR genere2 = '" + s + "'OR genere3 = '" + s + "'AND'" + s +"'<>'" + empty + "'";
                Conn C = new Conn();
                try
                {
                    ResultSet rs = C.s.executeQuery(S);
                    while(rs.next())
                    {
                        b.bName = rs.getString("bName");
                        b.isbn1 = rs.getString("isbn1");
                        b.isbn2 = rs.getString("isbn2");
                        b.edition = rs.getString("edition");
                        b.publication = rs.getString("publication");
                        b.author = rs.getString("author");
                        b.genere1 = rs.getString("genere1");
                        b.genere2 = rs.getString("genere2");
                        b.genere3 = rs.getString("genere3");
                        b.position = rs.getString("position");
                        b.language = rs.getString("language");
                        b.bCopies = rs.getInt("bCopies");
                        b.year = rs.getInt("year");
                        txt += setwR(b.bName,40) + setwR(b.isbn1,14) + setwR(b.isbn2,17) + setwR(b.edition,14) +
                               setwR(b.publication,40) + setwR(b.author,30) + setwR(b.position,14) + setwR(b.language,24) +
                               setwR(Integer.toString(b.bCopies),10) + b.genere1 + "," + b.genere2 + "," + b.genere3 + "\n";
                    }
                    JLabel l = new JLabel("BOOKS BY NAME : " + s , JLabel.CENTER);
                    TextArea text = new TextArea(txt,10,10);
                    showTextArea(text,l);
                }
                catch(Exception E)
                {
                    E.printStackTrace();
                }
            }
	});
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.bSmenu();
            }
	});
        controlPanel1.add(headLabel);
        controlPanel2.add(l1);
        controlPanel2.add(t1);
        controlPanel2.add(l2);
        controlPanel2.add(l3);
        controlPanel4.add(b1);
        controlPanel5.add(b2);
        frame.setVisible(true);
    }
    void mDelete ()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(400,200);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }        
        });
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3,1,0,5));
        controlPanel.setPreferredSize(new Dimension(350,150));
        JPanel controlPanel1 = new JPanel();
        controlPanel1.setLayout(new FlowLayout());
        JPanel controlPanel2 = new JPanel();
        controlPanel2.setLayout(new GridLayout(2,2,5,5));
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new GridLayout(1,2));
        JPanel controlPanel4 = new JPanel();
        controlPanel4.setLayout(new FlowLayout(2));
        JPanel controlPanel5 = new JPanel();
        controlPanel5.setLayout(new FlowLayout(3));
        controlPanel3.add(controlPanel4);
        controlPanel3.add(controlPanel5);
        controlPanel.add(controlPanel1);
        controlPanel.add(controlPanel2);
        controlPanel.add(controlPanel3);
        frame.add(controlPanel);
        JLabel headLabel = new JLabel("DELETE MEMBER RECORD" , JLabel.CENTER);
        TextField t1 = new TextField();
        JLabel l1 = new JLabel("Enter Member Code : " , JLabel.LEFT);
        JLabel l2 = new JLabel("" , JLabel.LEFT);
        JLabel l3 = new JLabel("" , JLabel.LEFT);
        JButton b1 = new JButton("submit");
        JButton b2 = new JButton("cancel");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                Conn C = new Conn();
                String s = new String(t1.getText());
                String S1 = "SELECT * FROM MEMBERS WHERE mCode = '" + s +"'";
                try
                {
                    ResultSet rs = C.s.executeQuery(S1);
                    if(rs.next())
                        JOptionPane.showMessageDialog(null,"Member With Code : " + s +" Is Deleted !!");
                    else
                        JOptionPane.showMessageDialog(null,"Member With Code : " + s +" Not Found!!");
                }
                catch(Exception E)
                {
                    E.printStackTrace();
                }
                String S2 = "DELETE FROM MEMBERS WHERE mCode = '" + s +"'";
                try
                {
                    C.s.executeUpdate(S2);
                }
                catch(Exception E)
                {
                    E.printStackTrace();
                }
            }
	});
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.menu3();
            }
	});
        controlPanel1.add(headLabel);
        controlPanel2.add(l1);
        controlPanel2.add(t1);
        controlPanel2.add(l2);
        controlPanel2.add(l3);
        controlPanel4.add(b1);
        controlPanel5.add(b2);
        frame.setVisible(true);
    }
    void bDelete ()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(400,200);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }        
        });
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3,1,0,5));
        controlPanel.setPreferredSize(new Dimension(350,150));
        JPanel controlPanel1 = new JPanel();
        controlPanel1.setLayout(new FlowLayout());
        JPanel controlPanel2 = new JPanel();
        controlPanel2.setLayout(new GridLayout(2,2,5,5));
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new GridLayout(1,2));
        JPanel controlPanel4 = new JPanel();
        controlPanel4.setLayout(new FlowLayout(2));
        JPanel controlPanel5 = new JPanel();
        controlPanel5.setLayout(new FlowLayout(3));
        controlPanel3.add(controlPanel4);
        controlPanel3.add(controlPanel5);
        controlPanel.add(controlPanel1);
        controlPanel.add(controlPanel2);
        controlPanel.add(controlPanel3);
        frame.add(controlPanel);
        JLabel headLabel = new JLabel("DELETE BOOK RECORD" , JLabel.CENTER);
        TextField t1 = new TextField();
        JLabel l1 = new JLabel("Enter ISBN-10 : " , JLabel.LEFT);
        JLabel l2 = new JLabel("" , JLabel.LEFT);
        JLabel l3 = new JLabel("" , JLabel.LEFT);
        JButton b1 = new JButton("submit");
        JButton b2 = new JButton("cancel");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                Conn C = new Conn();
                String s = new String(t1.getText());
                String S1 = "SELECT * FROM BOOKS WHERE isbn1 = '" + s +"'";
                try
                {
                    ResultSet rs = C.s.executeQuery(S1);
                    if(rs.next())
                        JOptionPane.showMessageDialog(null,"Book With ISBN-10 Code : " + s +" Is Deleted !!");
                    else
                        JOptionPane.showMessageDialog(null,"Book With ISBN-10 Code : " + s +" Not Found!!");
                }
                catch(Exception E)
                {
                }
                String S2 = "DELETE FROM BOOKS WHERE isbn1 = '" + s +"'";
                try
                {
                    C.s.executeUpdate(S2);
                }
                catch(Exception E)
                {
                    E.printStackTrace();
                }
            }
	});
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.menu4();
            }
	});
        controlPanel1.add(headLabel);
        controlPanel2.add(l1);
        controlPanel2.add(t1);
        controlPanel2.add(l2);
        controlPanel2.add(l3);
        controlPanel4.add(b1);
        controlPanel5.add(b2);
        frame.setVisible(true);
    }
    void mModify1 ()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(400,200);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }        
        });
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3,1,0,5));
        controlPanel.setPreferredSize(new Dimension(350,150));
        JPanel controlPanel1 = new JPanel();
        controlPanel1.setLayout(new FlowLayout());
        JPanel controlPanel2 = new JPanel();
        controlPanel2.setLayout(new GridLayout(2,2,5,5));
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new GridLayout(1,2));
        JPanel controlPanel4 = new JPanel();
        controlPanel4.setLayout(new FlowLayout(2));
        JPanel controlPanel5 = new JPanel();
        controlPanel5.setLayout(new FlowLayout(3));
        controlPanel3.add(controlPanel4);
        controlPanel3.add(controlPanel5);
        controlPanel.add(controlPanel1);
        controlPanel.add(controlPanel2);
        controlPanel.add(controlPanel3);
        frame.add(controlPanel);
        JLabel headLabel = new JLabel("MEMBERS : EDIT" , JLabel.CENTER);
        TextField t1 = new TextField();
        JLabel l1 = new JLabel("Enter Member Code : " , JLabel.LEFT);
        JLabel l2 = new JLabel("" , JLabel.LEFT);
        JLabel l3 = new JLabel("" , JLabel.LEFT);
        JButton b1 = new JButton("submit");
        JButton b2 = new JButton("cancel");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String s = new String(t1.getText());
                String S = "SELECT * FROM MEMBERS WHERE mCode = '" + s +"'";
                Conn C = new Conn();
                try
                {
                    ResultSet rs = C.s.executeQuery(S);
                    if(rs.next())
                    {
                        frame.dispose();
                        Method m = new Method();
                        m.mModify2(s);
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Code Not Found!!");
                }
                catch(Exception E)
                {
                    E.printStackTrace();
                }
            }
	});
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.menu3();
            }
	});
        controlPanel1.add(headLabel);
        controlPanel2.add(l1);
        controlPanel2.add(t1);
        controlPanel2.add(l2);
        controlPanel2.add(l3);
        controlPanel4.add(b1);
        controlPanel5.add(b2);
        frame.setVisible(true);
    }
    void mModify2 (String s)
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
        JButton backButton = new JButton(" back ");
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
                String S1 = "SELECT * FROM MEMBERS WHERE mCode = '" + s2 + "'AND'" + s2 + "'<>'" + s +"'";
                try
                {
                    ResultSet rs = C.s.executeQuery(S1);
                    if(rs.next())
                        JOptionPane.showMessageDialog(null,"Member Code : " + s1 +" Is Already Used !!");
                    else
                    {
                        if((!T1.getText().trim().isEmpty()) && (!T2.getText().trim().isEmpty()) && (!T3.getText().trim().isEmpty())
                            && (!T5.getText().trim().isEmpty()) && !T6.getText().trim().isEmpty() && (!T7.getText().trim().isEmpty()) 
                            && (!T8.getText().trim().isEmpty()) && (i1 != 0) && i2 != 0)
                        {  
                            String S = "UPDATE MEMBERS SET mName ='" + s1 + "',mCode ='" + s2 + "',mNumber ='" + s3 +"',hno ='" + 
                                        s4 + "',locality ='" + s5 + "',city ='" + s6 + "',state ='" + s7 + "',age ="+ i1 + ",pincode =" + i2 + "\n" +
                                        "WHERE mCode ='" + s + "'";
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
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Method m = new Method();
                m.mModify1();
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
        controlPanel9.add(backButton);
	frame.setVisible(true);
    }
    void bModify1 ()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(400,200);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }        
        });
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3,1,0,5));
        controlPanel.setPreferredSize(new Dimension(350,150));
        JPanel controlPanel1 = new JPanel();
        controlPanel1.setLayout(new FlowLayout());
        JPanel controlPanel2 = new JPanel();
        controlPanel2.setLayout(new GridLayout(2,2,5,5));
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new GridLayout(1,2));
        JPanel controlPanel4 = new JPanel();
        controlPanel4.setLayout(new FlowLayout(2));
        JPanel controlPanel5 = new JPanel();
        controlPanel5.setLayout(new FlowLayout(3));
        controlPanel3.add(controlPanel4);
        controlPanel3.add(controlPanel5);
        controlPanel.add(controlPanel1);
        controlPanel.add(controlPanel2);
        controlPanel.add(controlPanel3);
        frame.add(controlPanel);
        JLabel headLabel = new JLabel("SEARCH : CODE" , JLabel.CENTER);
        TextField t1 = new TextField();
        JLabel l1 = new JLabel("Enter ISBN-10 : " , JLabel.LEFT);
        JLabel l2 = new JLabel("" , JLabel.LEFT);
        JLabel l3 = new JLabel("" , JLabel.LEFT);
        JButton b1 = new JButton("submit");
        JButton b2 = new JButton("cancel");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String s = new String(t1.getText());
                String S = "SELECT * FROM BOOKS WHERE isbn1 = '" + s +"'";
                Conn C = new Conn();
                try
                {
                    ResultSet rs = C.s.executeQuery(S);
                    if(rs.next())
                    {
                        String q = rs.getString("isbn2");
                        frame.dispose();
                        Method m = new Method();
                        m.bModify2(s,q);
                    }
                    else
                        JOptionPane.showMessageDialog(null,"ISNB-10 Not Found!!");
                }
                catch(Exception E)
                {
                    E.printStackTrace();
                }
            }
	});
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.menu4();
            }
	});
        controlPanel1.add(headLabel);
        controlPanel2.add(l1);
        controlPanel2.add(t1);
        controlPanel2.add(l2);
        controlPanel2.add(l3);
        controlPanel4.add(b1);
        controlPanel5.add(b2);
        frame.setVisible(true);
    }
    void bModify2 (String s , String q)
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
        JButton backButton = new JButton(" Back ");
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
                    String S1 = "SELECT * FROM BOOKS WHERE isbn1 = '" + s2 +"' OR isbn2 = '" + s3 + "'AND'" + s2 + "'<>'" + s +"'AND'" + s3 + "'<>'" + q + "'";
                    ResultSet rs = C.s.executeQuery(S1);
                    if(rs.next())
                        JOptionPane.showMessageDialog(null,"Invalid ISBN-10 OR ISBN-13 Code");
                    else
                    {
                        if((!T1.getText().trim().isEmpty()) && (!T2.getText().trim().isEmpty()) && (!T3.getText().trim().isEmpty()))
                        {  
                            String S = "UPDATE BOOKS SET bName ='" + s1 + "',isbn1 ='" + s2 + "',isbn2 ='" + s3 + "',edition ='" + s4 + "',publication ='" +
                                        s5 + "',author ='" + s6 + "',position ='" + s7 + "',language ='" + s8 + "',genere1 ='" + s9 + "',genere2 ='" +
                                        s10 + "',genere3 ='" + s11 + "',bCopies =" + i1 + ",year =" + i2 + "\n" +
                                        "WHERE isbn1 ='" + s + "'";
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
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Method m = new Method();
                m.bModify1();
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
        controlPanel11.add(backButton);
	frame.setVisible(true);
    }
    void issue ()
    {
        JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setSize(420,250);
	frame.setLayout(new FlowLayout());
	frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
		System.exit(0);
            }        
	});
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3,1));
        controlPanel.setPreferredSize(new Dimension(400,200));
        JPanel controlPanel1 = new JPanel();
        controlPanel1.setLayout(new FlowLayout());
        JPanel controlPanel2 = new JPanel();
        controlPanel2.setLayout(new GridLayout(2,2,10,10));
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new GridLayout(1,2));
        JPanel controlPanel4 = new JPanel();
        controlPanel4.setLayout(new FlowLayout(2));
        JPanel controlPanel5 = new JPanel();
        controlPanel5.setLayout(new FlowLayout(3));
        controlPanel3.add(controlPanel4);
        controlPanel3.add(controlPanel5);
        controlPanel.add(controlPanel1);
        controlPanel.add(controlPanel2);
        controlPanel.add(controlPanel3);
        frame.add(controlPanel);
        JLabel headLabel = new JLabel("ISSUING",JLabel.CENTER);
        JLabel l1 = new JLabel("Enter Member Code : ");
        JLabel l2 = new JLabel("Enter ISBN-10 : ");
        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JButton b1 = new JButton(" Done ");
        JButton b2 = new JButton("Cancel");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(!t1.getText().trim().isEmpty() && !t2.getText().trim().isEmpty())
                {
                    try
                    {
                        Conn C = new Conn();
                        String s1 = new String(t1.getText());
                        String s2 = new String(t2.getText());
                        String S1 = "SELECT * FROM BOOKS A , MEMBERS B WHERE A.isbn1 = '" + s2 +"' AND B.mCode = '" + s1 + "'";
                        ResultSet rs = C.s.executeQuery(S1);
                        if(rs.next())
                        {
                            int copies = rs.getInt("bCopies");
                            int count = rs.getInt("counter");
                            if(count == 1)
                                JOptionPane.showMessageDialog(null,"Book Not Returned By Member!!");
                            if(copies != 0 && count != 1)
                            {
                                try
                                {
                                    String S2 = "UPDATE MEMBERS SET iBcode = '" + s2 + "',counter = 1 WHERE mCode ='" + s1 + "'";
                                    String S3 = "UPDATE BOOKS SET bCopies = bCopies - 1 WHERE isbn1 ='" + s2 + "'";
                                    C.s.executeUpdate(S2);
                                    C.s.executeUpdate(S3);
                                    frame.dispose();
                                    Menu m = new Menu();
                                    m.returnIssue();
                                    JOptionPane.showMessageDialog(null,"Issue Successful!!");
                                }
                                catch(Exception E)
                                {
                                    E.printStackTrace();
                                }
                            }
                            else
                                JOptionPane.showMessageDialog(null,"Book Not Available!!");
                        }
                        else
                            JOptionPane.showMessageDialog(null,"Codes Not Found!!");
                    }
                    catch(Exception E)
                    {
                        E.printStackTrace();
                    }
                }
                else
                    JOptionPane.showMessageDialog(null,"Incomplete Information!!");
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.returnIssue();
            }
	});
        controlPanel1.add(headLabel);
        controlPanel2.add(l1);
        controlPanel2.add(t1);
        controlPanel2.add(l2);
        controlPanel2.add(t2);
        controlPanel4.add(b1);
        controlPanel5.add(b2);
        frame.setVisible(true);
    }
    void return1 ()
    {
        JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setSize(420,250);
	frame.setLayout(new FlowLayout());
	frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
		System.exit(0);
            }        
	});
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3,1));
        controlPanel.setPreferredSize(new Dimension(400,200));
        JPanel controlPanel1 = new JPanel();
        controlPanel1.setLayout(new FlowLayout());
        JPanel controlPanel2 = new JPanel();
        controlPanel2.setLayout(new GridLayout(2,2,10,10));
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new GridLayout(1,2));
        JPanel controlPanel4 = new JPanel();
        controlPanel4.setLayout(new FlowLayout(2));
        JPanel controlPanel5 = new JPanel();
        controlPanel5.setLayout(new FlowLayout(3));
        controlPanel3.add(controlPanel4);
        controlPanel3.add(controlPanel5);
        controlPanel.add(controlPanel1);
        controlPanel.add(controlPanel2);
        controlPanel.add(controlPanel3);
        frame.add(controlPanel);
        JLabel headLabel = new JLabel("RETURNING",JLabel.CENTER);
        JLabel l1 = new JLabel("Enter Member Code : ");
        JLabel l2 = new JLabel("Enter ISBN-10 Code : ");
        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JButton b1 = new JButton(" Done ");
        JButton b2 = new JButton("Cancel");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(!t1.getText().trim().isEmpty() && !t2.getText().trim().isEmpty())
                {
                    try
                    {
                        Conn C = new Conn();
                        String s1 = new String(t1.getText());
                        String s2 = new String(t2.getText());
                        String S1 = "SELECT * FROM BOOKS A , MEMBERS B WHERE A.isbn1 = '" + s2 +"' AND B.mCode = '" + s1 + "'";
                        ResultSet rs = C.s.executeQuery(S1);
                        if(rs.next())
                        {
                            int count = rs.getInt("counter");
                            if(count == 0)
                                JOptionPane.showMessageDialog(null,"No Book Issued By Member!!");
                            else
                            {
                                try
                                {
                                    String S2 = "UPDATE MEMBERS SET iBcode = NULL , counter = 0 WHERE mCode ='" + s1 + "'";
                                    String S3 = "UPDATE BOOKS SET bCopies = bCopies + 1 WHERE isbn1 = '" + s2 + "'";
                                    C.s.executeUpdate(S2);
                                    C.s.executeUpdate(S3);
                                    frame.dispose();
                                    Menu m = new Menu();
                                    m.returnIssue();
                                    JOptionPane.showMessageDialog(null,"Return Successful!!");
                                }
                                catch(Exception E)
                                {
                                    E.printStackTrace();
                                }
                            }
                        }
                        else
                            JOptionPane.showMessageDialog(null,"Codes Not Found!!");
                    }
                    catch(Exception E)
                    {
                        E.printStackTrace();
                    }
                }
                else
                    JOptionPane.showMessageDialog(null,"Incomplete Information!!");
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.returnIssue();
            }
	});
        controlPanel1.add(headLabel);
        controlPanel2.add(l1);
        controlPanel2.add(t1);
        controlPanel2.add(l2);
        controlPanel2.add(t2);
        controlPanel4.add(b1);
        controlPanel5.add(b2);
        frame.setVisible(true);
    }
    void issueDetails ()
    {
        Member m = new Member();
        Book b = new Book();
        String txt = setwR("Name",30) + setwR("Code" ,19) + setwR("Number",14) + setwR("Age",7) + setwR("Issued Book",40) + "Address\n";
        String S = "SELECT A.mName,A.mCode,A.mNumber,A.age,A.hno,A.locality,A.city,A.state,A.pincode,B.bName FROM MEMBERS A , BOOKS B WHERE A.iBcode=B.isbn1";
        Conn C = new Conn();
        try
        {
            ResultSet rs = C.s.executeQuery(S);
            while(rs.next())
            {
                m.mName = rs.getString("mName");
                m.mCode = rs.getString("mCode");
                m.mNumber = rs.getString("mNumber");
                m.hno = rs.getString("hno");
                m.locality = rs.getString("locality");
                m.city = rs.getString("city");
                m.state = rs.getString("state");
                m.age = rs.getInt("age");
                m.pincode = rs.getInt("pincode");
                b.bName = rs.getString("bName");
                txt += (setwR(m.mName,30) + setwR(m.mCode,19) + setwR(m.mNumber,14) + setwR(Integer.toString(m.age),7) + (setwR(b.bName,40)) +
                       m.hno + "," + m.locality + "," + m.city + "," + m.state + "," + Integer.toString(m.pincode) + "\n");                        
            }
            JLabel l = new JLabel("ISSUING DETAILS" , JLabel.CENTER);
            TextArea text = new TextArea(txt,10,10);
            showTextArea(text,l);
        }
        catch(Exception E)
        {
            E.printStackTrace();
        }
    }
    void bookInfoGenere ()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(400,200);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }        
        });
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3,1,0,5));
        controlPanel.setPreferredSize(new Dimension(350,150));
        JPanel controlPanel1 = new JPanel();
        controlPanel1.setLayout(new FlowLayout());
        JPanel controlPanel2 = new JPanel();
        controlPanel2.setLayout(new GridLayout(2,2,5,5));
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new GridLayout(1,2));
        JPanel controlPanel4 = new JPanel();
        controlPanel4.setLayout(new FlowLayout(2));
        JPanel controlPanel5 = new JPanel();
        controlPanel5.setLayout(new FlowLayout(3));
        controlPanel3.add(controlPanel4);
        controlPanel3.add(controlPanel5);
        controlPanel.add(controlPanel1);
        controlPanel.add(controlPanel2);
        controlPanel.add(controlPanel3);
        frame.add(controlPanel);
        JLabel headLabel = new JLabel("SEARCH : GENERE" , JLabel.CENTER);
        TextField t1 = new TextField();
        JLabel l1 = new JLabel("Enter Genere : " , JLabel.LEFT);
        JLabel l2 = new JLabel("" , JLabel.LEFT);
        JLabel l3 = new JLabel("" , JLabel.LEFT);
        JButton b1 = new JButton("submit");
        JButton b2 = new JButton("cancel");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                Book b = new Book();
                String s = new String(t1.getText());
                s = s.toUpperCase();
                String empty = "";
                String txt = setwR("Name",40)  + setwR("Edition",14) + setwR("Publication",40) + setwR("Author",30) + setwR("Shelf No.",14) + setwR("Language",24) + "Genere\n";
                String S = "SELECT * FROM BOOKS WHERE genere1 = '" + s + "'OR genere2 = '" + s + "'OR genere3 = '" + s + "'AND'" + s +"'<>'" + empty + "'";
                Conn C = new Conn();
                try
                {
                    ResultSet rs = C.s.executeQuery(S);
                    while(rs.next())
                    {
                        b.bName = rs.getString("bName");
                        b.edition = rs.getString("edition");
                        b.publication = rs.getString("publication");
                        b.author = rs.getString("author");
                        b.genere1 = rs.getString("genere1");
                        b.genere2 = rs.getString("genere2");
                        b.genere3 = rs.getString("genere3");
                        b.position = rs.getString("position");
                        b.language = rs.getString("language");
                        b.year = rs.getInt("year");
                        txt += setwR(b.bName,40) + setwR(b.edition,14) + setwR(b.publication,40) + setwR(b.author,30) + 
                               setwR(b.position,14) + setwR(b.language,24) + b.genere1 + "," + b.genere2 + "," + b.genere3 + "\n";
                    }
                    JLabel l = new JLabel("BOOKS INFO" , JLabel.CENTER);
                    TextArea text = new TextArea(txt,10,10);
                    showTextArea(text,l);
                }
                catch(Exception E)
                {
                    E.printStackTrace();
                }
            }
	});
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.memberSearch();
            }
	});
        controlPanel1.add(headLabel);
        controlPanel2.add(l1);
        controlPanel2.add(t1);
        controlPanel2.add(l2);
        controlPanel2.add(l3);
        controlPanel4.add(b1);
        controlPanel5.add(b2);
        frame.setVisible(true);
    }
    void bookInfoName ()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(400,200);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }        
        });
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3,1,0,5));
        controlPanel.setPreferredSize(new Dimension(350,150));
        JPanel controlPanel1 = new JPanel();
        controlPanel1.setLayout(new FlowLayout());
        JPanel controlPanel2 = new JPanel();
        controlPanel2.setLayout(new GridLayout(2,2,5,5));
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new GridLayout(1,2));
        JPanel controlPanel4 = new JPanel();
        controlPanel4.setLayout(new FlowLayout(2));
        JPanel controlPanel5 = new JPanel();
        controlPanel5.setLayout(new FlowLayout(3));
        controlPanel3.add(controlPanel4);
        controlPanel3.add(controlPanel5);
        controlPanel.add(controlPanel1);
        controlPanel.add(controlPanel2);
        controlPanel.add(controlPanel3);
        frame.add(controlPanel);
        JLabel headLabel = new JLabel("SEARCH : NAME" , JLabel.CENTER);
        TextField t1 = new TextField();
        JLabel l1 = new JLabel("Enter Name : " , JLabel.LEFT);
        JLabel l2 = new JLabel("" , JLabel.LEFT);
        JLabel l3 = new JLabel("" , JLabel.LEFT);
        JButton b1 = new JButton("submit");
        JButton b2 = new JButton("cancel");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                Book b = new Book();
                String s = new String(t1.getText());
                s = s.toUpperCase();
                String empty = "";
                String txt = setwR("Name",40)  + setwR("Edition",14) + setwR("Publication",40) + setwR("Author",30) + setwR("Shelf No.",14) + setwR("Language",24) + "Genere\n";
                String S = "SELECT * FROM BOOKS WHERE bName = '" + s +"'";
                Conn C = new Conn();
                try
                {
                    ResultSet rs = C.s.executeQuery(S);
                    while(rs.next())
                    {
                        b.bName = rs.getString("bName");
                        b.edition = rs.getString("edition");
                        b.publication = rs.getString("publication");
                        b.author = rs.getString("author");
                        b.genere1 = rs.getString("genere1");
                        b.genere2 = rs.getString("genere2");
                        b.genere3 = rs.getString("genere3");
                        b.position = rs.getString("position");
                        b.language = rs.getString("language");
                        b.year = rs.getInt("year");
                        txt += setwR(b.bName,40) + setwR(b.edition,14) + setwR(b.publication,40) + setwR(b.author,30) + 
                               setwR(b.position,14) + setwR(b.language,24) + b.genere1 + "," + b.genere2 + "," + b.genere3 + "\n";
                    }
                    JLabel l = new JLabel("BOOKS INFO" , JLabel.CENTER);
                    TextArea text = new TextArea(txt,10,10);
                    showTextArea(text,l);
                }
                catch(Exception E)
                {
                    E.printStackTrace();
                }
            }
	});
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.memberSearch();
            }
	});
        controlPanel1.add(headLabel);
        controlPanel2.add(l1);
        controlPanel2.add(t1);
        controlPanel2.add(l2);
        controlPanel2.add(l3);
        controlPanel4.add(b1);
        controlPanel5.add(b2);
        frame.setVisible(true);
    }
    void help ()
    {
        String txt = "Member Menu\n-----------\n" +
                     "1. Press \'Create New Rec.\' button for entering the details of a new Member.\n" +
                     "2. Press \'Delete Rec.\' button for deleting the details of a Member based on their Member Code.\n" +
                     "3. Press \'Search Rec.\' button for searching the details of a Member based on either their Member Code or Name.\n" +
                     "4. Press \'Edit Rec.\' button for editing the details of the Member based on their Member Code.\n" +
                     "\nBook Menu\n---------\n" +
                     "1. Press \'Create New Rec.\' button for entering the details of a new Book.\n" +
                     "2. Press \'Delete Rec.\' button for deleting the details of a book based on its ISBN-10 number.\n" +
                     "3. Press \'Search Rec.\' button for searching the details of a book based on either its Book Code(ISBN-10 number), Name or Genere.\n" +
                     "4. Press \'Edit Rec.\' button for editing the details of the book based on its ISBN-10 number.\n" +
                     "5. Press \'Issue/Return\' button for:\n" +
                     "   (i)   Issuing a book based on the Member Code AND ISBN-10 number of the book.\n" +
                     "   (ii)  Returning the book based on the Member Code AND ISBN-10 number of the book.\n" +
                     "   (iii) Issuing details of all the books.";
        JLabel l = new JLabel("HELP" , JLabel.CENTER);
        TextArea text = new TextArea(txt,10,10);
        showTextArea(text,l);
    }
    void instructions ()
    {
        String txt = "For becoming a member, please follow the following instructions:\n" +
                     "1. Fill up the Library membership form which is available at Issue/Return desk.\n" +
                     "2. Fees is Rs. 2000/month.\n" +
                     "3. Security of Rs. 500 is to be deposited with the membership form.\n" +
                     "4. Remember to collect your membership card after 1 week from the Issue/Return desk.\n" +
                     "5. The cash receipt of Rs. 500 will be given so that you can access the library facilities for the first 7 days.\n" +
                     "6. Without the membership card, no book will be issued.";
        JLabel l = new JLabel("INSTRUCTIONS" , JLabel.CENTER);
        TextArea text = new TextArea(txt,10,10);
        showTextArea(text,l);
    }
    void rules ()
    {
        String txt = "1.  The rule of silence must be respected and antisocial behaviour will not be tolerated. Offenders will be required to leave, and repeat offenders will be banned indefinitely from using the Library.\n" +
                     "2.  No discussion permitted inside the library.\n" +
                     "3.  No personal belongings allowed inside the library.\n" +
                     "4.  Textbooks are not allowed to be taken inside the library.\n" +
                     "5.  Using Mobile phones and audio instruments with or without speaker or headphone is strictly prohibited in the library premises.\n" +
                     "6.  Show the books and other materials which are being taken out of the library to the staff at the entrance counter.\n" +
                     "7.  The librarian may recall any book from any member at any time and the member shall return the same immediately.\n" +
                     "8.  It is forbidden to bring food into the Library.\n" +
                     "9.  All books and periodicals must be returned to their respected shelves after use.\n" +
                     "10. Books can be issued for only a period of 10 days. Fine of 5 Rupees per day will be taken if the book is not returned or re-issued after the due date.\n" +
                     "11. Members are instructed to check the books while borrowing and they will be responsible for any type of damage or mutilation noticed at the time of return.\n" +
                     "12. If the books are lost, then the borrower shall replace the books of the same edition or latest edition or pay double cost of the book after getting permission from the librarian.";
        JLabel l = new JLabel("RULES" , JLabel.CENTER);
        TextArea text = new TextArea(txt,10,10);
        showTextArea(text,l);
    }
}