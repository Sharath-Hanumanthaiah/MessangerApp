package sharu.org.MessangerApp.Controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import sharu.org.MessangerApp.Model.Message;
import sharu.org.MessangerApp.Service.MessageService;

@Path("/messanger")
public class Controller_Message {

	public MessageService msgser=new MessageService();
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String Test() {
		return "Test Successfull!!!!";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> listMessage(@QueryParam("entryName") String entryName,
										@QueryParam("start") int startLimit,
										@QueryParam("endLimit") int endLimit){
		
		if(entryName!=null && !entryName.equals("")) {
			return msgser.getMessageByEntry(entryName);
		}
		if(startLimit>=0 && endLimit>0) {
			return msgser.getMessageByLImit(startLimit, endLimit);
		}
		return msgser.getAllMessage();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message AddMessage(Message message){
		return msgser.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message UpdateMessage(@PathParam("messageId") Integer messageId, Message message){
		message.setId(messageId);
		return msgser.UpdateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String DeleteMessage(@PathParam("messageId") Integer messageId){
		return msgser.RemoveMessage(messageId);
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") Integer messageId){
		return msgser.getById(messageId);
	}
	
	@Path("/{messageId}/comments")
	public Controller_comments getMessageComments(){
		return new Controller_comments();
	}
}
