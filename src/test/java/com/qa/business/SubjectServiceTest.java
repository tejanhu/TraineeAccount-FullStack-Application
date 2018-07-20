package com.qa.business;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.repository.SubjectRepository;



@RunWith(MockitoJUnitRunner.class)
public class SubjectServiceTest {
		

	private static final String MOCK_VALUE = "test_value";
	
	private static final String MOCK_VALUE2 = "test_value_2";
	
	@InjectMocks
	private SubjectService service;
	
	@Mock
	private SubjectRepository repo;
	
	@Before  
	public void setUp() {
		service.setRepo(repo);
	}
	@Test
	public void testCreateSubject() {
		Mockito.when(repo.createSubject(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.createSubject(MOCK_VALUE2));	
		Mockito.verify(repo).createSubject(MOCK_VALUE2);
	}
	@Test
	public void testUpdateSubject() {
		Mockito.when(repo.updateSubject(1L, MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.updateSubject(1L,MOCK_VALUE2));	
		Mockito.verify(repo).updateSubject(1L, MOCK_VALUE2);
	}
	@Test
	public void testDeleteTrainee() {
		Mockito.when(repo.deleteSubject(1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.deleteSubject(1L));	
		Mockito.verify(repo).deleteSubject(1L);
	}
	@Test
	public void testGetAllTrainees() {
		Mockito.when(repo.getAllSubjects()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.getAllSubjects());	
	}




}