package sharu.org.MessangerApp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import sharu.org.MessangerApp.Model.DatabaseClass;
import sharu.org.MessangerApp.Model.Message;
import sharu.org.MessangerApp.Model.Profile;

public class ProfileService {

	Map<String,Profile> data=new DatabaseClass().profile;
	
	public ProfileService() {
		data.put("Sharu", new Profile(1, "Sharu", "money"));
		data.put("karthik", new Profile(2, "karthik", "family"));
	}
	
	public List<Profile> getAllProfile() {
		List<Profile> list=new ArrayList<Profile>( data.values());
		return list;
	}
	
	public Profile getById(String value) {
		return data.get(value);
	}
	
	public Profile addProfile(Profile value) {
		value.setId(data.size()+1);
		data.put(value.getName(), value);
		return value;
	}
	
	public Profile UpdateProfile(Profile value) {
		if(value.getId()<=0) {
			value.setId(data.size()+1);
			data.put(value.getName(), value);
			return value;
		}
		data.put(value.getName(), value);
		return value;
	}
	
	public String RemoveProfile(String Name) {
		if(data.get(Name)==null){
			return " Profile not found";
		}
		data.remove(Name);
		return "Profile"+Name+" Deleted SuccessFully";
	}
}
