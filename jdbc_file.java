package crimelogger;

//package jdbc;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class Jdbc_file extends Frame implements ActionListener
{
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	
	Panel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12;
	Button b14,b15,b16,b17,b18,b19,b20,b21,b22,b23;
	Label lab70;
	
	//Panel - 3 Register FIR
	Label lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9;
	TextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9;
	Checkbox rb3, rb4;
	CheckboxGroup cbg;
	Button b1;
	
	//Panel - 4 Update FIR
	Label lab12, lab13, lab14, lab15, lab16, lab17, lab18;
	TextField tf12, tf13, tf14, tf15, tf16, tf17, tf18;
	Button b3, b4;
	
	//Panel - 5 Delete FIR
	Label lab19, lab20, lab21, lab22, lab23, lab24, lab25, lab26, lab27, lab28, lab29, lab30, lab31;
	TextField tf19;
	Button b5,b6;
	
	//Panel - 6 Delete Criminal Record
	Label lab32, lab33, lab34, lab35, lab36, lab37, lab38;
	TextField tf32;
	Button b7, b8;
	
	//Panel - 7 Update Criminal Record
	Label lab39, lab40, lab41, lab42;
	TextField tf39, tf40, tf41, tf42;
	Button b9, b10;
	
	//Panel - 8 Add Criminal
	Label lab43, lab44, lab45, lab46, lab47, lab48, lab49;
	TextField tf43, tf44, tf45, tf46, tf48, tf49;
	Checkbox rb5, rb6;
	Button b11;
	
	//Panel - 9 Retrieve FIR
	Label lab50, lab51, lab52, lab53, lab54, lab55, lab56, lab57, lab58, lab59, lab60, lab61, lab62;
	TextField tf50;
	Button b12;
	
	//Panel - 10 Retrieve Criminal Record
	Label lab63, lab64, lab65, lab66, lab67, lab68, lab69;
	TextField tf63;
	Button b13;
	
	Button b25,b26;
	
	Jdbc_file()
	{
		setResizable(false);
		connect();

		addWindowListener (new WindowAdapter() 
		{    
	         public void windowClosing (WindowEvent e) 
	         {    
	               System.exit(1);    
	         }    
	    });    
		 
		// Panel - 1 
		p1 = new Panel();
		p1.setBounds(10,10,700,200);
		p1.setBackground(new Color(0,206,209));
		p1.setLayout(null);
		
		Font f=new Font("Times New Roman",Font.BOLD,30);
		Font fo=new Font("Times New Roman",Font.ITALIC,20);
		Font fon=new Font("Times New Roman",Font.PLAIN,20);
		
		lab70 = new Label("Welcome Admin");
		lab70.setBounds(220,80,300,40);
		lab70.setFont(f);
		
		b14 = new Button("Home");
		b14.addActionListener(this);
		b14.setBounds(50,80,130,40);
		b14.setBackground(new Color(255,255,255));	
		b14.setFont(fon);
		
		b15 = new Button("Log Out");
		b15.addActionListener(this);
		b15.setBounds(510,80,130,40);
		b15.setBackground(new Color(255,255,255));
		b15.setFont(fon);
		
		p1.add(b14);
		p1.add(b15);
		p1.add(lab70);
		add(p1);
		
		
		//Panel - 2
		p2 = new Panel();
		p2.setBounds(10,210,700,490);
		p2.setBackground(new Color(0,0,0));
		p2.setLayout(null);
		
		b16 = new Button("Register FIR");
		b16.setBounds(50,50,250,40);
		b16.addActionListener(this);
		b16.setFont(fon);
		b16.setBackground(new Color(255,255,255));
		
		b17 = new Button("Update FIR");
		b17.setBounds(400,50,250,40);
		b17.addActionListener(this);
		b17.setFont(fon);
		b17.setBackground(new Color(255,255,255));
		
		b18 = new Button("Delete FIR");
		b18.setBounds(50,110,250,40);
		b18.addActionListener(this);
		b18.setFont(fon);
		b18.setBackground(new Color(255,255,255));
		
		b19 = new Button("Delete Criminal Record");
		b19.setBounds(400,110,250,40);
		b19.addActionListener(this);
		b19.setFont(fon);
		b19.setBackground(new Color(255,255,255));
		
		b20 = new Button("Update Criminal Record");
		b20.setBounds(50,170,250,40);
		b20.addActionListener(this);
		b20.setFont(fon);
		b20.setBackground(new Color(255,255,255));
		
		b21 = new Button("Add Criminal");
		b21.setBounds(400,170,250,40);
		b21.addActionListener(this);
		b21.setFont(fon);
		b21.setBackground(new Color(255,255,255));
		
		b22 = new Button("Retrieve FIR");
		b22.setBounds(50,230,250,40);
		b22.addActionListener(this);
		b22.setFont(fon);
		b22.setBackground(new Color(255,255,255));
		
		b23 = new Button("Retrieve Criminal Record");
		b23.setBounds(400,230,250,40);
		b23.addActionListener(this);
		b23.setFont(fon);
		b23.setBackground(new Color(255,255,255));
	    
		b25 = new Button("All Registered FIR's ");
		b25.setBounds(50,290,250,40);
		b25.addActionListener(this);
		b25.setFont(fon);
		b25.setBackground(new Color(255,255,255));
		
		b26 = new Button("All Registered Criminal's ");
		b26.setBounds(400,290,250,40);
		b26.addActionListener(this);
		b26.setFont(fon);
		b26.setBackground(new Color(255,255,255));
	    
		
		p2.add(b16);
		p2.add(b17);
		p2.add(b18);
		p2.add(b19);
		p2.add(b20);
		p2.add(b21);
		p2.add(b22);
		p2.add(b23);
		p2.add(b25);
		p2.add(b26);
		add(p2);
		
		
		//Panel - 3 Register FIR
		p3 = new Panel();
		p3.setBounds(10,210,700,490);
		p3.setBackground(new Color(32,178,170));
		p3.setLayout(null);
		p3.setVisible(false);
		add(p3);
		
		lab1 = new Label("FIR Number");
		lab1.setBounds(50,50,150,30);
		tf1 = new TextField();
		tf1.setBounds(250,50,200,30);
		lab1.setFont(fo);
		tf1.setFont(fo);
		
		lab2 = new Label("Full Name");
		lab2.setBounds(50,90,150,30);
		tf2 = new TextField();
		tf2.setBounds(250,90,200,30);
		lab2.setFont(fo);
		tf2.setFont(fo);
		
		lab3 = new Label("Alias");
		lab3.setBounds(50,130,150,30);
		tf3 = new TextField();
		tf3.setBounds(250,130,200,30);
		lab3.setFont(fo);
		tf3.setFont(fo);
		
		lab4 = new Label("Date of FIR");
		lab4.setBounds(50,170,150,30);
		tf4 = new TextField();
		tf4.setBounds(250,170,200,30);
		lab4.setFont(fo);
		tf4.setFont(fo);
		
		lab5 = new Label("Crime Involved");
		lab5.setBounds(50,210,150,30);
		tf5 = new TextField();
		tf5.setBounds(250,210,200,30);
		lab5.setFont(fo);
		tf5.setFont(fo);
		
		lab6 = new Label("Gender");
		lab6.setBounds(50,250,150,30);
		cbg=new CheckboxGroup();
		rb3 = new Checkbox("Male", false, cbg);
		rb3.setBounds(250,250,100,30);
		rb4 = new Checkbox("Female", false, cbg);
		rb4.setBounds(350,250,100,30);
		lab6.setFont(fo);
		rb3.setFont(fo);
		rb4.setFont(fo);
		
		lab7 = new Label("Criminal ID");
		lab7.setBounds(50,290,150,30);
		tf7 = new TextField();
		tf7.setBounds(250,290,200,30);
		lab7.setFont(fo);
		tf7.setFont(fo);
		
		lab8 = new Label("Address");
		lab8.setBounds(50,330,150,30);
		tf8 = new TextField();
		tf8.setBounds(250,330,200,30);
		lab8.setFont(fo);
		tf8.setFont(fo);
		
		lab9 = new Label("Aadhar Card No.");
		lab9.setBounds(50,370,150,30);
		tf9 = new TextField();
		tf9.setBounds(250,370,200,30);
		lab9.setFont(fo);
		tf9.setFont(fo);
		
		b1 = new Button("Submit");
		b1.addActionListener(this);
		b1.setBounds(150,420,150,40);
		b1.setFont(fon);
		
		p3.add(lab1); 
		p3.add(tf1);
		p3.add(lab2);
		p3.add(tf2);
		p3.add(lab3);
		p3.add(tf3);
		p3.add(lab4);
		p3.add(tf4);
		p3.add(lab5);
		p3.add(tf5);
		p3.add(lab6);
		p3.add(rb3);
		p3.add(rb4);
		p3.add(lab7);
		p3.add(tf7);
		p3.add(lab8);
		p3.add(tf8);
		p3.add(lab9);
		p3.add(tf9);
		p3.add(b1);
		
		//Panel - 4 Update FIR
		p4 = new Panel();
		p4.setBounds(10,210,700,490);
		p4.setBackground(new Color(220,20,60));
		p4.setLayout(null);
		p4.setVisible(false);
		add(p4);
		
		lab12 = new Label("FIR Number");
		lab12.setBounds(50,50,150,30);
		tf12 = new TextField();
		tf12.setBounds(250,50,200,30);
		lab12.setFont(fo);
		tf12.setFont(fo);
		
		b3 = new Button("Search");
		b3.addActionListener(this);
		b3.setBounds(150,100,150,40);
		b3.setFont(fon);
		b3.setBackground(new Color(255,255,255));
		
		lab13 = new Label("Full Name");
		lab13.setBounds(50,160,150,30);
		tf13 = new TextField();
		tf13.setBounds(250,160,200,30);
		lab13.setFont(fo);
		tf13.setFont(fo);
		
		lab14 = new Label("Criminal ID");
		lab14.setBounds(50,200,150,30);
		tf14 = new TextField();
		tf14.setBounds(250,200,200,30);
		lab14.setFont(fo);
		tf14.setFont(fo);
		
		lab15 = new Label("Type of Crime");
		lab15.setBounds(50,240,150,30);
		tf15 = new TextField();
		tf15.setBounds(250,240,200,30);
		lab15.setFont(fo);
		tf15.setFont(fo);
		
		lab16 = new Label("Fir Date");
		lab16.setBounds(50,280,150,30);
		tf16 = new TextField();
		tf16.setBounds(250,280,200,30);
		lab16.setFont(fo);
		tf16.setFont(fo);
		
		lab17 = new Label("Address");
		lab17.setBounds(50,320,150,30);
		tf17 = new TextField();
		tf17.setBounds(250,320,200,30);
		lab17.setFont(fo);
		tf17.setFont(fo);
		
		lab18 = new Label("Aadhar Card No.");
		lab18.setBounds(50,360,150,30);
		tf18 = new TextField();
		tf18.setBounds(250,360,200,30);
		lab18.setFont(fo);
		tf18.setFont(fo);
		
		b4 = new Button("Update");
		b4.addActionListener(this);
		b4.setBounds(150,410,150,40);
		b4.setFont(fon);
		b4.setBackground(new Color(255,255,255));
		
		p4.add(lab12);
		p4.add(tf12);
		p4.add(lab13);
		p4.add(tf13);
		p4.add(lab14);
		p4.add(tf14);
		p4.add(lab15);
		p4.add(tf15);
		p4.add(lab16);
		p4.add(tf16);
		p4.add(lab17);
		p4.add(tf17);
		p4.add(lab18);
		p4.add(tf18);
		p4.add(b3);
		p4.add(b4);
		
		//Panel - 5 Delete FIR
		p5 = new Panel();
		p5.setBounds(10,210,700,490);
		p5.setBackground(new Color(199,21,133));
		p5.setLayout(null);
		p5.setVisible(false);
		add(p5);
		
		lab19 = new Label("FIR Number");
		lab19.setBounds(50,50,150,30);
		tf19 = new TextField();
		tf19.setBounds(250,50,200,30);
		lab19.setFont(fo);
		tf19.setFont(fo);
		
		b5 = new Button("Search");
		b5.addActionListener(this);
		b5.setBounds(150,100,150,40);
		b5.setFont(fon);
		b5.setBackground(new Color(255,255,255));
		
		lab20 = new Label("Full Name - ");
		lab20.setBounds(50,160,150,30);
		lab21 = new Label();
		lab21.setBounds(250,160,200,30);
		lab20.setFont(fo);
		lab21.setFont(fo);
		
		lab22 = new Label("Criminal ID - ");
		lab22.setBounds(50,200,150,30);
		lab23 = new Label();
		lab23.setBounds(250,200,200,30);
		lab22.setFont(fo);
		lab23.setFont(fo);
		
		lab24 = new Label("Type of Crime - ");
		lab24.setBounds(50,240,150,30);
		lab25 = new Label();
		lab25.setBounds(250,240,200,30);
		lab24.setFont(fo);
		lab25.setFont(fo);
		
		lab26 = new Label("FIR Date - ");
		lab26.setBounds(50,280,150,30);
		lab27 = new Label();
		lab27.setBounds(250,280,200,30);
		lab26.setFont(fo);
		lab27.setFont(fo);
		
		lab28 = new Label("Address - ");
		lab28.setBounds(50,320,150,30);
		lab29 = new Label();
		lab29.setBounds(250,320,200,30);
		lab28.setFont(fo);
		lab29.setFont(fo);
		
		lab30 = new Label("Aadhar No - ");
		lab30.setBounds(50,360,150,30);
		lab31 = new Label();
		lab31.setBounds(250,360,200,30);
		lab30.setFont(fo);
		lab31.setFont(fo);
		
		b6 = new Button("Delete");
		b6.addActionListener(this);
		b6.setBounds(150,410,150,40);
		b6.setFont(fon);
		b6.setBackground(new Color(255,255,255));
		
		p5.add(lab19);
		p5.add(tf19);
		p5.add(b5);
		p5.add(lab20);
		p5.add(lab21);
		p5.add(lab22);
		p5.add(lab23);
		p5.add(lab24);
		p5.add(lab25);
		p5.add(lab26);
		p5.add(lab27);
		p5.add(lab28);
		p5.add(lab29);
		p5.add(lab30);
		p5.add(lab31);
		p5.add(b6);
		
		//Panel - 6 Delete Criminal Record
		p6 = new Panel();
		p6.setBounds(10,210,700,490);
		p6.setBackground(new Color(102,205,170));
		p6.setLayout(null);
		p6.setVisible(false);
		add(p6);
		
		lab32 = new Label("Criminal No.");
		lab32.setBounds(50,50,150,30);
		tf32 = new TextField();
		tf32.setBounds(250,50,200,30);
		lab32.setFont(fo);
		tf32.setFont(fo);
		
		b7 = new Button("Search");
		b7.addActionListener(this);
		b7.setBounds(150,100,150,40);
		b7.setFont(fon);
		b7.setBackground(new Color(255,255,255));
		
		lab33 = new Label("Full Name - ");
		lab33.setBounds(50,160,150,30);
		lab34 = new Label();
		lab34.setBounds(250,160,200,30);
		lab33.setFont(fo);
		lab34.setFont(fo);
		
		lab35 = new Label("Address - ");
		lab35.setBounds(50,200,150,30);
		lab36 = new Label();
		lab36.setBounds(250,200,200,30);
		lab35.setFont(fo);
		lab36.setFont(fo);
		
		lab37 = new Label("Aadhar No. - ");
		lab37.setBounds(50,240,150,30);
		lab38 = new Label();
		lab38.setBounds(250,240,200,30);
		lab37.setFont(fo);
		lab38.setFont(fo);
		
		b8 = new Button("Delete");
		b8.addActionListener(this);
		b8.setBounds(150,290,150,40);
		b8.setFont(fon);
		b8.setBackground(new Color(255,255,255));
		
		p6.add(lab32);
		p6.add(tf32);
		p6.add(b7);
		p6.add(lab33);
		p6.add(lab34);
		p6.add(lab35);
		p6.add(lab36);
		p6.add(lab37);
		p6.add(lab38);
		p6.add(b8);
		
		//Panel - 7 Update Criminal Record 
		p7 = new Panel();
		p7.setBounds(10,210,700,490);
		p7.setBackground(new Color(0,139,139));
		p7.setLayout(null);
		p7.setVisible(false);
		add(p7);
		
		lab39 = new Label("Criminal No.");
		lab39.setBounds(50,50,150,30);
		tf39 = new TextField();
		tf39.setBounds(250,50,200,30);
		lab39.setFont(fo);
		tf39.setFont(fo);
		
		b9 = new Button("Search");
		b9.addActionListener(this);
		b9.setBounds(150,100,150,40);
		b9.setFont(fon);
		b9.setBackground(new Color(255,255,255));
		
		lab40 = new Label("Full Name - ");
		lab40.setBounds(50,160,150,30);
		tf40 = new TextField();
		tf40.setBounds(250,160,200,30);
		lab40.setFont(fo);
		tf40.setFont(fo);
		
		lab41 = new Label("Address - ");
		lab41.setBounds(50,200,150,30);
		tf41 = new TextField();
		tf41.setBounds(250,200,200,30);
		lab41.setFont(fo);
		tf41.setFont(fo);
		
		lab42 = new Label("Aadhar No. - ");
		lab42.setBounds(50,240,150,30);
		tf42 = new TextField();
		tf42.setBounds(250,240,200,30);
		lab42.setFont(fo);
		tf42.setFont(fo);
		
		b10 = new Button("Update");
		b10.addActionListener(this);
		b10.setBounds(150,290,150,40);
		b10.setFont(fon);
		b10.setBackground(new Color(255,255,255));
		
		p7.add(lab39);
		p7.add(tf39);
		p7.add(b9);
		p7.add(lab40);
		p7.add(tf40);
		p7.add(lab41);
		p7.add(tf41);
		p7.add(lab42);
		p7.add(tf42);
		p7.add(b10);
		
		//Panel - 8 Add Criminal
		p8 = new Panel();
		p8.setBounds(10,210,700,490);
		p8.setBackground(new Color(154,205,50));
		p8.setLayout(null);
		p8.setVisible(false);
		add(p8);
		
		lab43 = new Label("Criminal ID");
		lab43.setBounds(50,50,150,30);
		tf43 = new TextField();
		tf43.setBounds(250,50,200,30);
		lab43.setFont(fo);
		tf43.setFont(fo);
		
		lab44 = new Label("Full Name");
		lab44.setBounds(50,90,150,30);
		tf44 = new TextField();
		tf44.setBounds(250,90,200,30);
		lab44.setFont(fo);
		tf44.setFont(fo);
		
		lab45 = new Label("Alias");
		lab45.setBounds(50,130,150,30);
		tf45 = new TextField();
		tf45.setBounds(250,130,200,30);
		lab45.setFont(fo);
		tf45.setFont(fo);
		
		lab46 = new Label("Crime Involved");
		lab46.setBounds(50,170,150,30);
		tf46 = new TextField();
		tf46.setBounds(250,170,200,30);
		lab46.setFont(fo);
		tf46.setFont(fo);
		
		lab47 = new Label("Gender");
		lab47.setBounds(50,210,150,30);
		cbg=new CheckboxGroup();
		rb5 = new Checkbox("Male", false, cbg);
		rb5.setBounds(250,210,100,30);
		rb6 = new Checkbox("Female", false, cbg);
		rb6.setBounds(350,210,100,30);
		lab47.setFont(fo);
		rb5.setFont(fo);
		rb6.setFont(fo);
		
		lab48 = new Label("Address");
		lab48.setBounds(50,250,150,30);
		tf48 = new TextField();
		tf48.setBounds(250,250,200,30);
		lab48.setFont(fo);
		tf48.setFont(fo);
		
		lab49 = new Label("Aadhar Card No.");
		lab49.setBounds(50,290,150,30);
		tf49 = new TextField();
		tf49.setBounds(250,290,200,30);
		lab49.setFont(fo);
		tf49.setFont(fo);
		
		b11 = new Button("Submit");
		b11.addActionListener(this);
		b11.setBounds(150,340,150,40);
		b11.setFont(fon);
		b11.setBackground(new Color(255,255,255));
		
		p8.add(lab43);
		p8.add(tf43);
		p8.add(lab44);
		p8.add(tf44);
		p8.add(lab45);
		p8.add(tf45);
		p8.add(lab46);
		p8.add(tf46);
		p8.add(lab47);
		p8.add(rb5);
		p8.add(rb6);
		p8.add(lab48);
		p8.add(tf48);
		p8.add(lab49);
		p8.add(tf49);
		p8.add(b11);
		
		//Panel - 9 Retrieve FIR
		p9 = new Panel();
		p9.setBounds(10,210,700,490);
		p9.setBackground(new Color(255,215,0));
		p9.setLayout(null);
		p9.setVisible(false);
		add(p9);
		
		lab50 = new Label("FIR Number");
		lab50.setBounds(50,50,150,30);
		tf50 = new TextField();
		tf50.setBounds(250,50,200,30);
		lab50.setFont(fo);
		tf50.setFont(fo);
		
		b12 = new Button("Search");
		b12.addActionListener(this);
		b12.setBounds(150,100,150,40);
		b12.setFont(fon);
		b12.setBackground(new Color(255,255,255));
		
		lab51 = new Label("Full Name - ");
		lab51.setBounds(50,160,150,30);
		lab52 = new Label();
		lab52.setBounds(250,160,200,30);
		lab51.setFont(fo);
		lab52.setFont(fo);
		
		lab53 = new Label("Criminal ID - ");
		lab53.setBounds(50,200,150,30);
		lab54 = new Label();
		lab54.setBounds(250,200,200,30);
		lab53.setFont(fo);
		lab54.setFont(fo);
		
		lab55 = new Label("Type of Crime - ");
		lab55.setBounds(50,240,150,30);
		lab56 = new Label();
		lab56.setBounds(250,240,200,30);
		lab55.setFont(fo);
		lab56.setFont(fo);
		
		lab57 = new Label("FIR Date - ");
		lab57.setBounds(50,280,150,30);
		lab58 = new Label();
		lab58.setBounds(250,280,200,30);
		lab57.setFont(fo);
		lab58.setFont(fo);
		
		lab59 = new Label("Address - ");
		lab59.setBounds(50,320,150,30);
		lab60 = new Label();
		lab60.setBounds(250,320,200,30);
		lab59.setFont(fo);
		lab60.setFont(fo);
		
		lab61 = new Label("Aadhar No. - ");
		lab61.setBounds(50,360,150,30);
		lab62 = new Label();
		lab62.setBounds(250,360,200,30);
		lab61.setFont(fo);
		lab62.setFont(fo);
		
		p9.add(lab50);
		p9.add(tf50);
		p9.add(b12);
		p9.add(lab51);
		p9.add(lab52);
		p9.add(lab53);
		p9.add(lab54);
		p9.add(lab55);
		p9.add(lab56);
		p9.add(lab57);
		p9.add(lab58);
		p9.add(lab59);
		p9.add(lab60);
		p9.add(lab61);
		p9.add(lab62);
		
		//Panel - 10 Retrieve Criminal Record
		p10 = new Panel();
		p10.setBounds(10,210,700,490);
		p10.setBackground(new Color(255,105,180));
		p10.setLayout(null);
		p10.setVisible(false);
		add(p10);
		
		lab63 = new Label("Criminal No.");
		lab63.setBounds(50,50,150,30);
		tf63 = new TextField();
		tf63.setBounds(250,50,200,30);
		lab63.setFont(fo);
		tf63.setFont(fo);
		
		b13 = new Button("Search");
		b13.addActionListener(this);
		b13.setBounds(150,100,150,40);
		b13.setFont(fon);
		b13.setBackground(new Color(255,255,255));
		
		lab64 = new Label("Full Name - ");
		lab64.setBounds(50,160,150,30);
		lab65 = new Label();
		lab65.setBounds(250,160,200,30);
		lab64.setFont(fo);
		lab65.setFont(fo);
		
		lab66 = new Label("Address - ");
		lab66.setBounds(50,200,150,30);
		lab67 = new Label();
		lab67.setBounds(250,200,200,30);
		lab66.setFont(fo);
		lab67.setFont(fo);
		
		lab68 = new Label("Aadhar No. - ");
		lab68.setBounds(50,240,150,30);
		lab69 = new Label();
		lab69.setBounds(250,240,200,30);
		lab68.setFont(fo);
		lab69.setFont(fo);
		
		p10.add(lab63);
		p10.add(tf63);
		p10.add(b13);
		p10.add(lab64);
		p10.add(lab65);
		p10.add(lab66);
		p10.add(lab67);
		p10.add(lab68);
		p10.add(lab69);
		
		//Panel-11 Retrieve Criminal Record
		p11 = new Panel();
		p11.setBounds(10,210,700,490);
		p11.setBackground(new Color(255,105,180));
		p11.setLayout(null);
		p11.setVisible(false);
		add(p11);
		
		String header[]= {"Fir NO","Name ","Crime ","Date of Fir ","Aadhar NO "};
		String data[][] = new String[100][100];
		connect();
		int i=0;
		try {
			st=con.createStatement();
			rs=st.executeQuery("select * from fir");
			while(rs.next())
			{
				data[i][0]=rs.getString("firno");
				data[i][1]=rs.getString("name");
				data[i][2]=rs.getString("crime");
				data[i][3]=rs.getString("date");
				data[i][4]=rs.getString("aadhar");
				i++;
			}
		}catch(Exception e) {}
		
		JTable jt = new JTable(data,header);
		JScrollPane jsp = new JScrollPane(jt);
		jt.setEnabled(false);
		jsp.setBounds(20,50,650,400);
		p11.add(jsp);
		
		//Panel-12 Retrieve Criminal Record
		p12 = new Panel();
		p12.setBounds(10,210,700,490);
		p12.setBackground(new Color(255,105,180));
		p12.setLayout(null);
		p12.setVisible(false);
		add(p12);

		String head[]= {"Criminal ID","Name ","Crime ","Aadhar NO "};
		String dataCrime[][] = new String[100][100];
		connect();
		i=0;
		try {
			st=con.createStatement();
			rs=st.executeQuery("select * from crimelogger");
			while(rs.next())
			{
				dataCrime[i][0]=rs.getString("criminal_id");
				dataCrime[i][1]=rs.getString("name");
				dataCrime[i][2]=rs.getString("crime");
				dataCrime[i][3]=rs.getString("aadhar");
				i++;
			}
		}catch(Exception e) {}
		
		JTable jt1 = new JTable(dataCrime,head);
		JScrollPane jsp1 = new JScrollPane(jt1);
		jt.setEnabled(false);
		jsp1.setBounds(20,50,650,400);
		p12.add(jsp1);

		
		setSize(700,700);
		setLayout(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b26)
		{
			p11.setVisible(false);
			p12.setVisible(true);
			p2.setVisible(false);
			p3.setVisible(false);
			p4.setVisible(false);
			p5.setVisible(false);
			p6.setVisible(false);
			p7.setVisible(false);
			p8.setVisible(false);
			p9.setVisible(false);
			p10.setVisible(false);
		}
	
		if(ae.getSource()==b25)
		{
			p11.setVisible(true);
			p2.setVisible(false);
			p3.setVisible(false);
			p4.setVisible(false);
			p5.setVisible(false);
			p6.setVisible(false);
			p7.setVisible(false);
			p8.setVisible(false);
			p9.setVisible(false);
			p10.setVisible(false);
		}
		if(ae.getSource()==b16)
		{
			p2.setVisible(false);
			p3.setVisible(true);
			p4.setVisible(false);
			p5.setVisible(false);
			p6.setVisible(false);
			p7.setVisible(false);
			p8.setVisible(false);
			p9.setVisible(false);
			p10.setVisible(false);
			p11.setVisible(false);
			p12.setVisible(false);
		}
		
		if(ae.getSource()==b17)
		{
			p2.setVisible(false);
			p3.setVisible(false);
			p4.setVisible(true);
			p5.setVisible(false);
			p6.setVisible(false);
			p7.setVisible(false);
			p8.setVisible(false);
			p9.setVisible(false);
			p10.setVisible(false);
			p11.setVisible(false);
			p12.setVisible(false);
		}
		
		if(ae.getSource()==b18)
		{
			p2.setVisible(false);
			p3.setVisible(false);
			p4.setVisible(false);
			p5.setVisible(true);
			p6.setVisible(false);
			p7.setVisible(false);
			p8.setVisible(false);
			p9.setVisible(false);
			p10.setVisible(false);
			p11.setVisible(false);
			p12.setVisible(false);
		}
		
		if(ae.getSource()==b19)
		{
			p2.setVisible(false);
			p3.setVisible(false);
			p4.setVisible(false);
			p5.setVisible(false);
			p6.setVisible(true);
			p7.setVisible(false);
			p8.setVisible(false);
			p9.setVisible(false);
			p10.setVisible(false);
			p11.setVisible(false);
			p12.setVisible(false);
		}
		
		if(ae.getSource()==b20)
		{
			p2.setVisible(false);
			p3.setVisible(false);
			p4.setVisible(false);
			p5.setVisible(false);
			p6.setVisible(false);
			p7.setVisible(true);
			p8.setVisible(false);
			p9.setVisible(false);
			p10.setVisible(false);
			p11.setVisible(false);
			p12.setVisible(false);
		}
		
		if(ae.getSource()==b21)
		{
			p2.setVisible(false);
			p3.setVisible(false);
			p4.setVisible(false);
			p5.setVisible(false);
			p6.setVisible(false);
			p7.setVisible(false);
			p8.setVisible(true);
			p9.setVisible(false);
			p10.setVisible(false);
			p11.setVisible(false);
			p12.setVisible(false);
		}
		
		if(ae.getSource()==b22)
		{
			p2.setVisible(false);
			p3.setVisible(false);
			p4.setVisible(false);
			p5.setVisible(false);
			p6.setVisible(false);
			p7.setVisible(false);
			p8.setVisible(false);
			p9.setVisible(true);
			p10.setVisible(false);
			p11.setVisible(false);
			p12.setVisible(false);
		}
		
		if(ae.getSource()==b23)
		{
			p2.setVisible(false);
			p3.setVisible(false);
			p4.setVisible(false);
			p5.setVisible(false);
			p6.setVisible(false);
			p7.setVisible(false);
			p8.setVisible(false);
			p9.setVisible(false);
			p10.setVisible(true);
			p11.setVisible(false);
			p12.setVisible(false);
		}
		
		if(ae.getSource()==b14)
		{
			p2.setVisible(true);
			p3.setVisible(false);
			p4.setVisible(false);
			p5.setVisible(false);
			p6.setVisible(false);
			p7.setVisible(false);
			p8.setVisible(false);
			p9.setVisible(false);
			p10.setVisible(false);
			p11.setVisible(false);
			p12.setVisible(false);
		}
		if(ae.getSource()==b1)
		{	
			connect();
			try 
			{
				st=con.createStatement();
				st.executeUpdate("insert into fir values("+Integer.parseInt(tf1.getText())+",'"+tf2.getText()+"','"+tf3.getText()+"','"+tf4.getText()+"','"+tf5.getText()+"','"+(rb3.getState()?rb3.getLabel():rb4.getLabel())+"',"+Integer.parseInt(tf7.getText())+",'"+tf8.getText()+"','"+tf9.getText()+"')");	
				System.out.println("Insertion Successfull ");
				con.close();
			}
			catch(Exception e) {}
		}
		
		if(ae.getSource()==b3)
		{	
			connect();
			try 
			{
				st=con.createStatement();
				rs=st.executeQuery("select * from fir where firno="+tf12.getText());	
				if(rs.next())
				{
					tf13.setText(rs.getString("name"));
					tf14.setText(rs.getString("criminalid"));
					tf15.setText(rs.getString("crime"));
					tf16.setText(rs.getString("date"));
					tf17.setText(rs.getString("address"));
					tf18.setText(rs.getString("aadhar"));				
				}
				else
					tf12.setText("Record Not Found ");
				con.close();
			}
			catch(Exception e) {}
		}
		
		if(ae.getSource()==b4)
		{	
			connect();
			try 
			{
				st=con.createStatement();
				st.executeUpdate("update fir set name='"+tf13.getText()+"',criminalid="+Integer.parseInt(tf14.getText())+",crime='"+tf15.getText()+"',date='"+tf16.getText()+"',address='"+tf17.getText()+"',aadhar='"+tf18.getText()+"' where firno="+tf12.getText());	
				System.out.println("Update Successfull ");
				con.close();
				tf13.setText(" ");
				tf14.setText(" ");
				tf15.setText(" ");
				tf16.setText(" ");
				tf17.setText(" ");
				tf18.setText(" ");
			}
			catch(Exception e) {}
		}
		
		if(ae.getSource()==b5)
		{	
			connect();
			try 
			{
				st=con.createStatement();
				rs=st.executeQuery("select * from fir where firno="+tf19.getText());	
				if(rs.next())
				{
					lab21.setText(rs.getString("name"));
					lab23.setText(rs.getString("criminalid"));
					lab25.setText(rs.getString("crime"));
					lab27.setText(rs.getString("date"));
					lab29.setText(rs.getString("address"));
					lab31.setText(rs.getString("aadhar"));				
				}
				else
					tf19.setText("Record Not Found ");
				con.close();
			}
			catch(Exception e) {}
		}
		
		if(ae.getSource()==b6)
		{
			connect();
			try 
			{
				st=con.createStatement();
				st.executeUpdate("delete from fir where firno="+tf19.getText());
				System.out.println("Deletion Successfull ");
				con.close();
				lab21.setText("");
				lab23.setText("");
				lab25.setText("");
				lab27.setText("");
				lab29.setText("");
				lab31.setText("");
			}
			catch(Exception e) {}
		}
		
		if(ae.getSource()==b7)
		{
			connect();
			try 
			{
				st=con.createStatement();
				rs=st.executeQuery("select * from crimelogger where criminal_id="+tf32.getText());	
				if(rs.next())
				{
					lab34.setText(rs.getString("name"));
					lab36.setText(rs.getString("address"));
					lab38.setText(rs.getString("aadhar"));				
				}
				else
					tf32.setText("Record Not Found ");
				con.close();
			}
			catch(Exception e) {}
		}
		
		if(ae.getSource()==b8)
		{
			connect();
			try 
			{
				st=con.createStatement();
				st.executeUpdate("delete from crimelogger where criminal_id="+tf32.getText());
				System.out.println("Deletion Successfull ");
				con.close();
				lab34.setText("");
				lab36.setText("");
				lab38.setText("");
			}
			catch(Exception e) {}
		}
		
		if(ae.getSource()==b9)
		{	
			connect();
			try 
			{
				st=con.createStatement();
				rs=st.executeQuery("select * from crimelogger where criminal_id="+tf39.getText());	
				if(rs.next())
				{
					tf40.setText(rs.getString("name"));
					tf41.setText(rs.getString("address"));
					tf42.setText(rs.getString("aadhar"));				
				}
				else
					tf39.setText("Record Not Found ");
				con.close();
			}
			catch(Exception e) {}
		}
		
		if(ae.getSource()==b10)
		{	
			connect();
			try 
			{
				st=con.createStatement();
				st.executeUpdate("update crimelogger set name='"+tf40.getText()+"',address='"+tf41.getText()+"',aadhar='"+tf42.getText()+"' where criminal_id="+tf39.getText());	
				System.out.println("Update Successfull ");
				con.close();
				tf40.setText("");
				tf41.setText("");
				tf42.setText("");
			}
			catch(Exception e) {}
		}
		
		if(ae.getSource()==b11)
		{	
			connect();
			try 
			{
				st=con.createStatement();
				st.executeUpdate("insert into crimelogger values("+Integer.parseInt(tf43.getText())+",'"+tf44.getText()+"','"+tf45.getText()+"','"+tf46.getText()+"','"+(rb5.getState()?rb5.getLabel():rb6.getLabel())+"','"+tf48.getText()+"','"+tf49.getText()+"')");	
				System.out.println("Insertion Successfull ");
				con.close();
			}
			catch(Exception e) {}
		}
		
		if(ae.getSource()==b12)
		{	
			connect();
			try 
			{
				st=con.createStatement();
				rs=st.executeQuery("select * from fir where firno="+tf50.getText());	
				if(rs.next())
				{
					lab52.setText(rs.getString("name"));
					lab54.setText(rs.getString("criminalid"));
					lab56.setText(rs.getString("crime"));
					lab58.setText(rs.getString("date"));
					lab60.setText(rs.getString("address"));
					lab62.setText(rs.getString("aadhar"));				
				}
				else
					tf50.setText("Record Not Found ");
				con.close();
			}
			catch(Exception e) {}
		}
		
		if(ae.getSource()==b13)
		{
			connect();
			try 
			{
				st=con.createStatement();
				rs=st.executeQuery("select * from crimelogger where criminal_id="+tf63.getText());	
				if(rs.next())
				{
					lab65.setText(rs.getString("name"));
					lab67.setText(rs.getString("address"));
					lab69.setText(rs.getString("aadhar"));		
				}
				else
					tf63.setText("Record Not Found ");
				con.close();
			}
			catch(Exception e) {}
		}
		
		if(ae.getSource()==b15)
		{
			dispose();
			new LoginWindow();
		}
	}
	
	void connect()
	{
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crimelogger","root","1234");  
			System.out.println("You are Connected ");
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		}  
	}
	
	public static void main(String [] args)
	{
		new Jdbc_file();
	}
}

