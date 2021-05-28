package XML;

public class staff {
	private int id;
	private String f_name;
	private String l_name;
	private int salary;
	private String currency;
	
	public staff(int id, String f_name, String l_name, int salary, String currency) {
		super();
		this.id = id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.salary = salary;
		this.currency = currency;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
