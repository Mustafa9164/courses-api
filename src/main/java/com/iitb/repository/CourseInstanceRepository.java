package com.iitb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iitb.entity.CourseInstance;

public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Integer> {

}
