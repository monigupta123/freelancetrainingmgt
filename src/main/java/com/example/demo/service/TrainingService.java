package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Training;

@Service
public interface TrainingService {
	
	 Training addTraining(Training t);
	
	 void deleteTraining(Integer id);
	
	 Training updateTraining(Training t);
	
	 List<Training> listAllTraining();
	
	 Optional<Training> getById(Integer id);
}
