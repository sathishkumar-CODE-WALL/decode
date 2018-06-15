package com.decode.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.decode.app.model.Course;
import com.decode.app.repository.CourseRepo;

@RestController
@RequestMapping("/decode")
@CrossOrigin("*")
public class CourseController{

	@Autowired
	CourseRepo courseRepo;

	@PostMapping("/courses")
	public Course onboardCourse(@Valid @RequestBody Course course) {
	    return courseRepo.save(course);
	}

	@GetMapping("/courses")
	public List<Course> getCourses() {
		//Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
	    return courseRepo.findAll();
	}

	@GetMapping(value="/courses/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable("id") String id) {
	    return courseRepo.findById(id)
	            .map(course -> ResponseEntity.ok().body(course))
	            .orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(value="/courses/{id}")
	public ResponseEntity<?> deleteCourse(@PathVariable("id") String id) {
	    return courseRepo.findById(id)
	            .map(course -> {
	            	courseRepo.deleteById(id);
	                return ResponseEntity.ok().build();
	            }).orElse(ResponseEntity.notFound().build());
	}

	/*@GetMapping("/error")
	public ResponseEntity<?> errorPage() {
	    return ResponseEntity.notFound().build();
	}
	
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}*/

}



