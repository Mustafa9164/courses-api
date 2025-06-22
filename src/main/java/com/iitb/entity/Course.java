package com.iitb.entity;

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
import jakarta.persistence.Transient;

@Entity
@Table(name = "courses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "course_id", unique = true, nullable = false)
	private String courseId;
	@Column(nullable = false)
	private String title;
	private String description;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	    name = "course_prerequisites",
	    joinColumns = @JoinColumn(name = "course_id"),
	    inverseJoinColumns = @JoinColumn(name = "prerequisite_id"))
	private Set<Course> prerequisites ;

	public Course() {
		super();
	}

	public Course(Integer id, String courseId, String title, String description, Set<Course> prerequisites) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.title = title;
		this.description = description;
		this.prerequisites = prerequisites;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Course> getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(Set<Course> prerequisites) {
		this.prerequisites = prerequisites;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseId=" + courseId + ", title=" + title + ", description=" + description
				+ ", prerequisites=" + prerequisites + "]";
	}
	
	

	
}
