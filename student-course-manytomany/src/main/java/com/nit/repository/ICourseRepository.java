package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Course;

public interface ICourseRepository extends JpaRepository<Course, Long> {

}
