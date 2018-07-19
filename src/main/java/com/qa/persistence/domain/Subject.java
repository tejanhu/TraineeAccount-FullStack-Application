package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Subject {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private long subject_id;
	
	@Column(name = "SUBJECT_ID")
	private long trainee_id;
	
	@Column(length = 32)
	@NotNull
	@NotEmpty
	private String name;
	

	private int score;
	
	public Subject() {
	
	}
	
	public Subject(long subject_id, String name, int score) {
		this.subject_id = subject_id;
		this.name = name;
		this.score = score;
	}
	
	public void setId(long subject_id) {
		this.subject_id = subject_id;
	}
	
	public long getId() {
		return subject_id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
		
	public void setScore(int score) {
		this.score = score;
	}
	
	public long getScore() {
		return score;
	}

	public long getTrainee() {
		return trainee_id;
	}

}
