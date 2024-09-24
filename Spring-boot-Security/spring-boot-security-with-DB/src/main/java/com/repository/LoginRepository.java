package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.LoginNew;

@Repository
public interface LoginRepository extends JpaRepository<LoginNew, String>{

}
