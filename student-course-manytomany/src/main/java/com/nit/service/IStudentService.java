package com.nit.service;

import java.util.List;
import java.util.Set;

import com.nit.entity.Student;

public interface IStudentService {

	Student createStudentWithCourses(Student std,Set<Long>cIds);
	Student getStudentById(Long sId);
	List<Student>getAllStudents();
	Student updateStudent(Long sId,Student std,Set<Long>cids);
	void deleteStudent(Long sId);
}
