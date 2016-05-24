package com.hzt.bean;

public class Student {
	private int stuId;
	private String name;
	private String address;

	public Student(int stuId, String name, String address) {
		super();
		this.stuId = stuId;
		this.name = name;
		this.address = address;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
