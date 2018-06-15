package com.decode.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.decode.app.model.Student;
import com.decode.app.repository.StudentRepo;

@RestController
@RequestMapping("/decode")
public class StudentController {

	@Autowired
	StudentRepo studentRepo;

	@PostMapping("/students")
	public Student onboardStudent(@Valid @RequestBody Student student) {
	    return studentRepo.save(student);
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
	    return studentRepo.findAll(sortByCreatedAtDesc);
	}

	@GetMapping(value="/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") String id) {
	    return studentRepo.findById(id)
	            .map(student -> ResponseEntity.ok().body(student))
	            .orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(value="/students/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") String id) {
	    return studentRepo.findById(id)
	            .map(student -> {
	            	studentRepo.deleteById(id);
	                return ResponseEntity.ok().build();
	            }).orElse(ResponseEntity.notFound().build());
	}

}
