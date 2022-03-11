package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.startup.dto.BowlingDTO;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.service.BowlingService;

@RestController
public class BowlingController {

    private BowlingService bowlingService;

    @Autowired
    public void setBowlingService(BowlingService bowlingService) {
        this.bowlingService = bowlingService;
    }

    @GetMapping("/api/bowling/{id}")
    public ResponseEntity<BowlingDTO> getBowlingById(@PathVariable Long id){
        if (!bowlingService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(bowlingService.getBowlingById(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/bowling/{id}")
    public ResponseEntity<Void> deleteBowlingById(@PathVariable Long id){
        if (!bowlingService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        bowlingService.deleteBowlingById(id);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/api/bowling")
    public BowlingDTO createBowling(@RequestBody BowlingDTO bowlingDTO, @RequestParam EntertainmentType entertainmentType){
        return bowlingService.createBowling(bowlingDTO, entertainmentType);
    }
}
