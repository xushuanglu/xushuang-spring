package com.lulu;

public class Man {

	private int id;
	private String name;
	private String hobby;
	
	private Dog dog;
	
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
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	
	public Man() {
	}
	
	@Override
	public String toString() {
		return "Man [id=" + id + ", name=" + name + ", hobby=" + hobby + ", dog=" + dog + "]";
	}
	public Man(int id, String name, String hobby, Dog dog) {
		super();
		this.id = id;
		this.name = name;
		this.hobby = hobby;
		this.dog = dog;
	}
	
}
