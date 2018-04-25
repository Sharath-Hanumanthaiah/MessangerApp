package sharu.org.MessangerApp.Model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

	private int id;
	private String text;
	private Date entryDate;
	private String entryBy;
	
	public Message() {
		
	}
	
public Message(int id, String text, String entryBy) {
		this.id=id;
		this.text=text;
		this.entryDate=new Date();
		this.entryBy=entryBy;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public String getEntryBy() {
		return entryBy;
	}
	public void setEntryBy(String entryBy) {
		this.entryBy = entryBy;
	}
	
	
}
