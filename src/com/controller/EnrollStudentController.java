package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Course;
import com.bean.Student;
import com.service.EnrollStudentService;

@Controller
public class EnrollStudentController {

	@Autowired
	private EnrollStudentService service;

	@RequestMapping(value = "/Success.htm", method = RequestMethod.POST)
	public ModelAndView enrollStudent(@ModelAttribute("student") Student student, BindingResult errors) {
		ModelAndView modelAndView = new ModelAndView();
		int studentId = service.enrollStudent(student);
		if (studentId == 0) {
			modelAndView.addObject("message", "Selected coursetype is not available for the given course");
			modelAndView.setViewName("courseenrollment");
		} else {
			modelAndView.addObject("message", "Thank you for registration. Your enrollment number is :" + studentId);
			modelAndView.setViewName("Success");
		}
		return modelAndView;
	}

	@ModelAttribute("courseList")
	public Map<String, String> getCourseList() {
		HashMap<String, String> courseList = new HashMap<>();
		List<Course> course = service.getCourseList();
		for (Course c : course) {
			courseList.put(c.getCourseCode(), c.getCourseName());
		}
		return courseList;
	}

	@RequestMapping("/courseenrollment.htm")
	public ModelAndView loadEnrollPage() {
		ModelAndView modelAndView = new ModelAndView();
		Student student = new Student();
		modelAndView.addObject(student);
		modelAndView.setViewName("courseenrollment");
		return modelAndView;
	}

	@RequestMapping("/student.htm")
	public ModelAndView displayStudentPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("student");
		return modelAndView;
	}
	
	@RequestMapping("/viewallcourse.htm")
	public ModelAndView getCourseDetails() {

		ModelAndView modelAndView = new ModelAndView();
		List<Course> crs = service.getCourseDetails();

		modelAndView.addObject("crs", crs);
		modelAndView.setViewName("viewallcourse");

		return modelAndView;
	}
}
