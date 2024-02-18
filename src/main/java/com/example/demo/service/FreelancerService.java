package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Freelancer;

@Service
public interface FreelancerService {
	
	public Freelancer addFreelancer(Freelancer f);
	
	public List<Freelancer>getAll();
	
	public void deleteById(Integer id);

	Freelancer getFreelancerByEmailId(String emailId);

	Freelancer login(Freelancer fr);

}
