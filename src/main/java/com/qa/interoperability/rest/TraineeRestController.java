package com.qa.interoperability.rest;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.qa.business.TraineeService;

import com.qa.persistence.domain.Trainee;

@Path("/trainee")
public class TraineeRestController {
	
	private static final Logger LOGGER = Logger.getLogger(TraineeRestController.class);

	@Inject
	private TraineeService traineeService;
	
	@Path("/json/{id}")
	@GET
	@Produces({"application/json"})
	public Trainee getTrainee(@PathParam("id") long id){
		LOGGER.info("In TraineeRestController getTrainee");
		return traineeService.getTrainee(id);
	}
	
	@Path("/json")
	@GET
	@Produces({"application/json"})
	public String getAllTrainees(){
		LOGGER.info("In TraineeRestController getAllTrainees");
		return traineeService.getAllTrainees();
	}
	
	@Path("/json")
	@POST
	@Produces({"application/json"})
	public String createTrainee(String trainee){
		LOGGER.info("In TraineeRestController createTrainee");
		return traineeService.createTrainee(trainee);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateTrainee(@PathParam("id") long id, String newTrainee){
		LOGGER.info("In TraineeRestController updateTrainee");
		return traineeService.updateTrainee(id, newTrainee);
	}
	
	@Path("/json/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteTrainee(@PathParam("id") long id){
		LOGGER.info("In TraineeRestController deleteTrainee");
		return traineeService.deleteTrainee(id);
	}
	
	public void setService(TraineeService traineeService) {
		this.traineeService = traineeService;
	}
	

}
