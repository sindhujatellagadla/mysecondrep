package com.mindtree.entity;

public class JobPost {
private int id;
private String name;
private String title;
private int openpositions;
	public JobPost() {
		// TODO Auto-generated constructor stub
	}
	public JobPost(int id, String name, String title, int openpositions) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.openpositions = openpositions;
	}
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getOpenpositions() {
		return openpositions;
	}
	public void setOpenpositions(int openpositions) {
		this.openpositions = openpositions;
	}

}
