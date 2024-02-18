package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Training;
import com.example.demo.service.TrainingService;

@RestController
//@CrossOrigin("http://localhost:3000")
@RequestMapping(path="/training")
public class TrainingController {

	@Autowired
	private TrainingService trainingservice;

	
	//add training
	@PostMapping
	public ResponseEntity<Training> addTraining(@RequestBody Training tr) {
		Training training = trainingservice.addTraining(tr);
		return new ResponseEntity<>(training, HttpStatus.CREATED);

	}

	//list all training
	@GetMapping
	public ResponseEntity<List<Training>> listAllTraining() {
		List<Training> trainings = trainingservice.listAllTraining();
		return new ResponseEntity<>(trainings, HttpStatus.OK);
	}

	//delete training
	@DeleteMapping("/{id}")
	public void deleteTrainingById(@PathVariable Integer id) {
		trainingservice.deleteTraining(id);

	}

	//get by id
	@GetMapping("/{id}")
	public ResponseEntity<Training> getTrainingById(@PathVariable Integer id) {
		Optional<Training> trainingOptional = trainingservice.getById(id);

		if (trainingOptional.isPresent()) {
			Training training = trainingOptional.get();
			return new ResponseEntity<>(training, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
