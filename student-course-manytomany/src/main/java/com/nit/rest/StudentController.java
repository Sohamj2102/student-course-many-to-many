package com.nit.rest;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.Student;
import com.nit.service.IStudentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

	private IStudentService service;
	@PostMapping
	public ResponseEntity<Student> registerStudentWithCourses(@RequestBody Student std,
															@RequestParam Set<Long> cIds){
		Student student = service.createStudentWithCourses(std, cIds);
		return new ResponseEntity<>(student,HttpStatus.CREATED);
	}
	
	@GetMapping("/{sid}")
	public ResponseEntity<Student> getStudent(@PathVariable Long sid){
		Student student = service.getStudentById(sid);
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> students = service.getAllStudents();
		return new ResponseEntity<>(students,HttpStatus.OK);
	}
	
	@PutMapping("/{sId}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long sId,
												@RequestBody Student std,
												@RequestParam(required = false) Set<Long>cIds){
		Student student = service.updateStudent(sId, std, cIds);
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id){
		service.deleteStudent(id);
		return new ResponseEntity<>("Student deleted succesfully!",HttpStatus.OK);
	}
	
}
