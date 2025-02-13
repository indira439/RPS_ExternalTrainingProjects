package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Trainer;
import com.repository.TrainerRepository;

@Service
public class TrainerService {

	@Autowired
	TrainerRepository trainerRepository;
	
	public List<String> findAllTrainers() {
		return trainerRepository.findTrainerName();
	}
	
	
	public List<Object[]> findTraienrNameAndTech() {
		return trainerRepository.findTrainerNameAndTech();
	}
	public List<Trainer> findAllTech(String tech) {
		return trainerRepository.findTrainerByTech(tech);
	}
	
	public List<Trainer> findAll() {
		return trainerRepository.findAll();
	}
	
	
	
	public String storeTrainer(Trainer trainer) {
		Optional<Trainer> result = trainerRepository.findById(trainer.getTid());
		if(result.isPresent()) {
			return "TId must be unique";
		}else {
			trainerRepository.save(trainer);
			return "Trainer Record stored successfuly";
		}
	}
	
	public String deleteTraienr(int tid) {
		Optional<Trainer> result = trainerRepository.findById(tid);
		if(result.isPresent()) {
			trainerRepository.deleteById(tid);
			return "Trainer record deleted successfully";
		}else {
			return "Trainer record not present";
		}
	}
	
	public String updateTrainer(Trainer trainer) {
		Optional<Trainer> result = trainerRepository.findById(trainer.getTid());
		if(result.isPresent()) {
			Trainer t = result.get();
			t.setTech(trainer.getTech());
			trainerRepository.saveAndFlush(t);
			return "Trainer details updated successfully";
		}else {
			return "Trainer record not present";
		}
	}

}