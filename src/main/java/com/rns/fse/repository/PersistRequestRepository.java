package com.rns.fse.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rns.fse.entities.Request;
import com.rns.fse.entities.SubRequest;

@Repository
public class PersistRequestRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public int persistRequest(Request request) {
			
			entityManager.persist(request);
			entityManager.flush();
			return request.getId();
	}
	
	public void persistSubRequest(SubRequest request) {
		
		entityManager.persist(request);
}

}
