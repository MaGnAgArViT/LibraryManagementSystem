package library;

import java.io.*;

public class FileHandling {
    public void pWrite (Password p)
    {
        try
	{
            FileOutputStream o = new FileOutputStream("password.txt");
            ObjectOutputStream outStream = new ObjectOutputStream (o);
            outStream.writeObject(p);
            outStream.close();
	}
	catch(IOException e)
	{
	}
    }
    public String pRead ()
    {
	String pass = "";
	try
	{
            FileInputStream i = new FileInputStream("password.txt");
            ObjectInputStream inStream = new ObjectInputStream(i);
            Password p = (Password) inStream.readObject();
            pass = p.pw;
            inStream.close();
	}
	catch(IOException e1)
	{		
	}
	catch(ClassNotFoundException e2)
	{
	}
        return pass;
    }
}