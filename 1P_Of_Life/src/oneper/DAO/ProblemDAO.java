package oneper.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oneper.domobj.Problem;
import oneper.domobj.ProblemsList;

public class ProblemDAO extends BaseDAO {

	public ProblemsList getProblemsList(){
		
		Connection con = getConnection();
		
		String sql = "select * from PROBLEMS";
		Statement stmt = null;
		ResultSet rs=null;
		int size=0;
		ProblemsList proList = new ProblemsList();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("size " + size);
			while(rs.next()){		
				
				Problem tmpPro = new Problem();
				tmpPro.setiD(rs.getString(1));
				tmpPro.setType(rs.getString(2));
				tmpPro.setCost(rs.getFloat(3));
				//tmpPro.setExpiryDate(rs.getDate(4));
				proList.addProblem(tmpPro);
				
				System.out.println(rs.getString(1));
				//System.out.println(rs.getDate(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return proList;
		
	}
}
