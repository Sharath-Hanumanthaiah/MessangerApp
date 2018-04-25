package sharu.org.MessangerApp.BeanClass;

import javax.ws.rs.QueryParam;

public class BeanService {

	private @QueryParam("entryName") String entryName;
	private @QueryParam("start") int startLimit;
	private @QueryParam("endLimit") int endLimit;
	public String getEntryName() {
		return entryName;
	}
	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}
	public int getStartLimit() {
		return startLimit;
	}
	public void setStartLimit(int startLimit) {
		this.startLimit = startLimit;
	}
	public int getEndLimit() {
		return endLimit;
	}
	public void setEndLimit(int endLimit) {
		this.endLimit = endLimit;
	}
	
	
}
