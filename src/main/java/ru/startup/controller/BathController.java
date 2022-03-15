package ru.startup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.startup.dto.BathDTO;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.service.BathService;

@RestController
public class BathController {

    private BathService bathService;

    @Autowired
    public void setBathService(BathService bathService) {
        this.bathService = bathService;
    }

    @GetMapping("/api/bath/{id}")
    public ResponseEntity<BathDTO> getBathById(@PathVariable Long id) {
        if (!bathService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bathService.getBathById(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/bath/{id}")
    public ResponseEntity<Void> deleteBathById(@PathVariable Long id) {
        if (!bathService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bathService.deleteBathById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/bath")
    public ResponseEntity<BathDTO> createBath(@RequestBody BathDTO bathDTO, @RequestParam EntertainmentType entertainmentType) {
        if (bathService.existByName(bathDTO.getName())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(bathService.createBath(bathDTO, entertainmentType), HttpStatus.CREATED);
    }
}
