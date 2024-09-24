package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer>{
	
	@Query("Select t from Trainer t where t.tech = :technology")
	public List<Trainer> findTrainerByTech(@Param("technology") String tech);
	
	@Query("select t.tname from Trainer t")
	public 	List<String> findTrainerName();
	
	@Query("select t.tname, t.tech from Trainer t")
	public 	List<Object[]>	findTrainerNameAndTech();

}