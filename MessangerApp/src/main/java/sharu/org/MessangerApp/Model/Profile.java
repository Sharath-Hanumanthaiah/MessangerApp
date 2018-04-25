package sharu.org.MessangerApp.Model;


public class Profile {

	private int id;
	private String name;
	private String mostLiked;
	
	public Profile() {
		
	}
	
public Profile(int id, String name, String mostLiked) {
		this.id=id;
		this.name=name;
		this.mostLiked=mostLiked;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMostLiked() {
		return mostLiked;
	}
	public void setMostLiked(String mostLiked) {
		this.mostLiked = mostLiked;
	}
	
	
}
