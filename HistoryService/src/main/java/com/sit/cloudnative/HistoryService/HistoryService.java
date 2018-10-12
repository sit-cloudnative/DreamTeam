package com.sit.cloudnative.HistoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService{
    @Autowired
    private HistoryRepository historyRepository;

    public History findById(long id){
        History history = historyRepository.getOne(id);
        return history;
    }

    public long update(History history){
        return historyRepository.save(history).getVideoId();
    }

    public int getCheckpointInSecond(long studentId, long videoId){
        System.out.print("***************Im here***************");
        History historyObject = historyRepository.findByStudentIdAndVideoId(studentId, videoId);
        System.out.print("**********************************************");
        System.out.print(historyObject.getCheckpoint());
        System.out.print("**********************************************");
        int checkpointInSecond = historyObject.getCheckpoint();
        return checkpointInSecond;
    }
}