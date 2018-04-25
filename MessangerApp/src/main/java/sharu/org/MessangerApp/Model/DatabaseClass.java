package sharu.org.MessangerApp.Model;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {

	public static HashMap<Integer, Message> messageList= new HashMap<Integer, Message>();
	public static HashMap<String, Profile> profile= new HashMap<String, Profile>();
	
	
	public static HashMap<Integer, Message> getMessageList() {
		return messageList;
	}
	public static void setMessageList(HashMap<Integer, Message> messageList) {
		DatabaseClass.messageList = messageList;
	}
	public static HashMap<String, Profile> getProfile() {
		return profile;
	}
	public static void setProfile(HashMap<String, Profile> profile) {
		DatabaseClass.profile = profile;
	}
	
	
}
