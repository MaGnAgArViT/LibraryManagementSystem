package library;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class Password implements Serializable{
    public String pw;
    public Password ()
    {
	pw = "";
    }
    public Password(String s)
    {
       	this.pw = s;
    }
    public void setPassword ()
    {
	FileHandling f = new FileHandling();
	JFrame frame = new JFrame();
	frame.setSize(420,210);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setLayout(new FlowLayout());
	frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
		System.exit(0);
            }        
	});
	JPanel controlPanel = new JPanel();
	controlPanel.setLayout(new GridLayout(3,1));
	controlPanel.setPreferredSize(new Dimension(400,180));
	JLabel statusLabel = new JLabel("",JLabel.CENTER);
	JPanel controlPanel1 = new JPanel();
	controlPanel1.setLayout(new GridLayout(2,2,10,10));
	JPanel controlPanel2 = new JPanel();
	controlPanel1.setBackground(Color.ORANGE);
	controlPanel2.setLayout(new GridLayout(1,2));
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new FlowLayout(2));
        JPanel controlPanel4 = new JPanel();
        controlPanel4.setLayout(new FlowLayout(3));
        controlPanel2.add(controlPanel3);
	controlPanel2.add(controlPanel4);
        controlPanel.add(controlPanel1);
	controlPanel.add(controlPanel2);
	controlPanel.add(statusLabel);
	frame.add(controlPanel);
	JLabel pw1L= new JLabel(" New Password : ", JLabel.LEFT);
	JLabel pw2L = new JLabel(" Confirm Password : ", JLabel.LEFT);
	final JPasswordField pw1T = new JPasswordField(6);
	final JPasswordField pw2T = new JPasswordField(6);
	JButton doneButton = new JButton(" Done ");
        JButton cancelButton = new JButton("Cancel");
	doneButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String p1 = new String(pw1T.getPassword());
                String p2 = new String(pw2T.getPassword());
		if(p1.equals(p2))
		{
                    Conn C = new Conn();
                    String s1 = "DROP TABLE MEMBERS";
                    String s2 = "DROP TABLE BOOKS";
                    String s3 = "CREATE TABLE MEMBERS " +
                                "(mName VARCHAR (26), " +
                                " mCode VARCHAR(15) not NULL, " +
                                " mNumber VARCHAR(10), " +
                                " iBcode VARCHAR(10), " +
                                " hno VARCHAR(10), " +
                                " locality VARCHAR(50), " +
                                " city VARCHAR(50), " +
                                " state VARCHAR(50), " +
                                " age INTEGER, " +
                                " counter INTEGER, " +
                                " pincode INTEGER, " + 
                                "PRIMARY KEY(mCode))";
                    String s4 = "CREATE TABLE BOOKS " +
                                "(bName VARCHAR (36), " +
                                " isbn1 VARCHAR(10) not NULL, " +
                                " isbn2 VARCHAR(13), " +
                                " bCopies INTEGER, " +
                                " edition VARCHAR(10), " +
                                " publication VARCHAR(36), " +
                                " author VARCHAR(26), " +
                                " genere1 VARCHAR(25), " +
                                " genere2 VARCHAR(25), " +
                                " genere3 VARCHAR(25), " +
                                " position VARCHAR(10), " +
                                " language VARCHAR(20), " +
                                " year INTEGER, " + 
                                "PRIMARY KEY(isbn1))";
                    try
                    {
                        C.s.executeUpdate(s1);
                    }
                    catch(Exception E)
                    {
                    }
                    try
                    {
                        C.s.executeUpdate(s2);
                    }
                    catch(Exception E)
                    {
                    }
                    try
                    {
                        C.s.executeUpdate(s3);
                    }
                    catch(Exception E)
                    {
                    }
                    try
                    {
                        C.s.executeUpdate(s4);
                    }
                    catch(Exception E)
                    {
                    }
                    Password p = new Password(p1);
                    f.pWrite(p);
                    frame.dispose();
                    Menu m = new Menu();
                    m.menu1();
		}
                else
                    statusLabel.setText("Re-enter conformation password!!");
            }
	});
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.menu1();
            }
	});
	controlPanel1.add(pw1L);
	controlPanel1.add(pw1T);
	controlPanel1.add(pw2L);
	controlPanel1.add(pw2T);
	controlPanel3.add(doneButton);
        controlPanel4.add(cancelButton);
	frame.setVisible(true);
    }
    public void test ()
    {
	FileHandling f = new FileHandling();
	pw = f.pRead();
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setSize(420,150);
	frame.setLayout(new FlowLayout());
	frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
		System.exit(0);
            }        
	});
        JPanel controlPanel = new JPanel();
	controlPanel.setLayout(new GridLayout(2,1));
	controlPanel.setPreferredSize(new Dimension(400,100));
	JPanel controlPanel1 = new JPanel();
	controlPanel1.setLayout(new GridLayout(2,2,10,10));
	JPanel controlPanel2 = new JPanel();
	controlPanel1.setBackground(Color.ORANGE);
	controlPanel2.setLayout(new GridLayout(1,2));
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new FlowLayout(2));
        JPanel controlPanel4 = new JPanel();
        controlPanel4.setLayout(new FlowLayout(3));
        controlPanel2.add(controlPanel3);
	controlPanel2.add(controlPanel4);
	controlPanel.add(controlPanel1);
	controlPanel.add(controlPanel2);
	frame.add(controlPanel);
	JLabel pw1L= new JLabel(" Enter Password : ", JLabel.LEFT);
	JLabel passwordShow = new JLabel("",JLabel.LEFT);
	final JPasswordField pw1T = new JPasswordField(6);
	JButton loginButton = new JButton("Login ");
        JButton cancelButton = new JButton("Cancel");
	Checkbox showPassword = new Checkbox("Show Password");
	loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
		String p1 = new String(pw1T.getPassword());
		if(p1.equals(pw))
                {
                    frame.dispose();
                    Menu m = new Menu();
                    m.menu2();
		}
		else
                {
                    frame.dispose();
                    JOptionPane.showMessageDialog(null,"Invalid Password!!");
                    Menu m = new Menu();
                    m.menu1();
                }
            }
			
	});
        pw1T.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if(showPassword.getState() == true)
                {
                    String p1 = new String(pw1T.getPassword());
                    passwordShow.setText(p1);
                }
            }
        });
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.menu1();
            }
	});
        showPassword.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e)
            {
		String p1 = new String(pw1T.getPassword());
		if(showPassword.getState())
                    passwordShow.setText(p1);
		else
                    passwordShow.setText("");
            }
	});
	controlPanel1.add(pw1L);
	controlPanel1.add(pw1T);
	controlPanel1.add(showPassword);
	controlPanel1.add(passwordShow);
	controlPanel3.add(loginButton);
        controlPanel4.add(cancelButton);
	frame.setVisible(true);
    }
    public void test1 ()
    {
	FileHandling f = new FileHandling();
	pw = f.pRead();
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setSize(420,150);
	frame.setLayout(new FlowLayout());
	frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
		System.exit(0);
            }        
	});
        JPanel controlPanel = new JPanel();
	controlPanel.setLayout(new GridLayout(2,1));
	controlPanel.setPreferredSize(new Dimension(400,100));
	JPanel controlPanel1 = new JPanel();
	controlPanel1.setLayout(new GridLayout(2,2,10,10));
	JPanel controlPanel2 = new JPanel();
	controlPanel1.setBackground(Color.ORANGE);
	controlPanel2.setLayout(new GridLayout(1,2));
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new FlowLayout(2));
        JPanel controlPanel4 = new JPanel();
        controlPanel4.setLayout(new FlowLayout(3));
        controlPanel2.add(controlPanel3);
	controlPanel2.add(controlPanel4);
	controlPanel.add(controlPanel1);
	controlPanel.add(controlPanel2);
	frame.add(controlPanel);
	JLabel pw1L= new JLabel(" Enter Last Password : ", JLabel.LEFT);
	JLabel passwordShow = new JLabel("",JLabel.LEFT);
	final JPasswordField pw1T = new JPasswordField(6);
	JButton loginButton = new JButton("Login ");
        JButton cancelButton = new JButton("Cancel");
	Checkbox showPassword = new Checkbox("Show Password");
	loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
		String p1 = new String(pw1T.getPassword());
		if(p1.equals(pw))
                {
                    frame.dispose();
                    Password password = new Password();
                    password.setPassword();
		}
		else
                {
                    frame.dispose();
                    JOptionPane.showMessageDialog(null,"Invalid Last Password!!");
                    Menu m = new Menu();
                    m.menu1();
                }
            }
			
	});
        pw1T.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if(showPassword.getState() == true)
                {
                    String p1 = new String(pw1T.getPassword());
                    passwordShow.setText(p1);
                }
            }
        });
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.menu1();
            }
	});
        showPassword.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e)
            {
		String p1 = new String(pw1T.getPassword());
		if(showPassword.getState())
                    passwordShow.setText(p1);
		else
                    passwordShow.setText("");
            }
	});
	controlPanel1.add(pw1L);
	controlPanel1.add(pw1T);
	controlPanel1.add(showPassword);
	controlPanel1.add(passwordShow);
	controlPanel3.add(loginButton);
        controlPanel4.add(cancelButton);
	frame.setVisible(true);
    }
    public void test2 ()
    {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setSize(420,150);
	frame.setLayout(new FlowLayout());
	frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
		System.exit(0);
            }        
	});
        JPanel controlPanel = new JPanel();
	controlPanel.setLayout(new GridLayout(2,1));
	controlPanel.setPreferredSize(new Dimension(400,100));
	JPanel controlPanel1 = new JPanel();
	controlPanel1.setLayout(new GridLayout(2,2,10,10));
	JPanel controlPanel2 = new JPanel();
	controlPanel1.setBackground(Color.ORANGE);
	controlPanel2.setLayout(new GridLayout(1,2));
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new FlowLayout(2));
        JPanel controlPanel4 = new JPanel();
        controlPanel4.setLayout(new FlowLayout(3));
        controlPanel2.add(controlPanel3);
	controlPanel2.add(controlPanel4);
	controlPanel.add(controlPanel1);
	controlPanel.add(controlPanel2);
	frame.add(controlPanel);
	JLabel pw1L= new JLabel(" Enter Member Code : ", JLabel.LEFT);
	JLabel passwordShow = new JLabel("",JLabel.LEFT);
	final JPasswordField pw1T = new JPasswordField(6);
	JButton loginButton = new JButton("Login ");
        JButton cancelButton = new JButton("Cancel");
	Checkbox showPassword = new Checkbox("Show Code");
	loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                Conn C = new Conn();
                String p1 = new String(pw1T.getPassword());
                try
                {
                    String S = "SELECT * FROM MEMBERS WHERE mCode = '" + p1 + "'";
                    ResultSet rs = C.s.executeQuery(S);
                    if(rs.next())
                    {
                        frame.dispose();
                        Menu m = new Menu();
                        m.menu5();
                    }
                    else
                    {
                        frame.dispose();
                        JOptionPane.showMessageDialog(null,"Invalid Member Code!!");
                        Menu m = new Menu();
                        m.menu1();
                    }
                }
                catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
			
	});
        pw1T.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if(showPassword.getState() == true)
                {
                    String p1 = new String(pw1T.getPassword());
                    passwordShow.setText(p1);
                }
            }
        });
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.menu1();
            }
	});
        showPassword.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e)
            {
		String p1 = new String(pw1T.getPassword());
		if(showPassword.getState())
                    passwordShow.setText(p1);
		else
                    passwordShow.setText("");
            }
	});
	controlPanel1.add(pw1L);
	controlPanel1.add(pw1T);
	controlPanel1.add(showPassword);
	controlPanel1.add(passwordShow);
	controlPanel3.add(loginButton);
        controlPanel4.add(cancelButton);
	frame.setVisible(true);
    }
}