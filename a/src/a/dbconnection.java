package a;

import java.sql.*;



public class dbconnection {
	private Connection con =null;
	public dbconnection() 
	{
		try{   
		    //加载MySql的驱动类   
		    Class.forName("com.mysql.jdbc.Driver") ;   
		    }catch(ClassNotFoundException e1){   
		    System.out.println("找不到驱动程序类 ，加载驱动失败！");   
		    e1.printStackTrace() ;   
		    } 
		//String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_lyc100791454" ;    
	     //String username = "k44y5jmn3o" ;   
	     //String password = "x00lk0j05xjy313h3kxxhmm3h2kjk3ix1m3h4yj2" ;   
		String url = "jdbc:mysql://localhost:3307/bookdb" ;
		String username = "root";
		String password = "6450";
		try{   
	    	 con = DriverManager.getConnection(url , username , password ) ;
	     }catch(SQLException se){   
	    System.out.println("数据库连接失败！");   
	    se.printStackTrace() ;   
	       }   
	}
	public Connection getConnection()
	{
		return con;
	}
}
