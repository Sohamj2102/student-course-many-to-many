package com.nit.service;

import java.util.List;

import com.nit.entity.Course;

public interface ICourseService {

	 Course createCourse(Course course);
	 Course getCourseById(Long cId);
	 List<Course> getAllCourses();
	 Course updateCourse(Long cId,Course course);
	 void deleteCourse(Long cId);
}
