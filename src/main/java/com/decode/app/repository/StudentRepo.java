package com.decode.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.decode.app.model.Student;

@Repository
public interface StudentRepo extends MongoRepository<Student, String>{

}
