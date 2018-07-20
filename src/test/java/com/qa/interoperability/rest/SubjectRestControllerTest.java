package com.qa.interoperability.rest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.SubjectService;

@RunWith(MockitoJUnitRunner.class)
public class SubjectRestControllerTest {
	
	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private SubjectRestController restEndpoint;

	@Mock
	private SubjectService subjectService;

	@Before
	public void setup() {
		restEndpoint.setService(subjectService);
	}

	@Test
	public void testGetAllAccounts() {
		Mockito.when(subjectService.getAllSubjects()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, restEndpoint.getAllSubjects());
	}

	@Test
	public void testCreateAccount() {
		Mockito.when(subjectService.createSubject(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, restEndpoint.createSubject(MOCK_VALUE2));
		Mockito.verify(subjectService).createSubject(MOCK_VALUE2);
	}

	@Test
	public void testUpdateAccount() {
		Mockito.when(subjectService.updateSubject(1L, MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, restEndpoint.updateSubject(1L, MOCK_VALUE2));
		Mockito.verify(subjectService).updateSubject(1L, MOCK_VALUE2);
	}

	@Test
	public void testDeleteAccount() {
		Mockito.when(subjectService.deleteSubject(1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, restEndpoint.deleteSubject(1L));
		Mockito.verify(subjectService).deleteSubject(1L);
	}

	

}
