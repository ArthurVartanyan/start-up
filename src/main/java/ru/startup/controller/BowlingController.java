package ru.startup.controller;

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
    public ResponseEntity<BowlingDTO> getBowlingById(@PathVariable Long id) {
        if (!bowlingService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bowlingService.getBowlingById(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/bowling/{id}")
    public ResponseEntity<Void> deleteBowlingById(@PathVariable Long id) {
        if (!bowlingService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bowlingService.deleteBowlingById(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/api/bowling")
    public ResponseEntity<BowlingDTO> createBowling(@RequestBody BowlingDTO bowlingDTO, @RequestParam EntertainmentType entertainmentType) {
        if (bowlingService.existsByName(bowlingDTO.getName())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(bowlingService.createBowling(bowlingDTO, entertainmentType), HttpStatus.CREATED);
    }
}
