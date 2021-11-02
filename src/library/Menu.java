package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu {
    void menu1 ()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(350,130);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }        
        });
        JPanel controlPanel = new JPanel();
	controlPanel.setLayout(new GridLayout(2,2,5,5));
	controlPanel.setPreferredSize(new Dimension(300,80));
	JButton b1 = new JButton("Non Members");
	JButton b2 = new JButton("Members");
	JButton b3 = new JButton("Staff\\Admins");
	JButton b4 = new JButton("Format\\Reset");
	frame.add(controlPanel);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
		Method m = new Method();
                m.instructions();
            }
	});
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
		frame.dispose();
                Password p = new Password();
		p.test2();
            }
	});
	b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
		frame.dispose();
		Password p = new Password();
		p.test();
            }
	});
	b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                int opt = JOptionPane.showConfirmDialog(null,"Do You Really Want To Erase All Data?","",JOptionPane.YES_NO_OPTION);
                if(opt == JOptionPane.YES_OPTION)
                {
                    frame.dispose();
                    Password p = new Password();
                    p.test1();
                }
            }
	});
	controlPanel.add(b1);
	controlPanel.add(b2);
	controlPanel.add(b3);
	controlPanel.add(b4);
	frame.setVisible(true);
    }
    void menu2 ()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(350,170);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }        
        });
        JPanel controlPanel = new JPanel();
	controlPanel.setLayout(new GridLayout(3,1,5,5));
        controlPanel.setPreferredSize(new Dimension(300,120));
        JPanel controlPanel1 = new JPanel();
        controlPanel1.setLayout(new FlowLayout());
        JPanel controlPanel2 = new JPanel();
        controlPanel2.setLayout(new GridLayout(1,2,5,5));
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new GridLayout(1,2,5,5));
        JLabel headLabel = new JLabel("ADMIN MENU");
        controlPanel.add(controlPanel1);
        controlPanel.add(controlPanel2);
        controlPanel.add(controlPanel3);
        frame.add(controlPanel);
        JButton b1 = new JButton("Members");
        JButton b2 = new JButton("Books");
        JButton b3 = new JButton("Back");
        JButton b4 = new JButton("Help");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
		frame.dispose();
		Menu m = new Menu();
                m.menu3();
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
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.menu1();
            }
	});
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                Method m = new Method();
                m.help();
            }
	});
        controlPanel1.add(headLabel);
        controlPanel2.add(b1);
        controlPanel2.add(b2);
        controlPanel3.add(b3);
        controlPanel3.add(b4);
        frame.setVisible(true);
    }
    void menu3 ()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(200,350);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }        
        });
        JPanel controlPanel = new JPanel();
	controlPanel.setLayout(new GridLayout(6,1,5,5));
        controlPanel.setPreferredSize(new Dimension(150,300));
        JPanel controlPanel1 = new JPanel();
        controlPanel1.setLayout(new FlowLayout());
        JPanel controlPanel2 = new JPanel();
        controlPanel2.setLayout(new FlowLayout());
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new FlowLayout());
        JPanel controlPanel4 = new JPanel();
        controlPanel4.setLayout(new FlowLayout());
        JPanel controlPanel5 = new JPanel();
        controlPanel5.setLayout(new FlowLayout());
        JLabel headLabel = new JLabel("ADMIN MENU : MEMBERS" , JLabel.CENTER);
        controlPanel.add(headLabel);
        controlPanel.add(controlPanel1);
        controlPanel.add(controlPanel2);
        controlPanel.add(controlPanel3);
        controlPanel.add(controlPanel4);
        controlPanel.add(controlPanel5);
        frame.add(controlPanel);
        JButton b1 = new JButton("Create New Rec.");
        JButton b2 = new JButton("Delete Rec.");
        JButton b3 = new JButton("Search Rec.");
        JButton b4 = new JButton("Edit Rec.");
        JButton b5 = new JButton("Back");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Member m = new Member();
                m.mGetData();
            }
	});
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Method m = new Method();
                m.mDelete();
            }
	});
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.mSmenu();
            }
	});
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Method m = new Method();
                m.mModify1();
            }
	});
        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.menu2();
            }
	});
        controlPanel1.add(b1);
        controlPanel2.add(b2);
        controlPanel3.add(b3);
        controlPanel4.add(b4);
        controlPanel5.add(b5);
        frame.setVisible(true);
    }
    void menu4 ()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(200,400);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }        
        });
        JPanel controlPanel = new JPanel();
	controlPanel.setLayout(new GridLayout(7,1,5,5));
        controlPanel.setPreferredSize(new Dimension(150,350));
        JPanel controlPanel1 = new JPanel();
        controlPanel1.setLayout(new FlowLayout());
        JPanel controlPanel2 = new JPanel();
        controlPanel2.setLayout(new FlowLayout());
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new FlowLayout());
        JPanel controlPanel4 = new JPanel();
        controlPanel4.setLayout(new FlowLayout());
        JPanel controlPanel5 = new JPanel();
        controlPanel5.setLayout(new FlowLayout());
        JPanel controlPanel6 = new JPanel();
        controlPanel6.setLayout(new FlowLayout());
        JLabel headLabel = new JLabel("ADMIN MENU : BOOKS" , JLabel.CENTER);
        controlPanel.add(headLabel);
        controlPanel.add(controlPanel1);
        controlPanel.add(controlPanel2);
        controlPanel.add(controlPanel3);
        controlPanel.add(controlPanel4);
        controlPanel.add(controlPanel5);
        controlPanel.add(controlPanel6);
        frame.add(controlPanel);
        JButton b1 = new JButton("Create New Rec.");
        JButton b2 = new JButton("Delete Rec.");
        JButton b3 = new JButton("Search Rec.");
        JButton b4 = new JButton("Edit Rec.");
        JButton b5 = new JButton("Issue\\Return");
        JButton b6 = new JButton("Back");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Book b = new Book();
                b.bGetData();
            }
	});
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Method m = new Method();
                m.bDelete();
            }
	});
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.bSmenu();
            }
	});
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Method m = new Method();
                m.bModify1();
            }
	});
        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.returnIssue();
            }
	});
        b6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.menu2();
            }
	});
        controlPanel1.add(b1);
        controlPanel2.add(b2);
        controlPanel3.add(b3);
        controlPanel4.add(b4);
        controlPanel5.add(b5);
        controlPanel6.add(b6);
        frame.setVisible(true);
    }
    void menu5 ()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(220,250);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }        
        });
        JPanel controlPanel = new JPanel();
	controlPanel.setLayout(new GridLayout(4,1,5,5));
        controlPanel.setPreferredSize(new Dimension(170,200));
        JPanel controlPanel1 = new JPanel();
        controlPanel1.setLayout(new FlowLayout());
        JPanel controlPanel2 = new JPanel();
        controlPanel2.setLayout(new FlowLayout());
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new FlowLayout());
        JLabel headLabel = new JLabel("MEMBER MENU" , JLabel.CENTER);
        controlPanel.add(headLabel);
        controlPanel.add(controlPanel1);
        controlPanel.add(controlPanel2);
        controlPanel.add(controlPanel3);
        frame.add(controlPanel);
        JButton b1 = new JButton("Book Search");
        JButton b2 = new JButton("Rules To Be Followed");
        JButton b3 = new JButton("Back");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.memberSearch();
            }
	});
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                Method m = new Method();
                m.rules();
            }
	});
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.menu1();
            }
	});
        controlPanel1.add(b1);
        controlPanel2.add(b2);
        controlPanel3.add(b3);
        frame.setVisible(true);
    }
    void mSmenu ()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(200,250);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }        
        });
        JPanel controlPanel = new JPanel();
	controlPanel.setLayout(new GridLayout(4,1,5,5));
        controlPanel.setPreferredSize(new Dimension(150,200));
        JPanel controlPanel1 = new JPanel();
        controlPanel1.setLayout(new FlowLayout());
        JPanel controlPanel2 = new JPanel();
        controlPanel2.setLayout(new FlowLayout());
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new FlowLayout());
        JLabel headLabel = new JLabel("MEMBERS : SEARCH MENU" , JLabel.CENTER);
        controlPanel.add(headLabel);
        controlPanel.add(controlPanel1);
        controlPanel.add(controlPanel2);
        controlPanel.add(controlPanel3);
        frame.add(controlPanel);
        JButton b1 = new JButton("By Member Code");
        JButton b2 = new JButton("By Member Name");
        JButton b3 = new JButton("Back");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Method m = new Method();
                m.mSearchCode();
            }
	});
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Method m = new Method();
                m.mSearchName();
            }
	});
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.menu3();
            }
	});
        controlPanel1.add(b1);
        controlPanel2.add(b2);
        controlPanel3.add(b3);
        frame.setVisible(true);
    }
    void bSmenu ()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(200,300);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }        
        });
        JPanel controlPanel = new JPanel();
	controlPanel.setLayout(new GridLayout(5,1,5,5));
        controlPanel.setPreferredSize(new Dimension(150,250));
        JPanel controlPanel1 = new JPanel();
        controlPanel1.setLayout(new FlowLayout());
        JPanel controlPanel2 = new JPanel();
        controlPanel2.setLayout(new FlowLayout());
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new FlowLayout());
        JPanel controlPanel4 = new JPanel();
        controlPanel4.setLayout(new FlowLayout());
        JLabel headLabel = new JLabel("BOOKS : SEARCH MENU" , JLabel.CENTER);
        controlPanel.add(headLabel);
        controlPanel.add(controlPanel1);
        controlPanel.add(controlPanel2);
        controlPanel.add(controlPanel3);
        controlPanel.add(controlPanel4);
        frame.add(controlPanel);
        JButton b1 = new JButton("By Book Code");
        JButton b2 = new JButton("By Book Name");
        JButton b3 = new JButton("By Book Genere");
        JButton b4 = new JButton("Back");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Method m = new Method();
                m.bSearchCode();
            }
	});
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Method m = new Method();
                m.bSearchName();
            }
	});
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Method m = new Method();
                m.bSearchGenere();
            }
	});
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.menu4();
            }
	});
        controlPanel1.add(b1);
        controlPanel2.add(b2);
        controlPanel3.add(b3);
        controlPanel4.add(b4);
        frame.setVisible(true);
    }
    void returnIssue ()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(200,300);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }        
        });
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(5,1,5,5));
        controlPanel.setPreferredSize(new Dimension(150,250));
        JPanel controlPanel1 = new JPanel();
        controlPanel1.setLayout(new FlowLayout());
        JPanel controlPanel2 = new JPanel();
        controlPanel2.setLayout(new FlowLayout());
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new FlowLayout());
        JPanel controlPanel4 = new JPanel();
        controlPanel4.setLayout(new FlowLayout());
        JPanel controlPanel5 = new JPanel();
        controlPanel5.setLayout(new FlowLayout());
        controlPanel.add(controlPanel1);
        controlPanel.add(controlPanel2);
        controlPanel.add(controlPanel3);
        controlPanel.add(controlPanel4);
        controlPanel.add(controlPanel5);
        frame.add(controlPanel);
        JLabel headLabel = new JLabel("RETURN\\ISSUE",JLabel.CENTER);
        JButton b1 = new JButton("Issue");
        JButton b2 = new JButton("Return");
        JButton b3 = new JButton("Issuing Details");
        JButton b4 = new JButton("back");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Method m = new Method();
                m.issue();
            }
	});
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Method m = new Method();
                m.return1();
            }
	});
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                Method m = new Method();
                m.issueDetails();
            }
	});
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.menu4();
            }
	});
        controlPanel1.add(headLabel);
        controlPanel2.add(b1);
        controlPanel3.add(b2);
        controlPanel4.add(b3);
        controlPanel5.add(b4);
        frame.setVisible(true);
    }
    void memberSearch ()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(200,250);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent)
            {
                System.exit(0);
            }        
        });
        JPanel controlPanel = new JPanel();
	controlPanel.setLayout(new GridLayout(4,1,5,5));
        controlPanel.setPreferredSize(new Dimension(150,200));
        JPanel controlPanel1 = new JPanel();
        controlPanel1.setLayout(new FlowLayout());
        JPanel controlPanel2 = new JPanel();
        controlPanel2.setLayout(new FlowLayout());
        JPanel controlPanel3 = new JPanel();
        controlPanel3.setLayout(new FlowLayout());
        JLabel headLabel = new JLabel("SEARCH MENU" , JLabel.CENTER);
        controlPanel.add(headLabel);
        controlPanel.add(controlPanel1);
        controlPanel.add(controlPanel2);
        controlPanel.add(controlPanel3);
        frame.add(controlPanel);
        JButton b1 = new JButton("By Name");
        JButton b2 = new JButton("By Genere");
        JButton b3 = new JButton("Back");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Method m = new Method();
                m.bookInfoName();
            }
	});
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Method m = new Method();
                m.bookInfoGenere();
            }
	});
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Menu m = new Menu();
                m.menu5();
            }
	});
        controlPanel1.add(b1);
        controlPanel2.add(b2);
        controlPanel3.add(b3);
        frame.setVisible(true);
    }
}