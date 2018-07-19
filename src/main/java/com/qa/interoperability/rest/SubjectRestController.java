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

import com.qa.business.SubjectService;
import com.qa.persistence.domain.Subject;
	@Path("/subject")
	public class SubjectRestController {
		
		private static final Logger LOGGER = Logger.getLogger(SubjectRestController.class);

		@Inject
		private SubjectService subjectService;
		
		@Path("/json/{id}")
		@GET
		@Produces({"application/json"})
		public Subject getSubject(@PathParam("id") long id){
			LOGGER.info("In SubjectRestController getSubject");
			return subjectService.getSubject(id);
		}
		
		@Path("/json")
		@GET
		@Produces({"application/json"})
		public String getAllSubjects(){
			LOGGER.info("In SubjectRestController getAllSubjects");
			return subjectService.getAllSubjects();
		}
		
		@Path("/json")
		@POST
		@Produces({"application/json"})
		public String createSubject(String subject){
			LOGGER.info("In SubjectRestController createSubject");
			return subjectService.createSubject(subject);
		}
		
		@Path("/json/{id}")
		@PUT
		@Produces({"application/json"})
		public String updateSubject(@PathParam("id") long id, String newSubject){
			LOGGER.info("In SubjectRestController updateSubject");
			return subjectService.updateSubject(id, newSubject);
		}
		
		@Path("/json/{id}")
		@DELETE
		@Produces({"application/json"})
		public String deleteSubject(@PathParam("id") long id){
			LOGGER.info("In SubjectRestController deleteSubject");
			return subjectService.deleteSubject(id);
		}
		
		public void setService(SubjectService SubjectRestController) {
			this.subjectService = SubjectRestController;
		}
		

	
}
