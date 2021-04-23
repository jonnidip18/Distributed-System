package Exercise;

import java.io.Serializable;

public final class Student implements Serializable {
	private String name;
	private String id;
	private String dob;

	Student(String name, String id, String dob) {
		this.name = name;
		this.id = id;
		this.dob = dob;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setID(String id) {
		this.id = id;
	}

	public void setDOB(String dob) {
		this.dob = dob;
	}

	public String getName() {
		return this.name;
	}

	public String getID() {
		return this.id;
	}

	public String getDOB() {
		return this.dob;
	}
}
