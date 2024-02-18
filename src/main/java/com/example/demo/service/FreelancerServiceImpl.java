package com.example.demo.service;

import java.util.List;

import com.example.demo.constants.ErrorCode;
import com.example.demo.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

	@Override
	public Freelancer getFreelancerByEmailId(String emailId) {
		return freelancerRepo.findByEmailId(emailId);
	}

	@Override
	public Freelancer login(Freelancer fr) {
		//Step 1 : Get free lancer object by email id => If found, then match password : else throw error
		//Step 2 : If found then match password
		//Step 3 : If password matched, then  return freelancer object, with success
		//Step 4 : If password not matched, send password wrong error

		Freelancer fetchedFreelancer = freelancerRepo.findByEmailId(fr.getEmailId());
		if (null != fetchedFreelancer) {
			//Match password
			String passwordFromDb = fetchedFreelancer.getPassword();
			if (passwordFromDb.equals(fr.getPassword())) {
				return fetchedFreelancer;
			} else {
				throw new AuthenticationException(HttpStatus.NOT_FOUND, "Password wrong");
			}
		} else {
			throw new AuthenticationException(HttpStatus.NOT_FOUND, "User not found");
		}
	}
}
