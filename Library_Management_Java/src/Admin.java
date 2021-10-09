import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Admin  implements ActionListener
{
	String aid,password;
	
	ArrayList<User> users=new ArrayList<User>();
	
	LinkedList<Book> books=new LinkedList<Book>();
	
	
	
	static String newu;
	Connection con;
	Statement st;
	User uu;
	
	 int choice;
	 JFrame f;
	 JButton b, b1,ba,b1a,b2a,signup,addbookb; 
	 JPanel p,p1,p2,pa,p1a,p2a,p3,p4,p4s,addbook,searchbook,updatebook,chatadmin,chatuser;
	 JLabel connect,bgimage,l1,luname,lpasswd,dmsg1,dmsg2;
	 JTextArea uname;
	 JPasswordField passwd;
	 JLabel luname1,lpasswd1,lUsername,lplace;
     JTextArea uname1,Username,place;
     JPasswordField passwd1;
     JButton rb1,rb2,rb3,rb4,rb1s,rb2s,rb3s;  
	  
     JTextArea bookitems; 
 	Book bo;
	
	Admin()
	{
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection object and connection url
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mayasdl","root","root");
			System.out.println("Connection Established");
			
		 }catch(SQLException | ClassNotFoundException e)
		 {
			 System.out.println("Connection can't be esatblished..");
		 }
	}
	
	//
	void createFrame() {
		 //create frame;
		 
		//all panels
		addbook=new JPanel();
		  
		 //frame panel
		 f=new JFrame("Panel");//creating instance of JFrame  
		JPanel p = new JPanel(); 
		JPanel p2 = new JPanel(); 
		
		
		//color and fonts
		 Color c1 = new Color(235, 251, 255); 
		 Font f1 = new Font("TimesRoman",Font.BOLD,25);
		 ImageIcon adminIcon=new ImageIcon("src\\icons\\Admin1.PNG");
		 ImageIcon shopIcon=new ImageIcon("src\\icons\\shop2.PNG");
		 ImageIcon userIcon=new ImageIcon("src\\icons\\user1.PNG");
		 ImageIcon bg=new ImageIcon("src\\icons\\bg12.jpeg");
		 
       JLabel bgimage=new JLabel(bg);
       bgimage.setBounds(0,0,350,550);
		JLabel l1=new JLabel("LIBRARY MANAGMENT SYSTEM"); 
		JLabel l2=new JLabel(" WELCOME ");
		l1.setFont(f1);
		l2.setFont(f1);
		l1.setBounds(20,10,820,120);
		l2.setBounds(150,50,820,140);
		
		
		 b = new JButton(adminIcon); 
		 b.setText(" ADMIN");
	     b1 = new JButton(shopIcon);  b1.setText("STUDENT");
	    // b2 = new JButton(userIcon);  b2.setText("CUSTOMER");
	     b.setBounds(150,180,170,50);
	     b1.setBounds(150,280,170,50);
	    // b2.setBounds(150,380,170,50);
	     b.addActionListener(this); b1.addActionListener(this); //b2.addActionListener(this);
	     Border blackline = BorderFactory.createLineBorder(Color.black);
		
	     
		p2.add(l1);
		p2.add(l2);
		p2.add(b); 
       p2.add(b1); 
      // p2.add(b2); 
       p.add(bgimage);
       p.setBackground(Color.black); 
       p2.setBackground(c1);
       f.add(p); 
       p.setSize(350,550);
       p.setBorder(blackline); p2.setBorder(blackline);
       p2.setBounds(350, 0, 500, 550);  
       f.add(p2); 
		  
       p.setLayout(null);p2.setLayout(null);
		f.setSize(850,550);//400 width and 500 height  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible  
		
	}
	
	void loginSignup()
	{
		 f=new JFrame("LOGIN REGISTER");
		 pa = new JPanel(); 
		 p1a = new JPanel(); 
		 p2a = new JPanel(); 
		 p3=new JPanel();
		
		//color and fonts
		 Color c1 = new Color(235, 251, 255); 
		 Color c2=new Color(17, 240, 245);
		 Color c3=new Color(15, 60, 61);
		 Color c4=new Color(11, 167, 219);
		 Font f1 = new Font("TimesRoman",Font.BOLD,25);
//		 ImageIcon adminIcon=new ImageIcon("F:\\TE SEM 1\\SDL\\icons\\Admin1.PNG");
//		 ImageIcon shopIcon=new ImageIcon("F:\\TE SEM 1\\SDL\\icons\\shop2.PNG");
//		 ImageIcon userIcon=new ImageIcon("F:\\TE SEM 1\\SDL\\icons\\user1.PNG");
		 ImageIcon bg=new ImageIcon("F:\\TE SEM 1\\SDL\\icons\\c7.jpg");
		 Border blackline = BorderFactory.createLineBorder(Color.black);
		 Font  f2  = new Font(Font.SANS_SERIF,  Font.BOLD, 20);
		
		 //login
		 ImageIcon backi=new ImageIcon("src\\icons\\back.png");
		 JButton back=new JButton(backi);
		 back.setBounds(5,5,20,20);
		 back.addActionListener(new ActionListener() {@Override
		public void actionPerformed(ActionEvent e) {

			 f.dispose();
			 createFrame();
			
		}});
		 
		
		dmsg1=new JLabel();
		//dmsg1.setBorder(blackline);
	    dmsg1.setFont(f2);
	    dmsg2=new JLabel();
		//dmsg2.setBorder(blackline);
	    dmsg2.setFont(f2);
		
        bgimage=new JLabel(bg);
       bgimage.setBounds(0,0,350,550);
		 l1=new JLabel("LOGIN CUSTOMER"); 
	
		l1.setFont(f1);
	
		l1.setBounds(20,10,820,120);
		
		 luname=new JLabel("UserName"); lpasswd=new JLabel("Password");
		 uname=new JTextArea(1,20);	
		 passwd=new JPasswordField (20);	
		luname.setBounds(100, 20, 200, 25);
		lpasswd.setBounds(100,110, 200, 25);
		 uname.setBounds(100,50,200,25);
		 passwd.setBounds(100,140,200,25);
		 dmsg1.setBounds(100,250,200,25);
		 dmsg2.setBounds(100,300,200,25);
		 
		 uname.setBorder(blackline);
		 uname.setFont(f2);
		 passwd.setBorder(blackline);
		 passwd.setFont(f2);
    
		 ba = new JButton("SignIn"); 
		
	     b1a = new JButton("SignUp"); 
	     b2a = new JButton("LOGIN");
	     ba.setBounds(270,60,100,30);
	     b1a.setBounds(350,60,100,30);
	     b2a.setBounds(140,200,120,30);
	    b2a.setBackground(c2);
	     	  
	    if(choice==1)
	       {
	    	   p3.hide();
				b1a.hide();
	       }
	    
	 
	     ba.setBackground(c2);
	     b1a.setBackground(c3);
	     ba.setForeground(c3);
	     b1a.setForeground(c4);
	     b1a.addActionListener(this);  
	     ba.addActionListener(this);  
	     b2a.addActionListener(this); 
	     
	    
	     
	     //sign up
	    
	         luname1=new JLabel("User ID"); lpasswd1=new JLabel("Password");
			 uname1=new JTextArea(1,20);
			 lUsername=new JLabel("User Name");
			 lplace=new JLabel("Place");
			 place=new JTextArea(1,20);
			 Username=new JTextArea(1,20);
			 passwd1=new JPasswordField (20);	
		   
			luname1.setBounds(100, 20, 200, 25);
			lpasswd1.setBounds(100,80, 200, 25);
			lUsername.setBounds(100,140, 200, 25);
			lplace.setBounds(100,200,200,25);
			
			 uname1.setBounds(100,50,200,25);
			 passwd1.setBounds(100,110,200,25);
			 Username.setBounds(100,170,200,25);
			 place.setBounds(100,230,200,25);
			 uname1.setBorder(blackline);
			 uname1.setFont(f2);
			 passwd1.setBorder(blackline);
			 passwd1.setFont(f2);
			 Username.setBorder(blackline);
			 Username.setFont(f2);
			 place.setBorder(blackline);
			 place.setFont(f2);
			 
	     
			 
		     signup = new JButton("REGISTER");
		    
		     signup.setBounds(140,270,120,30);
		     signup.setBackground(c2);
		     signup.addActionListener(this);
		     	   
		    
		 
		     //end
	    
	     //add into panels
		     //p2
		p2a.add(l1);
		p2a.add(ba); 
       p2a.add(b1a); 
       p2a.add(back);
       
       //p1
       p1a.add(luname);p1a.add(uname);p1a.add(lpasswd);p1a.add(passwd);p1a.add(b2a);
       p1a.add(dmsg1);
       //p3
       p3.add(luname1);p3.add(uname1);p3.add(lpasswd1);p3.add(passwd1);
       p3.add(lUsername);p3.add(Username);p3.add(lplace);p3.add(place);
       p3.add(signup);p3.add(dmsg2);
       
       //p
       
       pa.add(bgimage);
       pa.setBackground(Color.black); 
       p2a.setBackground(c1); p1a.setBackground(c1); p3.setBackground(c1);
       p1a.setBounds(0, 150, 500, 550);
       p3.setBounds(0, 150, 500, 550);
       f.add(pa); 
       p2a.add(p1a);
       p2a.add(p3);
       pa.setSize(350,550);
       pa.setBorder(blackline); p2a.setBorder(blackline);//p3.setBorder(blackline);p1.setBorder(blackline);
       p2a.setBounds(350, 0, 500, 550);  
       f.add(p2a); 
		  
       pa.setLayout(null);p2a.setLayout(null);p1a.setLayout(null);p3.setLayout(null);
       p3.setVisible(false);
       
      
		f.setSize(850,550);//400 width and 500 height  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible  
		
	}
	@SuppressWarnings("deprecation")
	void adminFunctions()
	{
		//"\n1.Add book\n\2.search book.\n3.update book details.\n4.Chat with student\n5.Receive ack\n6.Back to main menu.\n"
		p2a.hide();

	   
		p4=new JPanel(); 
		 Color c1 = new Color(235, 251, 255); 
		p4.setBackground(c1);
		//border fonts
		 Border blackline = BorderFactory.createLineBorder(Color.black);
		 Font  f2  = new Font(Font.SANS_SERIF,  Font.BOLD, 16);
		 Font  f3  = new Font(Font.SANS_SERIF,  Font.BOLD, 14);
		
		 Color c2=new Color(17, 240, 245);
		 Color c3=new Color(15, 60, 61);
		 Color c4=new Color(11, 167, 219);
		 ImageIcon backi=new ImageIcon("src\\icons\\back.png");
		 JButton back=new JButton(backi);
		 back.setBounds(5,5,20,20);
		 back.addActionListener(new ActionListener() {@Override
		public void actionPerformed(ActionEvent e) {
			
			 p4.hide();
			 p2a.show();


		}});
		 
		System.out.println("Created panel..");
		rb1=new JButton("Add Book");    
		rb1.setBounds(50,350,150,30);      
		rb2=new JButton("Search Book");    
		rb2.setBounds(250,350,150,30);
		rb3=new JButton("Update book");    
		rb3.setBounds(250,400,150,30); 
		rb4=new JButton("Chat-student");   
		rb4.setBounds(50,400,150,30); 
		rb1.addActionListener(this);rb2.addActionListener(this);
		rb3.addActionListener(this);rb4.addActionListener(this);
		  
		bookitems=new JTextArea("");
		bookitems.setBounds(50,50,350,270);  
		bookitems.setFont(f3);
		bookitems.setEditable(false);
		
		displayAllBooks();
		   
		rb1.setBorder(blackline);
		rb1.setFont(f2);
		rb2.setBorder(blackline);
		rb2.setFont(f2);
		rb3.setBorder(blackline);
		rb3.setFont(f2);
		rb4.setBorder(blackline);
		rb4.setFont(f2);
		rb1.setBackground(c2);rb2.setBackground(c2);rb3.setBackground(c2);rb4.setBackground(c2);
		System.out.println("Created button..");
		p4.add(rb1);p4.add(rb2);p4.add(rb3);p4.add(rb4);p4.add(bookitems);p4.add(back);
		p4.setVisible(true);
		p4.setLayout(null);
		  p4.setBounds(350, 0, 500, 550); 
		System.out.println("Created layoutssss..");
		f.getContentPane().add(p4);
		System.out.println("ADDDEDDDDD");
		
				
	}
	@SuppressWarnings("deprecation")
	void studFunctions()
	{
		//"\n1.Add book\n\2.search book.\n3.update book details.\n4.Chat with student\n5.Receive ack\n6.Back to main menu.\n"
		p2a.hide();

	   
		p4s=new JPanel(); 
		//border fonts
		 Border blackline = BorderFactory.createLineBorder(Color.black);
		 Font  f2  = new Font(Font.SANS_SERIF,  Font.BOLD, 16);
		 Font  f3  = new Font(Font.SANS_SERIF,  Font.BOLD, 14);
		
		 Color c2=new Color(17, 240, 245);
		 Color c3=new Color(15, 60, 61);
		 Color c4=new Color(11, 167, 219);
		 
		 Color c1 = new Color(235, 251, 255); 
			p4s.setBackground(c1);
		 ImageIcon backi=new ImageIcon("src\\icons\\back.png");
		 JButton back=new JButton(backi);
		 back.setBounds(5,5,20,20);
		 back.addActionListener(new ActionListener() {@Override
		public void actionPerformed(ActionEvent e) {
			
			 p4s.hide();
			 p2a.show();


		}});
		 
		System.out.println("Created panel..");
		rb1s=new JButton("Issue Book");    
		rb1s.setBounds(50,350,150,30);      
		rb2s=new JButton("Return Book");    
		rb2s.setBounds(250,350,150,30);
		rb3s=new JButton("Chat-Admin");    
		rb3s.setBounds(150,400,150,30); 
		
		rb1s.addActionListener(this);rb2s.addActionListener(this);
		rb3s.addActionListener(this);
		  
		bookitems=new JTextArea("");
		bookitems.setBounds(50,50,350,270);  
		bookitems.setFont(f3);
		bookitems.setEditable(false);
		
		displayAllBooks();
		   
		rb1s.setBorder(blackline);
		rb1s.setFont(f2);
		rb2s.setBorder(blackline);
		rb2s.setFont(f2);
		rb3s.setBorder(blackline);
		rb3s.setFont(f2);
		
		rb1s.setBackground(c2);rb2s.setBackground(c2);rb3s.setBackground(c2);
		System.out.println("Created button..");
		p4s.add(rb1s);p4s.add(rb2s);p4s.add(rb3s);p4s.add(bookitems);p4s.add(back);
		p4s.setVisible(true);
		p4s.setLayout(null);
		  p4s.setBounds(350, 0, 500, 550); 
		System.out.println("Created layoutssss..");
		f.getContentPane().add(p4s);
		System.out.println("ADDDEDDDDD");
		
				
	}
	
	public void actionPerformed(ActionEvent e){  

		if(e.getSource()==b)//admin
		{
			choice= 1;
			System.out.println("1");
			f.dispose();
			
			loginSignup();
			
		}
		if(e.getSource()==b1)//student
		{
			choice= 2;
			System.out.println("2");
			f.dispose();
			loginSignup();
		}
		
		if(e.getSource()==ba)//signin up
		{
			p1a.setVisible(true);
			p3.setVisible(false);
		
		}
		if(e.getSource()==b1a)//signup up
		{
			p1a.setVisible(false);
			p3.setVisible(true);
			
		}
		if(e.getSource()==b2a)//login button
		{
			if(choice==2) {
			String u=uname.getText();
			@SuppressWarnings("deprecation")
			String p=passwd.getText();
			//String pp=p.toString();
			System.out.println(u+" "+p);
			 uu=searchUser(u,p);
			if(uu==null)
			{
				//fail
				System.out.println("LOGIN FAILED");
				dmsg1.setText("LOGIN FAILED");
			}else
			{
				//proceed
				System.out.println("LOGIN Successful");
				dmsg1.setText("LOGIN SUCCESSFUL");
				studFunctions();
			
			}
			}
			else  if(choice==1) {
				String u=uname.getText();
				@SuppressWarnings("deprecation")
				String p=passwd.getText();
				//String pp=p.toString();
				System.out.println(u+" "+p);
				boolean uu=login(u,p);
				if(uu==false)
				{
					//fail
					System.out.println("LOGIN FAILED");
					dmsg1.setText("LOGIN FAILED");
				}else
				{
					//proceed
					System.out.println("LOGIN Successful");
					dmsg1.setText("LOGIN SUCCESSFUL");
					adminFunctions();
				}
				}
			
			
		}
		if(e.getSource()==signup) //sign up
		{
			
				String u=uname1.getText();
				@SuppressWarnings("deprecation")
				String p=passwd1.getText();
				String un=Username.getText();
				String pl=place.getText();
				
				try {
					registerUser(u,p,un,pl);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		}
		if(e.getSource()==rb1)
		{
			addBook();
		}
		if(e.getSource()==rb2)
		{
			searchBook();
		}
		if(e.getSource()==rb3)
		{
			updateBook();
		}
		if(e.getSource()==rb4)
		{
			try {
				chatAdmin();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==rb1s)
		{
			try {
				issueBook(uu);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==rb2s)
		{
			//return book
			returnBook(uu);
		}
		if(e.getSource()==rb3s)
		{
			//issueBook();
			try {
				chatStud(uu);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
}  
	
	//login admin
	boolean login(String aid,String passwd)
	{
	   System.out.println(aid+"     "+passwd);	
		if(aid.equals("a") && passwd.equals("a"))
		{
			//System.out.println("\n\t\t\t\t<<<<<< LOGIN SUCCESSFUL >>>>>>");
			return true;
		}else return false;
	}
	//Register user
	
	void registerUser(String u,String p,String un,String pl) throws ClassNotFoundException, SQLException
	{
		User u1=new User(u,un,p,pl);
		u1.register();
		//users.add(u);		
		
	}
	
	
	//display all registered users.
	void displayUsers()
	{
		System.out.println("\n\n------------- U S E R S -------------------");

		
		try {
			PreparedStatement stmt2=con.prepareStatement("select * from users");
			ResultSet rs=stmt2.executeQuery(); 
			while(rs.next())
			{
			System.out.println("\t\t\t\t\t\t"+rs.getString("uid")+"  "+" "+rs.getString("uname")+" "+" "+rs.getString("address"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n---------------------------------------");
		
	}
	
		
		//login user
	User searchUser(String uid,String passwd)
	{
		System.out.println("In search user function..");
		try {
			//create statement object
		PreparedStatement stmt=con.prepareStatement("select uid,uname,passwd,address from users where uid=?");  
		stmt.setString(1,uid);//1 specifies the first parameter in the query  

		User u;
		ResultSet rs=stmt.executeQuery(); 
		if(rs.next())
		{
		 u=new User(rs.getString("uid"),rs.getString("uname"),rs.getString("passwd"),rs.getString("address"));
		 if(passwd.equals(u.passwd))
		        return u;
		    else {
		    	System.out.println("Password does't match...");
		    	return null;
		    }
		
		}	
		else {
			System.out.println("NOT FOUND..");
			return null;
		}
	     
		}catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("SQLEXCEPTION");
			return null;
		}
		
	}
	
	
		
	
	//add book;
	void addBook()
	{
		
	    Book b=new Book();
	    
	    //gui
	  //border fonts
		 Border blackline = BorderFactory.createLineBorder(Color.black);
		 Font  f2  = new Font(Font.SANS_SERIF,  Font.BOLD, 16);
	    
	    addbook=new JPanel();
	    p4.hide();
	    Color c1 = new Color(235, 251, 255); 
	    addbook.setBackground(c1);
	    ImageIcon backi=new ImageIcon("src\\icons\\back.png");
		 JButton back=new JButton(backi);
		 back.setBounds(5,5,20,20);
		 back.addActionListener(new ActionListener() {@Override
		public void actionPerformed(ActionEvent e) {
			
			 addbook.hide();
			 p4.show();


		}});
		 
	    
	    JLabel bookid,bookname,author;
	    JTextField bookidt,booknamet,authort;
	    
	    bookid=new JLabel("Book ID:");
	    bookidt=new JTextField(20);
	    bookname=new JLabel("Book Name:");
	    booknamet=new JTextField(20);
	    author=new JLabel("Author:");
	    authort=new JTextField(20);
	    
	    
	    bookid.setBounds(50, 50, 200, 30);
	    bookidt.setBounds(50, 80, 200, 30);
	    bookname.setBounds(50, 110, 200, 30);
	    booknamet.setBounds(50, 140, 200, 30);
	    author.setBounds(50, 170, 200, 30);
	    authort.setBounds(50, 200, 200, 30);
	    bookidt.setFont(f2);booknamet.setFont(f2);authort.setFont(f2);
	    bookidt.setBorder(blackline);booknamet.setBorder(blackline);authort.setBorder(blackline);
	    
	    JLabel categories=new JLabel("Select Category:");
	    categories.setBounds(50,230,200,30);
	    JRadioButton rb1,rb2,rb3; 
	    rb1=new JRadioButton("Programming");    
		rb1.setBounds(80,260,200,30);      
		rb2=new JRadioButton("Historical");    
		rb2.setBounds(80,290,200,30);
		rb3=new JRadioButton("Comic");    
		rb3.setBounds(80,320,200,30); 
		
		ButtonGroup bg=new ButtonGroup();    
		bg.add(rb1);bg.add(rb2); bg.add(rb3);
		addbookb=new JButton("ADD BOOK");    
		addbookb.setBounds(130,360,100,30);
		 JLabel info=new JLabel("");
		    info.setBounds(50,430,200,30);
	    
		addbook.add(bookid);addbook.add(bookidt);addbook.add(bookname);addbook.add(booknamet);
		addbook.add(author);addbook.add(authort);
		addbook.add(categories);addbook.add(rb1);addbook.add(rb2);addbook.add(rb3);addbook.add(addbookb);
		addbook.add(info);addbook.add(back);
		addbook.setVisible(true);
		addbook.setLayout(null);
		addbook.setBounds(350, 0, 500, 550); 
		System.out.println("Created layoutssss..");
		f.getContentPane().add(addbook);

	    //end
	    addbookb.addActionListener(new ActionListener() {
	    				
			@Override
			public void actionPerformed(ActionEvent e) {
				int cat;
				if(rb1.isSelected()) cat=1;
				if(rb2.isSelected()) cat=2;
				if(rb3.isSelected()) cat=3;
				else cat=1;
				
				// TODO Auto-generated method stub
				//book
				try {
				int id=Integer.parseInt(bookidt.getText());
			    b.getdetails(id,booknamet.getText(),authort.getText(),cat);
			  //  books.add(b);	
			    info.setText("Book added..");
			 displayAllBooks();
				//
				}catch(NumberFormatException | NullPointerException ee)
				{
					info.setText("Enter valid data..");
				}
			}
		});
	   
	}
	//display books
	void displayAllBooks()
	{
//		for(int i=0;i<books.size();i++)
//		{
//			
//			books.get(i).display();
//			System.out.println("catagory:"+books.get(i).category);
//		}	
		System.out.println("-----------ALL BOOKS------------\n");
		 try {
				//create statement object
				PreparedStatement stmt=con.prepareStatement("select * from book");  
		
			
			ResultSet rs=stmt.executeQuery(); 
			String str="";
			bookitems.setText("Book-id     Book-Name     Author\n");
			while(rs.next())
			{
				str=rs.getInt("bid")+"  "+rs.getString("bname")+"  "+rs.getString("author");
				bookitems.append(str+"\n");
			}
			
					     
			}catch(SQLException e)
			{
				e.printStackTrace();
				System.out.println("\n\t\t\t\tCan't Register ..Try with another user-id ..");
			}
	}
	//search book details
	void searchBook()
	{
		
		//layout
		searchbook=new JPanel();
		p4.hide();
		
		bo=new Book();
	
		JLabel bookid=new JLabel("Book ID");
		JTextField bookidt=new JTextField(20);
		bookid.setBounds(50, 110, 200, 30);
		bookidt.setBounds(50, 140, 200, 30);
		
		  Color c1 = new Color(235, 251, 255); 
		    searchbook.setBackground(c1);
		JButton search=new JButton("SEARCH");
		search.setBounds(200,200,100,30);
		
		JLabel info=new JLabel("hii");
		info.setBounds(50, 250, 300, 30);
		
		 ImageIcon backi=new ImageIcon("src\\icons\\back.png");
		 JButton back=new JButton(backi);
		 back.setBounds(5,5,20,20);
		 back.addActionListener(new ActionListener() {@Override
		public void actionPerformed(ActionEvent e) {
			
			 searchbook.hide();
			 p4.show();


		}});
		
		
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				 try {
					 int  bid;
					 bid=Integer.parseInt(bookidt.getText());
						//create statement object
						PreparedStatement stmt=con.prepareStatement("select * from book where bid=?");  
				
					stmt.setInt(1, bid);
					ResultSet rs=stmt.executeQuery(); 
					
					if(rs.next())
					{
						bo.setDetails(rs.getInt("bid"),rs.getString("bname"),rs.getString("author"),rs.getInt("category"));
						System.out.println(rs.getInt("bid")+"  "+rs.getString("bname")+"  "+rs.getString("author"));
						
						info.setText("Book Found Book-id: "+bo.bid+" Book name: "+bo.bname);
						
					}
					else
					{
						info.setText("Book not Found");
					}    
					}catch(SQLException ee)
					{
						ee.printStackTrace();
						
						info.setText("Book not Found");
						
					}
				//
			}
		});
		
		searchbook.add(bookid);searchbook.add(bookidt);searchbook.add(search);searchbook.add(info);
		searchbook.add(back);
		
		searchbook.setVisible(true);
		searchbook.setLayout(null);
		searchbook.setBounds(350, 0, 500, 550); 
		System.out.println("Created layoutssss..");
		f.getContentPane().add(searchbook);
		//end 
		
		
		
	}
	
	//update book details
		void updateBook()
		{
			//layout
			
			p4.hide();
			
			//search book
			searchbook=new JPanel();
			p4.hide();
			
			bo=new Book();
		
			JLabel bookid=new JLabel("Book ID");
			JTextField bookidt=new JTextField(20);
			bookid.setBounds(50, 110, 200, 30);
			bookidt.setBounds(50, 140, 200, 30);
			
			  Color c1 = new Color(235, 251, 255); 
			    searchbook.setBackground(c1);
			
			JButton search=new JButton("SEARCH");
			search.setBounds(200,200,100,30);
			
			JLabel info=new JLabel("hii");
			info.setBounds(50, 250, 300, 30);
			
			 ImageIcon backi=new ImageIcon("src\\icons\\back.png");
			 JButton back=new JButton(backi);
			 back.setBounds(5,5,20,20);
			 back.addActionListener(new ActionListener() {@Override
			public void actionPerformed(ActionEvent e) {
				
				 searchbook.hide();
				 p4.show();


			}});
			
			
			search.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					 try {
						 int  bid;
						 bid=Integer.parseInt(bookidt.getText());
							//create statement object
							PreparedStatement stmt=con.prepareStatement("select * from book where bid=?");  
					
						stmt.setInt(1, bid);
						ResultSet rs=stmt.executeQuery(); 
						
						if(rs.next())
						{
							bo.setDetails(rs.getInt("bid"),rs.getString("bname"),rs.getString("author"),rs.getInt("category"));
							System.out.println(rs.getInt("bid")+"  "+rs.getString("bname")+"  "+rs.getString("author"));
							
							info.setText("Book Found Book-id: "+bo.bid+" Book name: "+bo.bname);
							
							//update book
							 Book b=new Book();
							    
							    //gui
							  //border fonts
								 Border blackline = BorderFactory.createLineBorder(Color.black);
								 Font  f2  = new Font(Font.SANS_SERIF,  Font.BOLD, 16);
							    
							    addbook=new JPanel();
							    searchbook.hide();
							    Color c1 = new Color(235, 251, 255); 
							    addbook.setBackground(c1);
							    
							    JLabel bookid,bookname,author;
							    JTextField bookidt,booknamet,authort;
							    
							    bookid=new JLabel("Book ID:");
							    bookidt=new JTextField(String.valueOf(bo.bid),20);
							    bookname=new JLabel("Book Name:");
							    booknamet=new JTextField(bo.bname,20);
							    author=new JLabel("Author:");
							    authort=new JTextField(bo.author,20);
							    
							    
							    bookid.setBounds(50, 50, 200, 30);
							    bookidt.setBounds(50, 80, 200, 30);
							    bookname.setBounds(50, 110, 200, 30);
							    booknamet.setBounds(50, 140, 200, 30);
							    author.setBounds(50, 170, 200, 30);
							    authort.setBounds(50, 200, 200, 30);
							    bookidt.setFont(f2);booknamet.setFont(f2);authort.setFont(f2);
							    bookidt.setBorder(blackline);booknamet.setBorder(blackline);authort.setBorder(blackline);
							    
							    JLabel categories=new JLabel("Select Category:");
							    categories.setBounds(50,230,200,30);
							    JRadioButton rb1,rb2,rb3; 
							    rb1=new JRadioButton("Programming");    
								rb1.setBounds(80,260,200,30);      
								rb2=new JRadioButton("Historical");    
								rb2.setBounds(80,290,200,30);
								rb3=new JRadioButton("Comic");    
								rb3.setBounds(80,320,200,30); 
								
								ButtonGroup bg=new ButtonGroup();    
								bg.add(rb1);bg.add(rb2); bg.add(rb3);
								addbookb=new JButton("UPDATE");    
								addbookb.setBounds(130,360,100,30);
								 JLabel info=new JLabel("");
								    info.setBounds(50,430,200,30);
								    
								    ImageIcon backi=new ImageIcon("F:\\TE SEM 1\\SDL\\icons\\back.png");
									 JButton back=new JButton(backi);
									 back.setBounds(5,5,20,20);
									 back.addActionListener(new ActionListener() {@Override
									public void actionPerformed(ActionEvent e) {
										
										 addbook.hide();
										 p4.show();


									}});
							    
								addbook.add(bookid);addbook.add(bookidt);addbook.add(bookname);addbook.add(booknamet);
								addbook.add(author);addbook.add(authort);
								addbook.add(categories);addbook.add(rb1);addbook.add(rb2);addbook.add(rb3);addbook.add(addbookb);
								addbook.add(info);addbook.add(back);
								addbook.setVisible(true);
								addbook.setLayout(null);
								addbook.setBounds(350, 0, 500, 550); 
								System.out.println("Created layoutssss..");
								f.getContentPane().add(addbook);

							    //end
							    addbookb.addActionListener(new ActionListener() {
							    				
									@Override
									public void actionPerformed(ActionEvent e) {
										int cat=0;
										if(rb1.isSelected()) cat=1;
										if(rb2.isSelected()) cat=2;
										if(rb3.isSelected()) cat=3;
										
										// TODO Auto-generated method stub
										//book
										try {
										int id=Integer.parseInt(bookidt.getText());
									    b.getdetails(id,booknamet.getText(),authort.getText(),cat);
									 //   books.add(b);	
									    
									   
									    
									    try {
											//create statement object
											PreparedStatement stmt=con.prepareStatement("update book set category=? where bid=?");  
										stmt.setInt(1,cat);//1 specifies the first parameter in the query  
										stmt.setInt(2,b.bid); 
										
										int i=stmt.executeUpdate(); 
										
										System.out.println(i+" records updated..");
										System.out.println("Successful");
										System.out.println("updated..");
										info.setText("updated..");
										 displayAllBooks();
									     
										}catch(SQLException ee)
										{
											ee.printStackTrace();
											System.out.println("\n\t\t\t\tCan't Register ..Try with another user-id ..");
										}
										//
										}catch(NumberFormatException | NullPointerException ee)
										{
											info.setText("Enter valid data..");
										}
									}
								});
							  
							
							//end
							
						}
						else
						{
							info.setText("Book not Found");
						}    
						}catch(SQLException ee)
						{
							ee.printStackTrace();
							
							info.setText("Book not Found");
							
						}
					//
				}
			});
			
			searchbook.add(bookid);searchbook.add(bookidt);searchbook.add(search);searchbook.add(info);
			searchbook.add(back);
			searchbook.setVisible(true);
			searchbook.setLayout(null);
			searchbook.setBounds(350, 0, 500, 550); 
			System.out.println("Created layoutssss..");
			f.getContentPane().add(searchbook);
			//end 
			
			//
		}
	
		//issue book 
		
		void issueBook(User u)throws Exception
		{
		
			System.out.println("All books..");					
			
			System.out.println(u.uid);
			
				
				//
				searchbook=new JPanel();
				p4s.hide();
				
				bo=new Book();
			
				JLabel bookid=new JLabel("Book ID");
				JTextField bookidt=new JTextField(20);
				bookid.setBounds(50, 110, 200, 30);
				bookidt.setBounds(50, 140, 200, 30);
				  Color c1 = new Color(235, 251, 255); 
				    searchbook.setBackground(c1);
				
				JButton search=new JButton("SEARCH");
				search.setBounds(200,200,100,30);
				
				JLabel info=new JLabel("hii");
				info.setBounds(50, 250, 300, 30);
				
				 ImageIcon backi=new ImageIcon("src\\icons\\back.png");
				 JButton back=new JButton(backi);
				 back.setBounds(5,5,20,20);
				 back.addActionListener(new ActionListener() {@Override
				public void actionPerformed(ActionEvent e) {
					
					 searchbook.hide();
					 p4s.show();


				}});
				
				
				search.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						 try {
							 int  bid;
							 bid=Integer.parseInt(bookidt.getText());
								//create statement object
								PreparedStatement stmt=con.prepareStatement("select * from book where bid=?");  
						
							stmt.setInt(1, bid);
							ResultSet rs=stmt.executeQuery(); 
							
							if(rs.next())
							{
								bo.setDetails(rs.getInt("bid"),rs.getString("bname"),rs.getString("author"),rs.getInt("category"));
								System.out.println(rs.getInt("bid")+"  "+rs.getString("bname")+"  "+rs.getString("author"));
								
								info.setText("Book Found Book-id: "+bo.bid+" Book name: "+bo.bname);
								
							}
							else
							{
								info.setText("Book not Found");
							}    
							}catch(SQLException ee)
							{
								ee.printStackTrace();
								
								info.setText("Book not Found");
								
							}
						
						 try {
								//create statement object
								PreparedStatement stmt=con.prepareStatement("insert into Orders(uid,bid) values(?,?)");  
							stmt.setString(1,u.uid);//1 specifies the first parameter in the query  
							stmt.setInt(2,bo.bid); 
							System.out.println("bid"+bo.bid);
							
							int i=stmt.executeUpdate(); 							
							System.out.println(i+" records inserted..");
							System.out.println("Successful..");
							System.out.println("Book Issued..");
							info.setText("Book issued");
						     
							}catch(SQLException ee)
							{
								ee.printStackTrace();
								System.out.println("\n\t\t\t\tCan't issue .");
								info.setText("Can't issue..");
							}	
						//
					}
				});
				
				searchbook.add(bookid);searchbook.add(bookidt);searchbook.add(search);searchbook.add(info);
				searchbook.add(back);
				
				searchbook.setVisible(true);
				searchbook.setLayout(null);
				searchbook.setBounds(350, 0, 500, 550); 
				System.out.println("Created layoutssss..");
				f.getContentPane().add(searchbook);
				//end 
				//
		
				
			
		}
		
		void recieveAck()throws Exception
		{
			Socket socket = new Socket("localhost",1111);
			ObjectInputStream intStream = new ObjectInputStream(socket.getInputStream());
			Packet recvPacket = (Packet)intStream.readObject();	
		    System.out.println(recvPacket.message);
		    
		    ObjectOutputStream outStream = new ObjectOutputStream (socket.getOutputStream());
			Packet packet = new Packet("Thanks");
			outStream.writeObject(packet);
		    
		}
		void returnBook(User u)
		{
	System.out.println("All books..");					
			
			System.out.println(u.uid);
			
				
				//
				searchbook=new JPanel();
				p4s.hide();
				
				bo=new Book();
				
				  Color c1 = new Color(235, 251, 255); 
				    searchbook.setBackground(c1);
			
				JLabel bookid=new JLabel("Book ID");
				JTextField bookidt=new JTextField(20);
				bookid.setBounds(50, 110, 200, 30);
				bookidt.setBounds(50, 140, 200, 30);
				
				JButton search=new JButton("SEARCH");
				search.setBounds(200,200,100,30);
				
				JLabel info=new JLabel("hii");
				info.setBounds(50, 250, 300, 30);
				
				 ImageIcon backi=new ImageIcon("src\\icons\\back.png");
				 JButton back=new JButton(backi);
				 back.setBounds(5,5,20,20);
				 back.addActionListener(new ActionListener() {@Override
				public void actionPerformed(ActionEvent e) {
					
					 searchbook.hide();
					 p4s.show();


				}});
				
				
				search.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						 try {
							 int  bid;
							 bid=Integer.parseInt(bookidt.getText());
								//create statement object
								PreparedStatement stmt=con.prepareStatement("select * from book where bid=?");  
						
							stmt.setInt(1, bid);
							ResultSet rs=stmt.executeQuery(); 
							
							if(rs.next())
							{
								bo.setDetails(rs.getInt("bid"),rs.getString("bname"),rs.getString("author"),rs.getInt("category"));
								System.out.println(rs.getInt("bid")+"  "+rs.getString("bname")+"  "+rs.getString("author"));
								
								info.setText("Book Found Book-id: "+bo.bid+" Book name: "+bo.bname);
								
							}
							else
							{
								info.setText("Book not Found");
							}    
							}catch(SQLException ee)
							{
								ee.printStackTrace();
								
								info.setText("Book not Found");
								
							}
						
						 try {
								//create statement object
								PreparedStatement stmt=con.prepareStatement("delete from Orders where bid=?");  
							stmt.setInt(1,bo.bid);//1 specifies the first parameter in the query  
							
							
							int i=stmt.executeUpdate(); 
							if(i==1) {
							
							System.out.println(i+" records deleted..");
							System.out.println("Successful..");
							System.out.println("Book retured..");
							info.setText("Book returned back.");
							}else
							{
								info.setText("Book not issued..");
							}
						     
							}catch(SQLException ee)
							{
								ee.printStackTrace();
								System.out.println("\n\t\t\t\tCan't return .");
								info.setText("Can't return ");
							}
						
				
						//
					}
				});
				
				searchbook.add(bookid);searchbook.add(bookidt);searchbook.add(search);searchbook.add(info);
				searchbook.add(back);
				
				searchbook.setVisible(true);
				searchbook.setLayout(null);
				searchbook.setBounds(350, 0, 500, 550); 
				System.out.println("Created layoutssss..");
				f.getContentPane().add(searchbook);
				//end 
				//
		
				
				
			
			
			
		}
		void chatAdmin() throws Exception
		{
				
			//chatadmin gui
			chatadmin=new JPanel();
			p4.hide();
			  Color c1 = new Color(235, 251, 255); 
			    chatadmin.setBackground(c1);
			 Font  f3  = new Font(Font.SANS_SERIF,  Font.BOLD, 14);
			 Border blackline = BorderFactory.createLineBorder(Color.black);
			 Font  f2  = new Font(Font.SANS_SERIF,  Font.BOLD, 20);
			 

			 ImageIcon backi=new ImageIcon("src\\icons\\back.png");
			 JButton back=new JButton(backi);
			 back.setBounds(5,5,20,20);
			 back.addActionListener(new ActionListener() {@Override
			public void actionPerformed(ActionEvent e) {
				
				 chatadmin.hide();
				 p4.show();


			}});
			 
			JTextArea msgall=new JTextArea(30,30);
			
		    msgall.setBounds(50,50,350,270);  
			msgall.setFont(f3);
			msgall.setEditable(false);
			msgall.setBorder(blackline);
			
	        JTextArea sendm=new JTextArea();
			
	        sendm.setBounds(50,400,250,30);  
	        sendm.setFont(f3);
	        sendm.setBorder(blackline);
			
	        JButton send=new JButton("SEND");
	        send.setBounds(310,400,100,30);  
	        send.setFont(f3);
	        
			chatadmin.add(back);		
	        chatadmin.add(msgall); chatadmin.add(sendm); chatadmin.add(send);
			chatadmin.setVisible(true);
			chatadmin.setLayout(null);
			chatadmin.setBounds(350, 0, 500, 550); 
			System.out.println("Created layoutssss..");
			f.getContentPane().add(chatadmin);
			//
			 int PORT = 8134;
			 ServerSocket serversocket = new ServerSocket(PORT);
			 System.out.println("Server is up");
			 Socket socket = serversocket.accept();	
			 ObjectOutputStream outStream = new ObjectOutputStream (socket.getOutputStream());
				ObjectInputStream intStream = new ObjectInputStream(socket.getInputStream());
			
		     send.addActionListener(new ActionListener() {
		    	 
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
		     		String message="";
					System.out.println("Step 1 over");
				//	do{
						
						 Packet recvPcket = (Packet)intStream.readObject();
				         System.out.println("Client:"+recvPcket.message);
				         msgall.append("\nStudent:"+recvPcket.message);
				         System.out.println("Step 1 over Read obj");
					
					//BufferedReader dis= new BufferedReader(new InputStreamReader(System.in));
					System.out.println("Enter your message here: ");
					message = sendm.getText();
					msgall.append("\nYou:"+message);
				
					 Packet packet = new Packet(message);
			    	 outStream.writeObject(packet);
			    	    System.out.println("Step 2 over write obj");
					
				//	}while(!message.equals("bye"));
				
			         serversocket.close();
					}catch(Exception ee)
					{
						ee.printStackTrace();
					}
					sendm.setText("");
				}
			});  
				System.out.println("ALL OVER");
		
	         //serversocket.close();
		}
	
		 void chatStud(User u) throws Exception
		 {
			// System.out.println("\n\n\n This is "+name);
			 int PORT = 8134;
			
			    System.out.println("client is up");
	
			    //chatadmin gui
			chatuser=new JPanel();
			p4s.hide();
			
			  Color c1 = new Color(235, 251, 255); 
			    chatuser.setBackground(c1);
			 Font  f3  = new Font(Font.SANS_SERIF,  Font.BOLD, 14);
			 
			JTextArea msgall=new JTextArea(30,30);
			Border blackline = BorderFactory.createLineBorder(Color.black);
			 Font  f2  = new Font(Font.SANS_SERIF,  Font.BOLD, 20);
			

			 ImageIcon backi=new ImageIcon("src\\icons\\back.png");
			 JButton back=new JButton(backi);
			 back.setBounds(5,5,20,20);
			 back.addActionListener(new ActionListener() {@Override
			public void actionPerformed(ActionEvent e) {
				
				 chatuser.hide();
				 p4s.show();
		}});
			
		    msgall.setBounds(50,50,350,270);  
			msgall.setFont(f3);
			msgall.setEditable(false);
			msgall.setBorder(blackline);
			
	        JTextArea sendm=new JTextArea();
			
	        sendm.setBounds(50,400,250,30);  
	        sendm.setFont(f3);
	        sendm.setBorder(blackline);
			
	        JButton send=new JButton("SEND");
	        send.setBounds(310,400,100,30);  
	        send.setFont(f3);
	     
			chatuser.add(back);		
	     chatuser.add(msgall); chatuser.add(sendm); chatuser.add(msgall);chatuser.add(send);
	     chatuser.setVisible(true);
	     chatuser.setLayout(null);
	     chatuser.setBounds(350, 0, 500, 550); 
			System.out.println("Created layoutssss..");
			f.getContentPane().add(chatuser);
			//
			 //
			 Socket socket = new Socket("localhost",PORT);	
			 ObjectOutputStream outStream = new ObjectOutputStream (socket.getOutputStream());
			 ObjectInputStream intStream = new ObjectInputStream(socket.getInputStream());
			
			 send.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
	      			String message="";
				//	do{
					//BufferedReader dis= new BufferedReader(new InputStreamReader(System.in));
					System.out.println("Enter your message here: ");
					message = sendm.getText();
					msgall.append("\nYou:"+message);

					 Packet packet = new Packet(u.name+":"+message);
					 outStream.writeObject(packet);
					 
					 Packet recvPcket = (Packet)intStream.readObject();
				     System.out.println("Admin:"+recvPcket.message);
					
				     msgall.append("\nAdmin:"+recvPcket.message);
				     
				//	}while(!message.equals("bye"));
					}catch(Exception ee)
					{
						ee.printStackTrace();
					}
					sendm.setText("");
				}
			});
				
				
		 }
	
	
	public static void main(String args[])
	{
		
		Admin a=new Admin(); //aDmin
	
		
		
		System.out.println("\n\n\n_____________________________________________________________\n");
		System.out.println("\tWELCOME TO LIBRARY MANAGMENT SYSTEM");
		System.out.println("_____________________________________________________________\n");
		
		 a.createFrame();

			
	}
		
}