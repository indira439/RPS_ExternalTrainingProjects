package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	@Modifying
	@Query("delete from Student s where s.age > :age")
	public int deleteStudentById(@Param("age") int age);

}