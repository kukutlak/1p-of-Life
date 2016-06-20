package oneper.DAO;

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class BaseDAO {

	public Connection getConnection(){
		
		//http://www.codejava.net/java-se/jdbc/connect-to-apache-derby-java-db-via-jdbc
		System.out.println(BaseDAO.class.getClassLoader().getResource("org.apache.derby.jdbc.EmbeddedDriver"));
		
		ClassLoader cl=ClassLoader.getSystemClassLoader();
		
		// TO Print TOMCAT default jars
		// URL[] urls = ((URLClassLoader)cl).getURLs();
		// To print WEBINF classes folder 
		// URL[] urls = ((URLClassLoader) (Thread.currentThread().getContextClassLoader())).getURLs();
//        for(URL url: urls){
//        	System.out.println(url.getFile());
//        }
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String dbURL = "jdbc:derby:C:/1Pdb;";
		Properties properties = new Properties();
		properties.put("user","scott");
		properties.put("password","tiger");
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(dbURL, properties);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return con;	
	}
}
