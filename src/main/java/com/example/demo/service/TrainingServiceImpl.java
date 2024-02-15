package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Training;
import com.example.demo.repository.TrainingRepository;

@Service
public class TrainingServiceImpl implements TrainingService {
	
	@Autowired
	private TrainingRepository tr;

	@Override
	public Training addTraining(Training t) {
		Training training = tr.save(t);		
		return training;
	}

	@Override
	public void deleteTraining(Integer id) {
		tr.deleteById(id);
		
	}

	@Override
	public Training updateTraining(Training t) {
		Training training = tr.save(t);
		return training;
	}

	@Override
	public List<Training> listAllTraining() {
		List<Training>trainings = tr.findAll();
		return trainings;
	}

	@Override
	public Optional<Training> getById(Integer id) {
		Optional<Training> training = tr.findById(id);
		return training;
	}

}
