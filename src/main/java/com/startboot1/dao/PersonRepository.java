package com.startboot1.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.startboot1.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
	
	
	@Query("select p from Person p where p.emailid=:emailid")
	 public Person getUserByUserName(@Param("emailid") String emailid);
	}
