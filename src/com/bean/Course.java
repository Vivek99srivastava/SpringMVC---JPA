package com.bean;

public class Course {
	private String courseCode;
	private String courseFees;
	private String courseName;
	private String courseType;
	
	public Course() {}

	public Course(String courseCode, String courseFees, String courseName, String courseType) {
		super();
		this.courseCode = courseCode;
		this.courseFees = courseFees;
		this.courseName = courseName;
		this.courseType = courseType;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseFees() {
		return courseFees;
	}

	public void setCourseFees(String courseFees) {
		this.courseFees = courseFees;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	
	
}
