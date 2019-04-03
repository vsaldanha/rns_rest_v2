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
	
	@Transactional 
	public List<Object[]> fetchAllRequest() {
		List<Object[]> results = entityManager.createNativeQuery("select req.event_type, req.event_date, sreq.class_grade, sreq.subject, sreq.time_period, sreq.status from rns.request req, rns.sub_request sreq where req.request_id=sreq.request_id").getResultList();
		return results;

	}

}
