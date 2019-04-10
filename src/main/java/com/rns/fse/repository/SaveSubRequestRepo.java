package com.rns.fse.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rns.fse.entities.SubRequest;

@Repository
public class SaveSubRequestRepo {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void saveSubRequest(SubRequest subRequest){
		entityManager.persist(subRequest);
	}


}
