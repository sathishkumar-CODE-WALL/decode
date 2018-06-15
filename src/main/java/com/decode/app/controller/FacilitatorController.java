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

import com.decode.app.model.Facilitator;
import com.decode.app.repository.FacilitatorRepo;

@RestController
@RequestMapping("/decode")
public class FacilitatorController {

	@Autowired
	FacilitatorRepo facilitatorRepo;

	@PostMapping("/facilitators")
	public Facilitator onboardFacilitator(@Valid @RequestBody Facilitator facilitator) {
		return facilitatorRepo.save(facilitator);
	}

	@GetMapping("/facilitators")
	public List<Facilitator> getFacilitators() {
		Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
		return facilitatorRepo.findAll(sortByCreatedAtDesc);
	}

	@GetMapping(value = "/facilitators/{id}")
	public ResponseEntity<Facilitator> getFacilitatorById(@PathVariable("id") String id) {
		return facilitatorRepo.findById(id).map(facilitator -> ResponseEntity.ok().body(facilitator))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(value = "/facilitators/{id}")
	public ResponseEntity<?> deleteFacilitator(@PathVariable("id") String id) {
		return facilitatorRepo.findById(id).map(facilitator -> {
			facilitatorRepo.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
