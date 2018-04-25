package sharu.org.MessangerApp.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class Controller_comments {

	
	@GET
	public String Test() {
		return "test Comment Successfull!!!!";
	}
}
