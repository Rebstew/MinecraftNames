import java.util.ArrayList;
import java.util.List;


public class Player {
	
	/**
	 * UUID of this account. Is unique
	 */
	private String uuid;
	
	/**
	 * Last name taken by this account
	 */
	private String lastName;
	
	/**
	 * History of names taken by this account. 
	 * Excludes last name.
	 */
	private ArrayList<Name> names;
	
	/**
	 * Tells is the account is unmigrated (still uses username to login)
	 */
	private boolean legacy;
	
	/**
	 * Tells if this username has not bought the game
	 */
	private boolean demo;
	
	public Player(String uuid, String name){
		this.setUuid(uuid);
		this.names = new ArrayList<Name>();
		this.setLastName(name);
		//this.names.add(name);
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public List<Name> getNames(){
		return names;
	}
	
	public void addName(Name nameObject){
		this.names.add(nameObject);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isLegacy() {
		return legacy;
	}

	public void setLegacy(boolean legacy) {
		this.legacy = legacy;
	}

	public boolean isDemo() {
		return demo;
	}

	public void setDemo(boolean demo) {
		this.demo = demo;
	}
	
	

}
