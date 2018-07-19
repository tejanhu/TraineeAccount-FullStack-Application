package com.qa.business;

import com.qa.persistence.domain.Subject;

public interface SubjectServiceImpl {
	
	String createSubject(String subject);
	
	String updateSubject(long id, String newSubject);
	
	String deleteSubject(long id);

	String getAllSubjects();
	
    Subject getSubject(long id);

}
