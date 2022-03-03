package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    public BathDTO getBathById(@PathVariable Long id){
        return bathService.getBathById(id);
    }

    @DeleteMapping("/api/bath/{id}")
    public void deleteBathById(@PathVariable Long id){
        bathService.deleteBathById(id);
    }

    @PostMapping("/api/bath")
    public BathDTO createBath(@RequestBody BathDTO bathDTO,@RequestParam EntertainmentType entertainmentType){
        return bathService.createBath(bathDTO, entertainmentType);
    }
}
