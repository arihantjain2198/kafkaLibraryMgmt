package com.demoProject.InsightGlobal.insightglobal.Controller;


import com.demoProject.InsightGlobal.insightglobal.Model.LibraryEventDto;
import com.demoProject.InsightGlobal.insightglobal.Model.LibraryEventType;
import com.demoProject.InsightGlobal.insightglobal.Producer.LibraryEventProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@Slf4j
public class LibraryEventController {
    @Autowired
    LibraryEventProducer libraryEventProducer;

    @PostMapping("/v1/libraryevent")
    public ResponseEntity<LibraryEventDto> postLibraryEvent(@RequestBody LibraryEventDto libraryEventDto) throws JsonProcessingException, ExecutionException, InterruptedException {


  //Approach Async    //  libraryEventProducer.sendLibraryEvent(libraryEventDto);
        libraryEventDto.setLibraryEventType(LibraryEventType.NEW);
          libraryEventProducer.sendLibraryEvent_Approch2(libraryEventDto); //Approach 2 Async
  // Approach Sync     // SendResult<Integer,String> sendResult = libraryEventProducer.sendLibraryEventSyncronous(libraryEventDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(libraryEventDto);
    }

}
