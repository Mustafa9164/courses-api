package com.iitb.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.iitb.entity.Course;
import com.iitb.util.ResponseStructure;

public interface CouseService {

	ResponseEntity<ResponseStructure<Course>> createCourse(Course course);

	ResponseEntity<ResponseStructure<List<Course>>> getAllCourses();

	ResponseEntity<ResponseStructure<Course>> getCourses(String courseId);

//	ResponseEntity<ResponseStructure<Course>> deleteCourse(String courseId);





}
