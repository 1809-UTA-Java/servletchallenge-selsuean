package com.revature.ServletChallenge.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEES")
public class Employee {
	@Id
	@Column(name="ID")
	int id;
	
	@Column(name="NAME")
	String name;
	
	@Column(name="AGE")
	int age;
	
	@Column(name="JOB")
	String job;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="ANIMAL")
	Users user;
}

