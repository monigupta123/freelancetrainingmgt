package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Freelancer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer freelancerId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private Long phoneNumber;
	private String address;
	
	
	 @OneToMany(mappedBy = "freelancer", cascade = CascadeType.ALL)
    private List<Training> trainings;
	
	public Freelancer() {
		
	}
	
	public Freelancer(Integer freelancerId, String firstName, String lastName, String emailId, String password,
			Long phoneNumber, String address) {
		super();
		this.freelancerId = freelancerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	public Integer getFreelancerId() {
		return freelancerId;
	}
	public void setFreelancerId(Integer freelancerId) {
		this.freelancerId = freelancerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Freelancer [freelancerId=" + freelancerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", password=" + password + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}	
}
