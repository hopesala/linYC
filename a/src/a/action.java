package a,hka;
import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
public class action extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	dbconnection d=new dbconnection();
	Connection t=d.getConnection();
	private String name;
	private String isbn;
	public book target_book;
	private String target_bookIsbn;
	public author target_author;

	public dbconnection getD() {
		return d;
	}
	public void setD(dbconnection d) {
		this.d = d;
	}
	public Connection getT() {
		return t;
	}
	public void setT(Connection t) {
		this.t = t;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public book getTarget_book() {
		return target_book;
	}
	public void setTarget_book(book target_book) {
		this.target_book = target_book;
	}
	public String getTarget_bookIsbn() {
		return target_bookIsbn;
	}
	public void setTarget_bookIsbn(String target_bookIsbn) {
		this.target_bookIsbn = target_bookIsbn;
	}
	public author getTarget_author() {
		return target_author;
	}
	public void setTarget_author(author target_author) {
		this.target_author = target_author;
	}
	public ArrayList<String> getC() {
		return c;
	}
	public void setC(ArrayList<String> c) {
		this.c = c;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> b = new ArrayList<String>();
	public ArrayList<String> c = new ArrayList<String>();
	


	public ArrayList<String> getB() {
		return b;
	}
	public void setB(ArrayList<String> b) {
		this.b = b;
	}
	public String searchauthor() throws SQLException
	 {  
		  int i=0;
		  Statement stmt=t.createStatement();
		  ResultSet set = stmt.executeQuery("select * from author where name=\""+name+"\"");
		  while(set.next())
		  {
			  i=set.getInt(1);
		  Statement stmt1=t.createStatement();
		  ResultSet set1 = stmt1.executeQuery("select * from book where AuthorID=\""+i+"\"");
		  while(set1.next())
		  {
		  b.add(set1.getString(2));
		  }
		  }
		  System.out.println("succeed");
		  

		  return SUCCESS;
		 }
	 
	
	 public String searchbook() throws SQLException
	    {
		 
		 System.out.println("name = "+name);
		 Statement stmt=t.createStatement();
		 ResultSet set2 = stmt.executeQuery("select * from book where Title='"+name+"'");
		 if(set2.next())
		 {
			 target_book = new book();
			 target_book.setISBN(set2.getString(1));
			 target_book.setTitle(set2.getString(2));
			 target_book.setAuthorID(set2.getString(3));
			 target_book.Publisher = set2.getString(4);
			 target_book.PublishDate = set2.getString(5);
			 target_book.Price = set2.getString(6);
			 ResultSet set3 = stmt.executeQuery("select * from author where AuthorID="+target_book.AuthorID);
			 if(set3.next()) {
				 target_author = new author();
				 target_author.Name = set3.getString(2);
				 target_author.Age = set3.getString(3);
				 target_author.Country = set3.getString(4);
			 }
		 }
		 return SUCCESS;		 	    	
	    }
	 public String deletebook() throws SQLException
	 {
		 if(target_bookIsbn==null)
			 System.out.println("isbn is null");
		 System.out.println("!"+target_bookIsbn);
		 Statement stmt=t.createStatement();
		 stmt.executeUpdate("delete from book where ISBN=\"" + target_bookIsbn+"\";");
		 return SUCCESS;
	 }
}
   