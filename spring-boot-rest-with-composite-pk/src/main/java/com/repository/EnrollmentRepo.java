package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Enrollment;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Integer>{

}
