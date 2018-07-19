package com.qa.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Trainee {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(length = 32)
	@NotNull
	private String firstName;
	@Column(length = 32)
	@NotNull
	private String familyName;

	@OneToMany(
	        mappedBy = "trainee_id", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true
	    )
	private List<Subject> subjects;
	
	public Trainee() {
		
	}
	
	
	public Trainee(String firstName, String familyName, List<Subject> subjects) {
		
		this.firstName = firstName;
		this.familyName = familyName;
		this.subjects = subjects;

	}


	public void setID(long id) {
		this.id = id;
	}
	
	
	public long getID() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setfamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String toString() {
		return "Account ID: "+ getID() + "\n"
				+ "First name: " + getFirstName() + "\n"
				+ "Family name: " + getFamilyName();
	}
	

	public List<Subject> getSubject() {
       return subjects;
    }
	
	public void addSubject(Subject subject) {
        subjects.add(subject);
    }
 
    public void removeSubject(Subject subject) {
        subjects.remove(subject);
    }
	
	

	

}
