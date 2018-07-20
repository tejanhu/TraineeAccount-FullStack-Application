package com.qa.business;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.repository.TraineeRepository;



@RunWith(MockitoJUnitRunner.class)
public class TraineeServiceTest {
	
	

	

	private static final String MOCK_VALUE = "test_value";
	
	private static final String MOCK_VALUE2 = "test_value_2";
	
	@InjectMocks
	private TraineeService service;
	
	@Mock
	private TraineeRepository repo;
	
	@Before  
	public void setUp() {
		service.setRepo(repo);
	}
	@Test
	public void testCreateTrainee() {
		Mockito.when(repo.createTrainee(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.createTrainee(MOCK_VALUE2));	
		Mockito.verify(repo).createTrainee(MOCK_VALUE2);
	}
	@Test
	public void testUpdateTrainee() {
		Mockito.when(repo.updateTrainee(1L, MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.updateTrainee(1L,MOCK_VALUE2));	
		Mockito.verify(repo).updateTrainee(1L, MOCK_VALUE2);
	}
	@Test
	public void testDeleteTrainee() {
		Mockito.when(repo.deleteTrainee(1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.deleteTrainee(1L));	
		Mockito.verify(repo).deleteTrainee(1L);
	}
	@Test
	public void testGetAllTrainees() {
		Mockito.when(repo.getAllTrainees()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, service.getAllTrainees());	
	}




}
