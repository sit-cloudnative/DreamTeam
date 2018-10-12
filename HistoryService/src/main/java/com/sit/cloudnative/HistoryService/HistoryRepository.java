package com.sit.cloudnative.HistoryService;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    List<History> findByStudentIdAndVideoId(long studentId, long videoId);
}