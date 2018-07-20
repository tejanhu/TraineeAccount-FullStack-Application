package com.qa.business;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Subject;
import com.qa.persistence.repository.SubjectRepository;
import com.qa.persistence.repository.TraineeRepository;

public class SubjectService implements SubjectServiceImpl {
	
	private static final Logger LOGGER = Logger.getLogger(SubjectService.class);
	
	@Inject
	private SubjectRepository repo;
	


	public String createSubject(String subject) {
			return repo.createSubject(subject);
	}

	public String updateSubject(long id, String newSubject) {
		LOGGER.info("In SubjectService updateSubject");
			return repo.updateSubject(id,newSubject);
		
	}

	public String deleteSubject(long id) {
		LOGGER.info("In SubjectService deleteSubject");
		return repo.deleteSubject(id);
	}

	public String getAllSubjects() {
		LOGGER.info("In SubjectService getAllSubjects");
		return repo.getAllSubjects();
	}


	public Subject getSubject(long id) {
		LOGGER.info("In SubjectService getSubject");
		return repo.getSubject(id);
	}

	public void setRepo(SubjectRepository repo) {
		LOGGER.info("In SubjectService setRepo ");
		this.repo = repo;
	}


}
