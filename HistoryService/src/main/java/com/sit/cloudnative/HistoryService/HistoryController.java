package com.sit.cloudnative.HistoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @PutMapping("/history/checkpoint")
    public ResponseEntity<Long> updateCheckpoint(@Validated @RequestBody History history) {
        return new ResponseEntity<>(historyService.update(history), HttpStatus.OK);
    }

    @GetMapping("/history/checkpoint")
    public ResponseEntity<Integer> getCheckpoint(@RequestParam("studentId") long studentId, @RequestParam("videoId") long videoId) {
        int checkpointInSecond = historyService.getCheckpointInSecond(studentId, videoId);
        return new ResponseEntity<Integer>(checkpointInSecond, HttpStatus.OK);
    }

}
