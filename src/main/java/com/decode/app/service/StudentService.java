package com.decode.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.decode.app.model.Student;

@Service
public interface StudentService {

	public Student enrollStudent(Student student);
	public void deleteStudent(Student student);
	public Student updateStudent(Student student);
	public Optional<Student> getStudent(String id);
	public List<Student> getStudents();
	
	
	
}
