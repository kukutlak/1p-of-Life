package oneper.req;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import oneper.DAO.ProblemDAO;
import oneper.domobj.Problem;
import oneper.domobj.ProblemsList;



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
		ProblemsList problems = proDAO.getProblemsList();
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString="Jackson problem in mapper";
		try {
			//http://www.mkyong.com/java/how-to-convert-java-object-to-from-json-jackson/
			jsonInString = mapper.writeValueAsString(problems);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
			return Response.status(200).entity(jsonInString).header("Access-Control-Allow-Origin", "*").
					build();
		
	}
}

