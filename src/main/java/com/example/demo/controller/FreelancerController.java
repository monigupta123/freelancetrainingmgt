package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.model.Freelancer;
import com.example.demo.service.FreelancerService;

@RestController
//@CrossOrigin("http://localhost:3000")
@RequestMapping(path="/freelancer")
public class FreelancerController {
	
	@Autowired
	private FreelancerService freelancerService;
	
	@PostMapping
	public ResponseEntity<Freelancer> saveFreelancer(@RequestBody Freelancer fr ){
		Freelancer freelancer = freelancerService.addFreelancer(fr);
		return new ResponseEntity<>(freelancer,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Freelancer>> getAll(){
		List<Freelancer> allFreelancer = freelancerService.getAll();
		return new ResponseEntity<>(allFreelancer,HttpStatus.OK);	
	}
	
	@DeleteMapping("/{id}")
	public void deleteFrrealnce(@PathVariable Integer id){
		freelancerService.deleteById(id);
	}

	@PostMapping("/login")
	public ResponseEntity<Freelancer> login(@RequestBody Freelancer fr ){
		Freelancer freelancer = freelancerService.login(fr);
		return new ResponseEntity<>(freelancer,HttpStatus.OK);
	}
	
}
