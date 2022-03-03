package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.startup.dto.MassageDTO;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.service.MassageService;

@RestController
public class MassageController {

    private MassageService massageService;

    @Autowired
    public void setMassageService(MassageService massageService) {
        this.massageService = massageService;
    }

    @GetMapping("/api/massage/{id}")
    public MassageDTO getMassageById(@PathVariable Long id){
        return massageService.getMassageById(id);
    }

    @DeleteMapping("/api/massage/{id}")
    public void deleteMassageById(@PathVariable Long id){
        massageService.deleteMassageById(id);
    }

    @PostMapping("/api/massage")
    public MassageDTO createMassage(@RequestBody MassageDTO massageDTO, @RequestParam EntertainmentType entertainmentType){
        return massageService.createMassage(massageDTO, entertainmentType);
    }
}
