package com.rns.fse.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OpenRequestsRepo {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional 
	public List<Object[]> fetchOpenRequest() {
		List<Object[]> results = entityManager.createNativeQuery("select * from rns.request where status = 'Open'").getResultList();
		return results;

	}

}
