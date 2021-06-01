package XML;

public class staff {
	private int id;
	private String f_name;
	private String l_name;
	private String n_name;
	private double salary;
	private String currency;
	
	public staff(int id, String f_name, String l_name, String n_name, double salary, String currency) {
		super();
		this.id = id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.n_name = n_name;
		this.salary = salary;
		this.currency = currency;
	}

	public String getN_name() {
		return n_name;
	}

	public void setN_name(String n_name) {
		this.n_name = n_name;
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

	public double getSalary() {
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

	@Override
	public String toString() {
		return "staff [id=" + id + ", firstname=" + f_name + ", lastname=" + l_name + ", nickname=" + n_name + ", salary="
				+ salary + ", currency=" + currency + "]";
	}
	
}
