package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Course;
import com.bean.Student;
import com.entity.CourseEntity;
import com.entity.StudentEntity;

@Repository
public class EnrollStudentDAO {
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=SQLException.class)
	public int enrollStudent(Student student) {
		
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setStudentName(student.getStudentName());
		String courseType[] = student.getCourseType();
		
		if(courseType.length == 2)
			studentEntity.setCourseType("Both");
		else
			studentEntity.setCourseType(courseType[0]);
		
		studentEntity.setGender(student.getGender());
		
		CourseEntity courseEntity = em.find(CourseEntity.class, student.getCourseCode() );
		studentEntity.setCourseCode(courseEntity);
		
		em.persist(studentEntity);
		return studentEntity.getEnrollNumber();
	}
	
	public List<Course> getCourseList(){
		String sql = "from CourseEntity ce";
		Query q = em.createQuery(sql);
		List<CourseEntity> eCourseList = q.getResultList();
		List<Course> courseList = new ArrayList<>();
		for(CourseEntity ce : eCourseList) {
			Course course = new Course();
			course.setCourseCode(ce.getCourseCode());
			course.setCourseName(ce.getCourseName());
			courseList.add(course);
		}
		return courseList;
	}
	
	public String retrieveCourseType(String courseCode) {
		String sql = "select ce.courseType from CourseEntity ce where courseCode = :courseCode";
		Query q = em.createQuery(sql);
		q.setParameter("courseCode", courseCode);
		String courseType = (String) q.getSingleResult();
		return courseType;
	}
	public List<Course> getCourseDetails() {
		String sql = "from CourseEntity ce";
		Query q = em.createQuery(sql);
		List<CourseEntity> eCourseList = q.getResultList();
		List<Course> courseList = new ArrayList<>();
		for(CourseEntity ce : eCourseList) {
			Course course = new Course();
			
			course.setCourseName(ce.getCourseName());
			course.setCourseFees(Integer.toString(ce.getCourseFees()));
			course.setCourseType(ce.getCourseType());
			courseList.add(course);
		}
		return courseList;
	}
	
}

