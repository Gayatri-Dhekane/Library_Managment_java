import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Book {

	int bid;
	String bname,author;int category;
	
	Connection con;
	Statement st;
	ResultSet rs;
	Book()
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
	Book(int b,String s1,String s2,int i)
	{
		bid=b;
		bname=s1;
		author=s2;
		category=i;
		
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
	void setDetails(int b,String s1,String s2,int i)
	{
		bid=b;
		bname=s1;
		author=s2;
		category=i;
		
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
	
	void getdetails(int bid,String bname,String author,int cat)
	{
//		 Scanner sc=new Scanner(System.in);
//		System.out.print("\nEnter Book id : "); bid=sc.nextInt();
//		 sc=new Scanner(System.in);
//		System.out.print("Enter Book name : "); bname=sc.nextLine();
//		System.out.print("Enter author : "); author=sc.nextLine();
//		
		
		 try {
				//create statement object
				PreparedStatement stmt=con.prepareStatement("insert into Book values(?,?,?,?) on duplicate key update bid=?,bname=?,author=?,category=?");  
			stmt.setInt(1,bid);//1 specifies the first parameter in the query  
			stmt.setString(2,bname); 
			stmt.setString(3, author);
			stmt.setInt(4, cat);
			stmt.setInt(5,bid);//1 specifies the first parameter in the query  
			stmt.setString(6,bname); 
			stmt.setString(7, author);stmt.setInt(8, cat);
			
			int i=stmt.executeUpdate(); 
			
			System.out.println(i+" records inserted..");
			System.out.println("Successful..");
		     
			}catch(SQLException e)
			{
				e.printStackTrace();
				System.out.println("\n\t\t\t\tCan't Register .");
			}
		
		
	}
	 void display()
		{
			System.out.println("-----------------------------------------------");
			System.out.println("Bookid : "+bid); 
			System.out.println("Book name : "+bname); 
			System.out.println("Book author : "+author); 
		}
}
