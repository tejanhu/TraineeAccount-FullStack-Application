package com.qa.persistence.repository;

import com.qa.persistence.domain.Trainee;

public interface TraineeRepositoryImpl {
	
	String createTrainee(String trainee);
	
	String updateTrainee(long id, String newTrainee);
	
	String deleteTrainee(long id);

	String getAllTrainees();
	
    Trainee getTrainee(long id);

}
