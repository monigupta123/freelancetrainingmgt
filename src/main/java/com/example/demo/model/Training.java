package com.example.demo.model;

import java.time.LocalDateTime;

import com.example.demo.enums.TrainingCategory;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private Integer trainingId;
    
    @JsonProperty(value="trainingName")
    private String name;
    
    @JsonProperty(value="trainingDescription")
    private String description;
    
    @JsonProperty(value="trainingPrice")
    private Double price;
    
    @JsonProperty(value="trainingDuration")
    private Float duration;
    
    @JsonProperty(value="trainingStartTime")
    private LocalDateTime start;
    
    @JsonProperty(value="trainingEndTime")
    private LocalDateTime end;
    
    @JsonProperty(value="trainingCategory")
    private TrainingCategory category;
    
    @ManyToOne
    @JoinColumn(name = "freelancerId")
    private Freelancer freelancer;

    
    public Training() {
    }

    public Training(Integer trainingId, String name, String description, Double price, Float duration,
            LocalDateTime start, LocalDateTime end, TrainingCategory category) {
        this.trainingId = trainingId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.start = start;
        this.end = end;
        this.category = category;
    }
    
    
    public Integer getTrainingId() {
        return trainingId;
    }
    public void setTrainingId(Integer trainingId) {
        this.trainingId = trainingId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Float getDuration() {
        return duration;
    }
    public void setDuration(Float duration) {
        this.duration = duration;
    }
    public LocalDateTime getStart() {
        return start;
    }
    public void setStart(LocalDateTime start) {
        this.start = start;
    }
    public LocalDateTime getEnd() {
        return end;
    }
    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
    public TrainingCategory getCategory() {
        return category;
    }
    public void setCategory(TrainingCategory category) {
        this.category = category;
    }

    public Freelancer getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(Freelancer freelancer) {
        this.freelancer = freelancer;
    }

    @Override
    public String toString() {
        return "Training [trainingId=" + trainingId + ", name=" + name + ", description=" + description + ", price="
                + price + ", duration=" + duration + ", start=" + start + ", end=" + end + ", category=" + category
                + "]";
    }
    
    
}
