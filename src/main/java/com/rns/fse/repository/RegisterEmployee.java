package com.rns.fse.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rns.fse.entities.EmployeeDetails;
import com.rns.fse.entities.UserInfo;

@Repository
public class RegisterEmployee {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional 
	public void registerEmp(EmployeeDetails employee){
		entityManager.persist(employee);
	}
}
