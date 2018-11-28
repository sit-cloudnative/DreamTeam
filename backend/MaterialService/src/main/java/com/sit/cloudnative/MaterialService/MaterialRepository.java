package com.sit.cloudnative.MaterialService;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
    public List<Material> findBySubjectCode(String subjectCode);
}
