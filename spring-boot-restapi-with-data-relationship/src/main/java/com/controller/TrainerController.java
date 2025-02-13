
package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeEditor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Trainer;
import com.service.TrainerService;

@RestController
public class TrainerController {

	@Autowired
	TrainerService trainerService;
	// http://localhost:8080/trainers 
	@RequestMapping(value = "trainers",
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	public List<Trainer> findAll() {
		return trainerService.findAll();
	}
	
	@RequestMapping(value = "trainersfindbytech/{tech}",
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	public List<Trainer> findAllByTech(@PathVariable("tech") String tech) {
		return trainerService.findAllTech(tech);
	}
	
	
	@RequestMapping(value = "trainersnames",
			method = RequestMethod.GET)
	public List<String> findAllTrainerNames() {
		return trainerService.findAllTrainers();
	}
	
	
	@RequestMapping(value = "trainersnamesandtech",
			method = RequestMethod.GET)
	public List<Object[]> findAllTrainerNameAndTech() {
		return trainerService.findTraienrNameAndTech();
	}
	
	@RequestMapping(value = "storetrainer",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeTrainer(@RequestBody Trainer trainer) {
		return trainerService.storeTrainer(trainer);
	}
	
	@RequestMapping(value = "updatetrainer",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateTrainer(@RequestBody Trainer trainer) {
		return trainerService.updateTrainer(trainer);
	}
	
	@RequestMapping(value = "deletetrainer/{tid}",
			method = RequestMethod.DELETE)
	public String deleteTrainer(@PathVariable("tid") int tid) {
		return trainerService.deleteTraienr(tid);
	}
}
