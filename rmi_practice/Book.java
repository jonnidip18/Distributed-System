package rmi_practice;

import java.io.*;

public class Book implements Serializable{
	private String name;
	private String author;
	
	public Book(String name, String author) {
		this.name=name;
		this.author=author;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAuthor() {
		return this.author;
	}
}
