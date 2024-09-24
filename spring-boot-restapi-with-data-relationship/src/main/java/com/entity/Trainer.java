package com.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Trainer {
@Id
private int tid;
private String tname;
private String tech;
@JoinColumn(name = "tsid")   // This Column must be FK
@OneToMany(cascade = CascadeType.REMOVE)	// if we delete any trainer record automatically associated student record also delete. 
//@OneToMany(cascade = CascadeType.ALL)// through trainer object we can do all operation on student object. 
private List<Student> listOfStudent;
public List<Student> getListOfStudent() {
	return listOfStudent;
}
public void setListOfStudent(List<Student> listOfStudent) {
	this.listOfStudent = listOfStudent;
}
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}
public String getTech() {
	return tech;
}
public void setTech(String tech) {
	this.tech = tech;
}

}