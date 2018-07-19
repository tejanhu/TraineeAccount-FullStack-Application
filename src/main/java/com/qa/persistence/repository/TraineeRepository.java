package com.qa.persistence.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.constants.Constants;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import com.qa.util.JSONUtility;
import com.qa.persistence.domain.Trainee;



@Transactional(REQUIRED)
public class TraineeRepository implements TraineeRepositoryImpl{
	
//	private static final Logger LOGGER = Logger.getLogger(TraineeRepositoryTest.class);
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtility util;

	
	public String createTrainee(String account) {
		Trainee aTrainee = util.getObjectForJGson(account,Trainee.class);
		em.persist(aTrainee);
//		LOGGER.info("In TraineeRepository createAnTrainee");
		return Constants.CREATE_TRAINEE_MESSAGE;
	}
	
	public String updateTrainee(long id, String newTrainee) {
		Trainee updatedTrainee = util.getObjectForJGson(newTrainee, Trainee.class);
		Trainee traineeInDB = getTrainee(id);
		if(traineeInDB !=null) {
			traineeInDB = updatedTrainee;
			traineeInDB.setID(id);
			em.merge(traineeInDB);
//			LOGGER.info("In TraineeRepository updateAnTrainee");
		}
//		LOGGER.info("In TraineeRepository updateAnTrainee");
		return Constants.UPDATE_TRAINEE_MESSAGE;
	}
	
	public String deleteTrainee(long id) {
		Trainee traineeInDB = getTrainee(id);
		if(traineeInDB!=null) {
			em.remove(traineeInDB);
//			LOGGER.info("In TraineeRepository deleteTrainee");
		}
//		LOGGER.info("In TraineeRepository deleteTrainee");
		return Constants.DELETE_TRAINEE_MESSAGE;
	}

	@Transactional(SUPPORTS)	
	public String getAllTrainees() {
//		LOGGER.info("In TraineeRepository getAllTrainees");
        return util.getJGsonForObject(em.createQuery("SELECT t FROM Trainee t").getResultList());
	}
	
	@Transactional(SUPPORTS)
    public Trainee getTrainee(long id) {
//		LOGGER.info("In TraineeRepository getTrainee");
        return em.find(Trainee.class, id);
    }

	public void setManager(EntityManager em) {
		this.em = em;
	}

	public void setUtil(JSONUtility util) {
		this.util = util;
	}



}
