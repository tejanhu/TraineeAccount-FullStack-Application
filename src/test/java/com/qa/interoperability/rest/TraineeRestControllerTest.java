package com.qa.interoperability.rest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.TraineeService;

@RunWith(MockitoJUnitRunner.class)
public class TraineeRestControllerTest {
	
	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private TraineeRestController restEndpoint;

	@Mock
	private TraineeService traineeService;

	@Before
	public void setup() {
		restEndpoint.setService(traineeService);
	}

	@Test
	public void testGetAllAccounts() {
		Mockito.when(traineeService.getAllTrainees()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, restEndpoint.getAllTrainees());
	}

	@Test
	public void testCreateAccount() {
		Mockito.when(traineeService.createTrainee(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, restEndpoint.createTrainee(MOCK_VALUE2));
		Mockito.verify(traineeService).createTrainee(MOCK_VALUE2);
	}

	@Test
	public void testUpdateAccount() {
		Mockito.when(traineeService.updateTrainee(1L, MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, restEndpoint.updateTrainee(1L, MOCK_VALUE2));
		Mockito.verify(traineeService).updateTrainee(1L, MOCK_VALUE2);
	}

	@Test
	public void testDeleteAccount() {
		Mockito.when(traineeService.deleteTrainee(1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, restEndpoint.deleteTrainee(1L));
		Mockito.verify(traineeService).deleteTrainee(1L);
	}

	

}
