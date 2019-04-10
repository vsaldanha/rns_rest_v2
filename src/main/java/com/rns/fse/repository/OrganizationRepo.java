package com.rns.fse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rns.fse.entities.OrganizationDetails;

@Repository
public interface OrganizationRepo extends JpaRepository<OrganizationDetails,Integer> {

	List<OrganizationDetails> findAll();
	OrganizationDetails findByOrganizationName(String name);
}
