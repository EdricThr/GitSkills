package com.thr.po;

import java.util.Date;
import java.util.List;

public class Student {

	private int id;
	private String username;
	private int age;
	private Date time;
	
	private List<String> habit;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public List<String> getHabit() {
		return habit;
	}
	public void setHabit(List<String> habit) {
		this.habit = habit;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", username=" + username + ", age=" + age
				+ ", time=" + time + ", habit=" + habit + "]";
	}
}
