package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<MuseumDTO> getMuseumById(@PathVariable Long id){
        if (!museumService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(museumService.getMuseumById(id),HttpStatus.OK);
    }

    @DeleteMapping("/api/museum/{id}")
    public ResponseEntity<Void> deleteMuseumById(@PathVariable Long id){
        if (!museumService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        museumService.deleteMuseumById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/museum")
    public MuseumDTO createMuseum(@RequestBody MuseumDTO museumDTO, @RequestParam EntertainmentType entertainmentType){
        return museumService.createMuseum(museumDTO, entertainmentType);
    }
}
