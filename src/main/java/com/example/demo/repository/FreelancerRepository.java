package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Freelancer;

@Repository
public interface FreelancerRepository extends JpaRepository<Freelancer,Integer>{

}
