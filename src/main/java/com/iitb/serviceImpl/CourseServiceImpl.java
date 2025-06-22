package com.iitb.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.iitb.entity.Course;
import com.iitb.repository.CourseRepository;
import com.iitb.service.CouseService;
import com.iitb.util.ResponseStructure;

@Service
public class CourseServiceImpl implements CouseService{
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public ResponseEntity<ResponseStructure<Course>> createCourse(Course course) {
		
		
		 Set<Course> validPrerequisites = new HashSet<>();		
		for(Course prereq :course.getPrerequisites()) {
			Course found = courseRepository.findByCourseId(prereq.getCourseId());
			if(found != null) {
				validPrerequisites.add(found);
			} else {
	            // If any one prerequisite is invalid, return 400 response
	            ResponseStructure<Course> errorStructure = new ResponseStructure<>();
	            errorStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
	            errorStructure.setMessage("Invalid prerequisite: " + prereq.getCourseId());
	            errorStructure.setData(null);

	            return new ResponseEntity<>(errorStructure, HttpStatus.BAD_REQUEST);
	        }
		}
		course.setPrerequisites(validPrerequisites);
		Course savedCourse =courseRepository.save(course);
		ResponseStructure<Course> structure=new ResponseStructure<>();
		structure.setData(savedCourse);
		structure.setMessage("Course Added sucessfully");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Course>>(structure, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Course>>> getAllCourses() {
		List<Course> all = courseRepository.findAll();
		if(all != null) {
			ResponseStructure<List<Course>> structure=new ResponseStructure<>();
			structure.setData(all);
			structure.setMessage("Course Fetched sucessfully");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Course>>>(structure, HttpStatus.OK);
		}
		return new ResponseEntity<ResponseStructure<List<Course>>>(HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<ResponseStructure<Course>> getCourses(String courseId) {
		
		Course byCourseId = courseRepository.findByCourseId(courseId);
		ResponseStructure<Course> structure=new ResponseStructure<>();

		if(byCourseId != null) {
			structure.setData(byCourseId);
			structure.setMessage("Course Found !");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Course>>(structure, HttpStatus.OK);
		}
        return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
	}

	
	
	
}
