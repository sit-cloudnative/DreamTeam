package com.sit.cloudnative.HistoryService;

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
}