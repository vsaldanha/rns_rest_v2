package com.rns.fse.repository;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.springframework.boot.web.servlet.server.Session;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rns.fse.entities.SubRequest;
import com.rns.fse.pojo.SubRequestModel;
import com.rns.fse.pojo.TestObj;
import com.rns.fse.pojo.TrendingOrgModel;

@Repository
public class TrendingOrgRepo {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional 
	public List<Object[]> findOrganizationNameAndSumTimePeriod() {
		
		List<Object[]> results = entityManager.createNativeQuery("select organization_name as name, SUM (time_period) as time from rns.sub_request where status = 'Pass' group by organization_name order by time desc").getResultList();
		
/*		Session session = entityManager.unwrap(Session.class); 
		Query query = entityManager.createNativeQuery("select organization_name as name, SUM (time_period) as time from rns.sub_request group by organization_name");
		entityManager.createNativeQuery(sqlString, resultSetMapping);*/
		return results;

	}
	
	@Transactional 
	public List<Object[]> findVolunteerNameAndSumTimePeriod() {
		List<Object[]> results = entityManager.createNativeQuery("select volunteer_name as name,organization_name as org_name, SUM (time_period) as time from rns.sub_request where status = 'Pass' group by volunteer_name,organization_name order by time desc limit 5").getResultList();
		return results;

	}

}
