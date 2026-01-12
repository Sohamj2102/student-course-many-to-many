package com.nit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nit.entity.Course;
import com.nit.exception.CourseNotFoundException;
import com.nit.repository.ICourseRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements ICourseService {

	private ICourseRepository repo;
	@Override
	public Course createCourse(Course course) {
		
		return repo.save(course);
	}

	@Override
	public Course getCourseById(Long cId) {
		return repo.findById(cId)
				.orElseThrow(()->new CourseNotFoundException("Course not found with id,"+cId));

	}

	@Override
	public List<Course> getAllCourses() {
		
		return repo.findAll();
	}

	@Override
	public Course updateCourse(Long cId, Course course) {
		Course existing = repo.findById(cId)
		.orElseThrow(()->new CourseNotFoundException("Course not found with id,"+cId));
		existing.setName(course.getName());
		existing.setFee(course.getFee());
		return repo.save(existing);
	}

	@Override
	public void deleteCourse(Long cId) {
		repo.deleteById(cId);

	}

}
