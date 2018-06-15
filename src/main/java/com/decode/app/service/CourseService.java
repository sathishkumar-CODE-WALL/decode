package com.decode.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.decode.app.model.Course;

public interface CourseService {

	public Course enrollCourse(Course student);
	public void deleteCourse(Course student);
	public Course updateCourse(Course student);
	public Optional<Course> getCourse(String id);
	public List<Course> getCourses();
}
