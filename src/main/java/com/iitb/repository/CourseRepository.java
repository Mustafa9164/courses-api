package com.iitb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iitb.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	Course findByCourseId(String courseId);

}
