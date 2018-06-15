package com.decode.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.decode.app.model.Course;

@Repository
public interface CourseRepo  extends MongoRepository<Course, String> {

}
 