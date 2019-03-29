package com.rns.fse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rns.fse.entities.SchoolDetails;

@Repository
public interface SchoolDetailsRepo extends JpaRepository<SchoolDetails,Integer> {
	
	List<SchoolDetails> findAll();
	SchoolDetails findById(int y);
	SchoolDetails findBySchoolName(String name);

}
