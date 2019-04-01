package com.bean;

public class Student {
	private String enrollNumber;
	private String studentName;
	private int contact;
	private String courseCode;
	private String gender;
	private String[] courseType;
	
	public Student() {
	}

	public Student(String studentName, int contact, String courseCode, String gender, String[] courseType) {
		super();
		this.studentName = studentName;
		this.contact = contact;
		this.courseCode = courseCode;
		this.gender = gender;
		this.courseType = courseType;
	}

	public String getEnrollNumber() {
		return enrollNumber;
	}

	public void setEnrollNumber(String enrollNumber) {
		this.enrollNumber = enrollNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getCourseType() {
		return courseType;
	}

	public void setCourseType(String[] courseType) {
		this.courseType = courseType;
	}
}
