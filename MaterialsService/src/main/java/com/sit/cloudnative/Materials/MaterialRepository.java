package com.sit.cloudnative.Materials;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {


	//Optional<List<Material>> findBySubjectId(String subjectId);

	List<Material> findAllBySubjectId(String subjectId);



}