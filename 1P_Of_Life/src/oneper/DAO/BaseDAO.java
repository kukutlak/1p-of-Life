package oneper.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class BaseDAO {
	
	private static final Logger LOGGER = Logger.getLogger(BaseDAO.class.getName());
	
	public Connection getConnection(){
		
		Connection con = null;
		DbEnum db = DbEnum.DERBY;
		
		switch (db){
		case DERBY : 
			con = getDerbyConnection(con);
			break;
		case ElephantSQL:
			con = getElephantSQLConnection(con);
			break;
		
		default:
			con = getDerbyConnection(con);
		}
		return con;
	}
	
	public Connection getElephantSQLConnection(Connection con)			
	{
		
		//String username = "xmozwsft";
		//String password = "ugJOCiG-GAWNO5H1IpT2yFJkHGbn1zVQ";
		
		Context ctx = null;
		DataSource ds= null;
		try {
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("jdbc/ElephantSQL-py");
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//ctx.bind("jdbc/fastCoffeeDB", ds);
		
		
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LOGGER.log(Level.SEVERE, "from log :");
		LOGGER.info("from info :"+LOGGER.getName());
		LOGGER.warning("from Warning");
		
		System.out.println("from sys out");

		
		
		return con;
	}

	public Connection getDerbyConnection(Connection con){
		
		//http://www.codejava.net/java-se/jdbc/connect-to-apache-derby-java-db-via-jdbc
		System.out.println(BaseDAO.class.getClassLoader().getResource("org.apache.derby.jdbc.EmbeddedDriver"));
		
		ClassLoader cl=ClassLoader.getSystemClassLoader();
		
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
		
		
		
		try {
			con = DriverManager.getConnection(dbURL, properties);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return con;	
	}
}
