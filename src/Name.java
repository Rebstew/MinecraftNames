import java.util.Date;


public class Name {

	private String name;
	private Date changeDate;
	
	public Name(String name, Date date){
		this.setName(name);
		this.setChangeDate(date);
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		return "[NAME] name = "+name+", changeDate = "+changeDate;
	}
}
