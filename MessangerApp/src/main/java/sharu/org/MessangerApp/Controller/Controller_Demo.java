package sharu.org.MessangerApp.Controller;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import sharu.org.MessangerApp.BeanClass.BeanService;
import sharu.org.MessangerApp.Model.Message;
import sharu.org.MessangerApp.Service.MessageService;

@Path("/demo")
public class Controller_Demo {

	public MessageService msgser=new MessageService();
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String Test() {
		return "Demo Test Successfull!!!!";
	}
	
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String Test(@MatrixParam("matrixvalue") String matrixvalue,
						@HeaderParam("headerdata") String headerdata,
						@CookieParam("name") String cookieName) {
		return "matrixvalue :"+matrixvalue
				+" headerdata :"+headerdata
				+" cookieName :"+cookieName;
	}
	
	@GET
	@Path("/context")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String Test(@Context UriInfo uriInfo,
						@Context HttpHeaders headers) {
		return "uriInfo :"+uriInfo.getPath()
				+" headers :"+headers.COOKIE.toString();
	}
	
	@GET
	@Path("/beanparm")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> listMessage(@BeanParam BeanService beanService){
		
		if(beanService.getEntryName()!=null && !beanService.getEntryName().equals("")) {
			return msgser.getMessageByEntry(beanService.getEntryName());
		}
		if(beanService.getStartLimit()>=0 && beanService.getEndLimit()>0) {
			return msgser.getMessageByLImit(beanService.getStartLimit(), beanService.getEndLimit());
		}
		return msgser.getAllMessage();
	}
}
