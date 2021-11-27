package com.mindtree.entity;

public class Candidates {
private int id;
private String name;
private int experienceInYears;
private String location;
private int jobpostid;
	public Candidates() {
		// TODO Auto-generated constructor stub
	}
	public Candidates(int id, String name, int experienceInYears, String location, int jobpostid) {
		super();
		this.id = id;
		this.name = name;
		this.experienceInYears = experienceInYears;
		this.location = location;
		this.jobpostid = jobpostid;
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
	public int getExperienceInYears() {
		return experienceInYears;
	}
	public void setExperienceInYears(int experienceInYears) {
		this.experienceInYears = experienceInYears;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getJobpostid() {
		return jobpostid;
	}
	public void setJobpostid(int jobpostid) {
		this.jobpostid = jobpostid;
	}

}
