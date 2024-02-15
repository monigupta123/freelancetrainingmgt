package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Freelancer;
import com.example.demo.repository.FreelancerRepository;

@Service
public class FreelancerServiceImpl implements FreelancerService {
	
	@Autowired
	private FreelancerRepository freelancerRepo;

	@Override
	public Freelancer addFreelancer(Freelancer f) {
		Freelancer fr = freelancerRepo.save(f);
		return fr;
	}

	@Override
	public List<Freelancer> getAll() {
		List<Freelancer> list = freelancerRepo.findAll();
			return list;
	}

	@Override
	public void deleteById(Integer id) {
		 freelancerRepo.deleteById(id);
	}			
}
