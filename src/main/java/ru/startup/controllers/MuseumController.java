package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.startup.dto.MuseumDTO;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.service.MuseumService;

@RestController
public class MuseumController {

    private MuseumService museumService;

    @Autowired
    public void setMuseumService(MuseumService museumService) {
        this.museumService = museumService;
    }

    @GetMapping("/api/museum/{id}")
    public MuseumDTO getMuseumById(@PathVariable Long id){
        return museumService.getMuseumById(id);
    }

    @DeleteMapping("/api/museum/{id}")
    public void deleteMuseumById(@PathVariable Long id){
        museumService.deleteMuseumById(id);
    }

    @PostMapping("/api/museum")
    public MuseumDTO createMuseum(@RequestBody MuseumDTO museumDTO, @RequestParam EntertainmentType entertainmentType){
        return museumService.createMuseum(museumDTO, entertainmentType);
    }
}
