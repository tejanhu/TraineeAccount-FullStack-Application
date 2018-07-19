package com.qa.persistence.repository;

import com.qa.persistence.domain.Subject;

public interface SubjectRepositoryImpl {

	String createSubject(String Subject);
	
	String updateSubject(long id, String originalAccount);
	
	String deleteSubject(long id);

	String getAllSubjects();
	
    Subject getSubject(long id);
	
	
}
