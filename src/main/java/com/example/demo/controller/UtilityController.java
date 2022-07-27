package com.example.demo.controller;

import com.example.demo.dto.StatisticsDto;
import com.example.demo.service.PersonService;
import com.example.demo.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class UtilityController {
    @Autowired
    PersonService personService;

    @Autowired
    UtilityService utilityService;

    @GetMapping("/statistics")
    public ResponseEntity<StatisticsDto> statistics(){
        return new ResponseEntity<>(utilityService.getStats(),HttpStatus.OK);
    }

    @GetMapping("/clear")
    public ResponseEntity<?> clear() {
        personService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
