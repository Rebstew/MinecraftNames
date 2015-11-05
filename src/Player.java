import java.util.ArrayList;
import java.util.List;


public class Player {
	
	private String uuid;
	private String lastName;
	private ArrayList<String> names;
	
	public Player(String uuid, String name){
		this.setUuid(uuid);
		this.names = new ArrayList<String>();
		this.setLastName(name);
		//this.names.add(name);
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public List<String> getNames(){
		return names;
	}
	
	public void addName(String name){
		this.names.add(name);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
