package com.iitb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iitb.entity.Course;
import com.iitb.service.CouseService;
import com.iitb.util.ResponseStructure;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
	
	@Autowired
	private CouseService couseService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Course>> createCourse(@RequestBody Course course){
			return couseService.createCourse(course);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Course>>> getAllCourse(){
		return couseService.getAllCourses();
	}
	@GetMapping("/courseId")
	public ResponseEntity<ResponseStructure<Course>> getCourse(@RequestParam("courseId") String CourseId){
		return couseService.getCourses(CourseId);
	}
//	@PutMapping
//	public ResponseEntity<ResponseStructure<Course>> updateCourse(@RequestParam("courseId") String courseId,@RequestBody Course course){
//		return couseService.updateCourse(courseId,course);
//	}
//	@DeleteMapping("/courseId")
//	public ResponseEntity<ResponseStructure<Course>> deleteCourse(@RequestParam("courseId") String CourseId){
//		return couseService.deleteCourse(CourseId);
//	}

}
