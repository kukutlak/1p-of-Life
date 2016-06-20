package oneper.req;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;




@Path("/rest")
public class Sponser {
    @GET
    @RolesAllowed("ANYTHING")
    public Response hello() {
        return Response.ok("Hello World-worked").build();
    }
}