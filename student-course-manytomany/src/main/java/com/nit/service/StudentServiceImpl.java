package com.nit.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.nit.entity.Course;
import com.nit.entity.Student;
import com.nit.exception.CourseNotFoundException;
import com.nit.exception.StudentNotFoundException;
import com.nit.repository.ICourseRepository;
import com.nit.repository.IStudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements IStudentService {

	private IStudentRepository repo;
	private ICourseRepository crepo;
	@Override
	public Student createStudentWithCourses(Student std, Set<Long> cIds) {
		Set<Course>courses=new HashSet<>();
		cIds.forEach(id->{
			Course course = crepo.findById(id)
			.orElseThrow(()->new CourseNotFoundException("Course not found with id,"+id));
			courses.add(course);
		});
		std.setCourses(courses);
		return repo.save(std);
	}

	@Override
	public Student getStudentById(Long sId) {
		
		return repo.findById(sId)
				.orElseThrow(()->new StudentNotFoundException("Student not found with id,"+sId));
	}

	@Override
	public List<Student> getAllStudents() {
		
		return repo.findAll();
	}

	@Override
	public Student updateStudent(Long sId, Student std, Set<Long> cids) {
		Student existing = repo.findById(sId)
		.orElseThrow(()->new StudentNotFoundException("Student not found with id,"+sId));
		if(std.getName()!=null) {
		existing.setName(std.getName());
		}
		if(std.getAddress()!=null) {
		existing.setAddress(std.getAddress());
		}
		if(cids!=null && !cids.isEmpty()) {
		Set<Course>courses=new HashSet<>();
		cids.forEach(id->{
			Course course = crepo.findById(id)
			.orElseThrow(()->new CourseNotFoundException("Course not found with id,"+id));
			courses.add(course);
		});
		existing.setCourses(courses);
		}
		return repo.save(existing);
	}

	@Override
	public void deleteStudent(Long sId) {
		repo.deleteById(sId);

	}

}
