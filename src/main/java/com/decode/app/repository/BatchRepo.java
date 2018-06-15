package com.decode.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.decode.app.model.Batch;

@Repository
public interface BatchRepo extends MongoRepository<Batch, String>{
}
