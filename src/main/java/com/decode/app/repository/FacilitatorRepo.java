package com.decode.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.decode.app.model.Facilitator;

@Repository
public interface FacilitatorRepo extends MongoRepository<Facilitator, String> {

}
