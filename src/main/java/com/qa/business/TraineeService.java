package com.qa.business;

import javax.inject.Inject;

import org.apache.log4j.Logger;


import com.qa.persistence.domain.Trainee;
import com.qa.persistence.repository.TraineeRepositoryImpl;


public class TraineeService implements TraineeServiceImpl {
	
	private static final Logger LOGGER = Logger.getLogger(TraineeService.class);
	
	@Inject
	private TraineeRepositoryImpl repo;
	


	public String createTrainee(String trainee) {

			return repo.createTrainee(trainee);
		
		
	}

	public String updateTrainee(long id, String newTrainee) {
		

			LOGGER.info("In AccountService updateAnAccount");
			return repo.updateTrainee(id,newTrainee);
	
		
		
	}

	public String deleteTrainee(long id) {
		LOGGER.info("In TraineeService deleteAccount");
		return repo.deleteTrainee(id);
	}

	public String getAllTrainees() {
		LOGGER.info("In TraineeService getAllTrainees");
		return repo.getAllTrainees();
	}

	public Trainee getTrainee(long id) {
		LOGGER.info("In TraineeService getTrainee");
		return repo.getTrainee(id);
	}
	
	public void setRepo(TraineeRepositoryImpl repo) {
		LOGGER.info("In TraineeService setRepo ");
		this.repo = repo;
	}


}
