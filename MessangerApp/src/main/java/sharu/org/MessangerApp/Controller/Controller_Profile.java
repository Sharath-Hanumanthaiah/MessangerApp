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
import javax.ws.rs.core.MediaType;

import sharu.org.MessangerApp.Model.Message;
import sharu.org.MessangerApp.Model.Profile;
import sharu.org.MessangerApp.Service.MessageService;
import sharu.org.MessangerApp.Service.ProfileService;


@Path("/profile")
public class Controller_Profile {

	public ProfileService profileobj=new ProfileService();
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String Test() {
		return "Profile Test Successfull!!!!";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> listMessage(){
		return profileobj.getAllProfile();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile AddMessage(Profile profile){
		return profileobj.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile UpdateMessage(@PathParam("profileName") String profileName, Profile profile){
		profile.setName(profileName);
		return profileobj.UpdateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String DeleteMessage(@PathParam("profileName") String profileName){
		return profileobj.RemoveProfile(profileName);
	}
	
	@GET
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfile(@PathParam("profileName") String profileName){
		return profileobj.getById(profileName);
	}
}
