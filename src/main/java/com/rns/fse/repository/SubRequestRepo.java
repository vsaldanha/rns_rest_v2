package com.rns.fse.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rns.fse.constant.QueryConstants;
import com.rns.fse.entities.SubRequest;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Repository
public interface SubRequestRepo extends JpaRepository<SubRequest,Integer> {

	List<SubRequest> findAll();

	
	
}
