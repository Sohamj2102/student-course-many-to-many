package com.nit.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.Course;
import com.nit.service.ICourseService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/courses")
@AllArgsConstructor
public class CourseController {

private ICourseService service;
	
	@PostMapping
	public ResponseEntity<Course> createCourse(@RequestBody Course course){
		Course saved = service.createCourse(course);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable Long id){
		Course course = service.getCourseById(id);
		return new ResponseEntity<>(course,HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<Course>> getCourses(){
		List<Course> courses = service.getAllCourses();
		return new ResponseEntity<>(courses,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable Long id,@RequestBody Course course){
		Course updateCourse = service.updateCourse(id, course);
		return new ResponseEntity<>(updateCourse,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable Long id){
		service.deleteCourse(id);
		return new ResponseEntity<>("Course Deleted Succesfully!",HttpStatus.OK);
	}
}
