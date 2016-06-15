package oneper.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProblemDAO extends BaseDAO {

	public ResultSet getProblemsList(){
		Connection con = getConnection();
		
		String sql = "select * from PROBLEMS";
		Statement stmt = null;
		ResultSet rs=null;
		int size=0;;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("size " + size);
			while(rs.next()){				
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getFloat(3));
				System.out.println(rs.getDate(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
}
