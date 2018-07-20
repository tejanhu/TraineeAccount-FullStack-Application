package com.qa.persistence.repository;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Subject;
import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtility;

@RunWith(MockitoJUnitRunner.class)
public class TraineeRepositoryTest {

	@InjectMocks
	private TraineeRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtility util;

	private static final String MOCK_DATA_ARRAY = "[{\"id\":0,\"firstName\":\"John\",\"familyName\":\"Doe\",\"subjects\":[]}]";

	private static final String MOCK_OBJECT = "{\"id\":0,\"firstName\":\"John\",\"familyName\":\"Doe\",\"subjects\":[]}";

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtility();
		repo.setUtil(util);
	}

	@Test
	public void testGetAllTrainees() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Trainee> trainees = new ArrayList<Trainee>();
		List<Subject> subjects = new ArrayList<Subject>();
		trainees.add(new Trainee("John", "Doe", subjects));
		Mockito.when(query.getResultList()).thenReturn(trainees);
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllTrainees());
	}

	@Test
	public void testCreateTrainee() {
		String reply = repo.createTrainee(MOCK_OBJECT);
		Assert.assertEquals(reply, com.qa.constants.Constants.CREATE_TRAINEE_MESSAGE);
	}

	@Test
	public void testUpdateTrainee() {
		String reply = repo.updateTrainee(1L, MOCK_OBJECT);
		Assert.assertEquals(reply, com.qa.constants.Constants.UPDATE_TRAINEE_MESSAGE);
	}

	@Test
	public void testDeleteTrainee() {
		String reply = repo.deleteTrainee(1L);
		Assert.assertEquals(reply, com.qa.constants.Constants.DELETE_TRAINEE_MESSAGE);
	}





}
