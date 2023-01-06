//package jdbc;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class LoginWindow extends Frame implements ActionListener
{
	JLabel jlab1;
	Label lab10, lab11;
	TextField tf10, tf11;
	Button b2;
	
	LoginWindow()
	{
		setResizable(false);
		
		addWindowListener (new WindowAdapter() 
		{    
	         public void windowClosing (WindowEvent e) 
	         {    
	               System.exit(1);    
	         }    
	    });    
		
		Font f=new Font("Times New Roman",Font.PLAIN,30);
		setBackground(new Color(65,105,225));
		
		lab10 = new Label("Username     - ");
		lab10.setBounds(150,380,200,50);
		tf10 = new TextField();
		tf10.setBounds(400,380,180,40);
		lab10.setFont(f);
		tf10.setFont(f);
		
		lab11 = new Label("Password     - ");
		lab11.setBounds(150,450,200,50);
		tf11 = new TextField();
		tf11.setBounds(400,450,180,40);
		lab11.setFont(f);
		tf11.setFont(f);
		tf11.setEchoChar('*');
		
		
		b2 = new Button("Sign in");
		b2.addActionListener(this);
		b2.setBounds(260,530,150,50);
		b2.setFont(f);
		b2.setBackground(new Color(255,255,255));
		
		ImageIcon ic = new ImageIcon("C:/Users/hp/Desktop/crime.jpg");
		jlab1 = new JLabel(ic);
		jlab1.setBounds(10,10,700,350);
		
		add(jlab1);
		add(lab10);
		add(tf10);
		add(lab11);
		add(tf11);
		add(b2);
		
		setSize(700,700);
		setLayout(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try
		{ 
			System.out.println("Function Called "); 
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crimelogger","root","1234");  
			System.out.println("You are Connected ");
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery("select * from user where username='"+tf10.getText()+"' and password='"+tf11.getText()+"'");
			if(rs.next())
			{
				//new jdbc_file();
				dispose();
			}
			else
				System.out.println("Username or Password Wrong ");
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		}  
	}
	
	public static void main(String [] ar)
	{
		new LoginWindow();
	}
}

