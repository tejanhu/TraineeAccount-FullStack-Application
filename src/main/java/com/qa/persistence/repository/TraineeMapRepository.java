package com.qa.persistence.repository;

import java.util.HashMap;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.qa.constants.Constants;
import com.qa.util.JSONUtility;
import com.qa.persistence.domain.Trainee;

@ApplicationScoped
@Alternative
public class TraineeMapRepository implements TraineeRepositoryImpl{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtility util;	
	
	private HashMap<Long,Trainee> traineeHashMap;
	
	private long ID;
	
	public TraineeMapRepository() {
		this.traineeHashMap = new HashMap<Long, Trainee>();
		ID = 1;
	}
	
	public String createTrainee(String Trainee) {
		Trainee aTrainee = util.getObjectForJGson(Trainee,Trainee.class);
		aTrainee.setID(ID);
		traineeHashMap.put(ID, aTrainee);
		ID++;
		return Trainee;
	}
	
	public String updateTrainee(long id, String newTrainee) {
		Trainee updatedTrainee = util.getObjectForJGson(newTrainee, Trainee.class);
		updatedTrainee.setID(id);
		traineeHashMap.put(id,updatedTrainee);
		return Constants.UPDATE_TRAINEE_MESSAGE;
	}
	
	public String deleteTrainee(long id) {
		traineeHashMap.remove(id);
		return Constants.DELETE_TRAINEE_MESSAGE;
	}

		
	public String getAllTrainees() {
        return util.getJGsonForObject(traineeHashMap.values());
	}
	
	
    public Trainee getTrainee(long id) {
        return traineeHashMap.get(id);
    }

    

}
