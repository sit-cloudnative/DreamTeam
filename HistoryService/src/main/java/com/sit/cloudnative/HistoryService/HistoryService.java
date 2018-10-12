package com.sit.cloudnative.HistoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    public History findById(long id) {
        History history = historyRepository.getOne(id);
        return history;
    }

    public long update(History history) {
        return historyRepository.save(history).getVideoId();
    }

    public int getCheckpointInSecond(long studentId, long videoId) {
        int checkpointInSecond;
        try {
            List<History> historyList = historyRepository.findByStudentIdAndVideoId(studentId, videoId);
            History historyObject = historyList.get(0);
            checkpointInSecond = historyObject.getCheckpoint();
        } catch (NullPointerException e) {
            checkpointInSecond = -1;
        }
        return checkpointInSecond;
    }

}