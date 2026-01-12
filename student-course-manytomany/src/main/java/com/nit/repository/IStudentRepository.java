package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Student;

public interface IStudentRepository extends JpaRepository<Student, Long> {

}
