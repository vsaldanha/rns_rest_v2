package com.rns.fse.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rns.fse.entities.UserInfo;

@Repository
public class UserInfoRepo {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional 
	public Object fetchUserInfo(String UserName, String password)
	{
		Query query = entityManager.createNativeQuery("select user_role from rns.user where user_name = :UserName and password = :password");
		query.setParameter("UserName", UserName);
        query.setParameter("password", password);

        Object role = query.getSingleResult();
		return role;
	}
	
	@Transactional
	public void registerUser(UserInfo userInfo){
		entityManager.persist(userInfo);
	}

}
