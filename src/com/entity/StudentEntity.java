package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enrollstudent")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int enrollNumber;
	private String studentName;
	private String gender;
	private String courseType;

	@ManyToOne(targetEntity = CourseEntity.class)
	@JoinColumn(name = "courseCode")
	private CourseEntity courseCode;

	public StudentEntity() {
	}

	public StudentEntity(String studentName, String gender, String courseType, CourseEntity courseCode) {
		super();
		this.studentName = studentName;
		this.gender = gender;
		this.courseType = courseType;
		this.courseCode = courseCode;
	}

	public int getEnrollNumber() {
		return enrollNumber;
	}

	public void setEnrollNumber(int enrollNumber) {
		this.enrollNumber = enrollNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public CourseEntity getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(CourseEntity courseCode) {
		this.courseCode = courseCode;
	}

}
