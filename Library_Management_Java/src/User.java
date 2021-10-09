
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class User 
{
	String  uid,name,passwd,address;
	HashMap<Book,String> ib=new HashMap<Book,String>();
	Connection con;
	Statement st;
	ResultSet rs;
	
	User()
	{
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection object and connection url
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mayasdl","root","root");
			System.out.println("Connection Established");
			
		 }catch(SQLException | ClassNotFoundException e)
		 {
			 System.out.println("Connection can't be esatblished..");
			 e.printStackTrace();
		 }
		 
		
	}
	User(String  uid,String name,String passwd,String address)
	{
		this.uid=uid;this.name=name;
		this.passwd=passwd;
		this.address=address;
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection object and connection url
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mayasdl","root","root");
			System.out.println("Connection Established");
			
		 }catch(SQLException | ClassNotFoundException e)
		 {
			 System.out.println("Connection can't be esatblished..");
			 e.printStackTrace();
		 }
	}
	
	//Register
	
	 void register()
	{
		
		
		 try {
				//create statement object
				PreparedStatement stmt=con.prepareStatement("insert into users values(?,?,?,?)");  
			stmt.setString(1,uid);//1 specifies the first parameter in the query  
			stmt.setString(2,name); 
			stmt.setString(3, passwd);
			stmt.setString(4, address);
			int i=stmt.executeUpdate(); 
			
			System.out.println(i+" records inserted..");
			System.out.println("\n\t\t\t\tRegistration Successful\n\t\t\t\tPress 1 to login..");
		     
			}catch(SQLException e)
			{
				System.out.println("\n\t\t\t\tCan't Register ..Try with another user-id ..");
			}
		
	}
	 //display user
	 void display()
		{
			System.out.println("\n\n-----------------------------------------------");
			System.out.println("Userid : "+uid); 
			System.out.println("Enter Userid : "+name); 
			System.out.println("Enter Userid : "+address); 
		}
	 
	 void DisplayissueBook()
	 {
//		 System.out.println("\n\n");
//			for(Book i:ib.keySet())
//			{
//				System.out.println("Book Name : "+i.bname+"    Date : "+ib.get(i));					
//			}
			try {
				PreparedStatement stmt2=con.prepareStatement("select * from orders where uid=?");
				stmt2.setString(1, uid);
				ResultSet rs=stmt2.executeQuery(); 
				while(rs.next())
				{
				  int bid=rs.getInt("bid");
				  
					try {
						PreparedStatement stmt=con.prepareStatement("select * from book where bid=?");
						stmt.setInt(1, bid);
						ResultSet rs1=stmt.executeQuery(); 
						while(rs1.next())
						{
						System.out.println(rs1.getInt("bid")+"  "+rs1.getString("bname")+"  "+rs1.getString("author"));
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	 
	 
	 
	 
	 
	 //chat
	 
	

}