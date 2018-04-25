package sharu.org.MessangerApp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import sharu.org.MessangerApp.Model.DatabaseClass;
import sharu.org.MessangerApp.Model.Message;


public class MessageService {

	Map<Integer,Message> data=new DatabaseClass().messageList;
	
	public MessageService() {
		data.put(1, new Message(1, "Hello World!!", "Sharu"));
		data.put(2, new Message(2, "First Api", "Sharu"));
		data.put(3, new Message(3, "Thank u", "Sharu"));
	}
	
	public List<Message> getMessageByEntry(String entryBy){
		List<Message> list=new ArrayList<Message>( data.values());
		List<Message> result= new ArrayList<Message>();
		for(Message obj:list) {
			if(obj.getEntryBy().equals(entryBy)) {
				result.add(obj);
			}
		}
		return result;
	}
	
	public List<Message> getMessageByLImit(int start,int limit){
		List<Message> list=new ArrayList<Message>( data.values());
		if(start>list.size()) {
			return new ArrayList<Message>();
		}
		return list.subList(start, start+limit);
	}
	
	public List<Message> getAllMessage() {
		List<Message> list=new ArrayList<Message>(data.values());
		return list;
	}
	
	public Message getById(Integer value) {
		return data.get(value);
	}
	
	public Message addMessage(Message value) {
		value.setId(data.size()+1);
		data.put(data.size()+1, value);
		return value;
	}
	
	public Message UpdateMessage(Message value) {
		if(value.getId()<=0) {
			value.setId(data.size()+1);
			data.put(data.size()+1, value);
			return value;
		}
		data.put(value.getId(), value);
		return value;
	}
	
	public String RemoveMessage(Integer id) {
		if(data.get(id)==null){
			return " Message not found";
		}
		data.remove(id);
		return "Message ID "+id+" Deleted SuccessFully";
	}
}
