package com.decode.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.decode.app.model.Batch;
import com.decode.app.repository.BatchRepo;

@RestController
@RequestMapping("/decode")
@CrossOrigin("*")
public class BatchController {
	@Autowired
	BatchRepo batchRepo;

	@PostMapping("/batches")
	public Batch onboardBatch(@Valid @RequestBody Batch batch) {
	    return batchRepo.save(batch);
	}

	@GetMapping("/batches")
	public List<Batch> getBatchs() {
		Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
	    return batchRepo.findAll(sortByCreatedAtDesc);
	}

	@GetMapping(value="/batches/{id}")
	public ResponseEntity<Batch> getBatchById(@PathVariable("id") String id) {
	    return batchRepo.findById(id)
	            .map(batch -> ResponseEntity.ok().body(batch))
	            .orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(value="/batches/{id}")
	public ResponseEntity<?> deleteBatch(@PathVariable("id") String id) {
	    return batchRepo.findById(id)
	            .map(batch -> {
	            	batchRepo.deleteById(id);
	                return ResponseEntity.ok().build();
	            }).orElse(ResponseEntity.notFound().build());
	}
}
