package library;

import java.sql.*;

public class Conn {
    public Connection c;
    public Statement s;
    public Conn ()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///library","root","password");     //set database name and sql password
            s = c.createStatement();
        }
        catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
    }
}