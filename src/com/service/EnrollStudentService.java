package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Course;
import com.bean.Student;
import com.dao.EnrollStudentDAO;

@Service
public class EnrollStudentService {

	@Autowired
	private EnrollStudentDAO dao;
	
	public List<Course> getCourseDetails(){
		return dao.getCourseDetails();
	}
	
	public List<Course> getCourseList(){
		return dao.getCourseList();
	}
	
	public int enrollStudent(Student student) {
		String[] courseType = student.getCourseType();
		int flag = 0;
		if(dao.retrieveCourseType(student.getCourseCode()) == "Both") {
			flag = dao.enrollStudent(student);
		}else if(courseType[0] == dao.retrieveCourseType(student.getCourseCode())){
			flag = dao.enrollStudent(student);
		}else {
			flag = 0;
		}
		return flag;
	}
}
