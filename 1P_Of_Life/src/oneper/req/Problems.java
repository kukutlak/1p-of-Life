package oneper.req;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import oneper.DAO.ProblemDAO;
import oneper.domobj.Problem;



@Path("/problem")
public class Problems {
	List<Problem> list = new ArrayList<>();
	
	@Path("/count")
	@GET
	public Response getCount(){
		Problem problem = new Problem("P1","T1",1.0F, new GregorianCalendar());
		list.add(problem);
		//String result = String.valueOf(list.size()); 
		return Response.status(200).entity(list.size()).build();
	}
	
	@Path("/{index}")
	@GET
	public Response getProblem(@PathParam("index") int index){
		Problem problem = new Problem("P1","T1",1.0F, new GregorianCalendar());
		
		ProblemDAO proDAO = new ProblemDAO();
		ResultSet rs = proDAO.getProblemsList();
		
	
			return Response.status(200).entity(rs).build();
		
	}
	
	

}

