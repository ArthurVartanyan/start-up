package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    public BowlingDTO getBowlingById(@PathVariable Long id){
        return bowlingService.getBowlingById(id);
    }

    @DeleteMapping("/api/bowling/{id}")
    public void deleteBowlingById(@PathVariable Long id){
        bowlingService.deleteBowlingById(id);
    }

    @PostMapping("/api/bowling")
    public BowlingDTO createBowling(@RequestBody BowlingDTO bowlingDTO, @RequestParam EntertainmentType entertainmentType){
        return bowlingService.createBowling(bowlingDTO, entertainmentType);
    }
}
