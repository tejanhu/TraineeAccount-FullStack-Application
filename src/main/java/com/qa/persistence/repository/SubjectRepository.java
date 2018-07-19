package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.constants.Constants;
import com.qa.persistence.domain.Subject;
import com.qa.util.JSONUtility;

@Transactional(REQUIRED)
public class SubjectRepository implements SubjectRepositoryImpl{
	
//	private static final Logger LOGGER = Logger.getLogger(TransactionRepositoryTest.class);
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtility util;

	public String createSubject(String transaction) {
		Subject aTransaction = util.getObjectForJGson(transaction,Subject.class);
		em.persist(aTransaction);
//		LOGGER.info("In TransactionRepository createTransaction");
		return Constants.CREATE_SUBJECT_MESSAGE;
	}

	public String updateSubject(long id, String newTransaction) {
		Subject updatedSubject = util.getObjectForJGson(newTransaction, Subject.class);
		Subject subjectInDB = getSubject(id);
		if(subjectInDB !=null) {
			subjectInDB = updatedSubject;
			em.persist(subjectInDB);
//			LOGGER.info("In TransactionRepository updateTransaction");
		}
//		LOGGER.info("In TransactionRepository updateTransaction");
		return Constants.UPDATE_SUBJECT_MESSAGE;
	}

	public String deleteSubject(long id) {
		Subject subjectInDB = getSubject(id);
		if(subjectInDB!=null) {
			em.remove(subjectInDB);
//			LOGGER.info("In TransactionRepository deleteTransaction");
		}
//		LOGGER.info("In TransactionRepository deleteTransaction");
		return Constants.DELETE_SUBJECT_MESSAGE;
	}
	@Transactional(SUPPORTS)
	public String getAllSubjects() {
//		LOGGER.info("In TransactionRepository getAllTransactions");
		 return util.getJGsonForObject(em.createQuery("SELECT s FROM Subject s").getResultList());
	}
	@Transactional(SUPPORTS)
	public Subject getSubject(long id) {
//		LOGGER.info("In TransactionRepository getTransaction");
		return em.find(Subject.class, id);
	}
	
	public void setManager(EntityManager em) {
		this.em = em;
	}

	public void setUtil(JSONUtility util) {
		this.util = util;
	}

	

}
