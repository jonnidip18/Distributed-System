package rmi_practice;

import java.io.Serializable;

public class Newspaper implements Serializable{
	private String name;
	private String type;
	
	public Newspaper(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return this.type;
	}
}
