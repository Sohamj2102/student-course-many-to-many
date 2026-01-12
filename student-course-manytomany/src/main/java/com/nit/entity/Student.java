package com.nit.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString(exclude="courses")
@Entity
@Table(name="STUDENTS")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stdId;
	@Column(length=30)
	private String name;
	@Column(length=30)
	private String address;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="student_course",
	joinColumns = @JoinColumn(name="std_id",referencedColumnName = "stdId"),
	inverseJoinColumns = @JoinColumn(name="course_id",referencedColumnName = "cId"))
	@Builder.Default
	private Set<Course>courses=new HashSet<>();
}
