package com.proiect.medtime;

public class Pacient {

	int _id;
	String name;
	int age;
	String cronic;

	public Pacient() {

	}

	public Pacient(int id, String name, int age, String cronic) {
		this._id = id;
		this.name = name;
		this.age = age;
		this.cronic = cronic;

	}
	
	public int getId(){
		return this._id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getAge(){
		return this.age;
	}

	public String getCronic(){
		return this.cronic;
	}
	public void setId(int id){
		this._id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public void setCronic(String cronic){
		this.cronic = cronic;
	}
	

}
