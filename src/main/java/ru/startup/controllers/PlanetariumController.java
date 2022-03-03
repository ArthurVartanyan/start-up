package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.startup.dto.PlanetariumDTO;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.service.PlanetariumService;

@RestController
public class PlanetariumController {

    private PlanetariumService planetariumService;

    @Autowired
    public void setPlanetariumService(PlanetariumService planetariumService) {
        this.planetariumService = planetariumService;
    }

    @GetMapping("/api/planetarium/{id}")
    public PlanetariumDTO getPaintballById(@PathVariable Long id){
        return planetariumService.getPlanetariumById(id);
    }

    @DeleteMapping("/api/planetarium/{id}")
    public void deletePlanetariumById(@PathVariable Long id){
        planetariumService.deletePlanetariumById(id);
    }

    @PostMapping("/api/planetarium")
    public PlanetariumDTO createPlanetarium(@RequestBody PlanetariumDTO planetariumDTO, @RequestParam EntertainmentType entertainmentType){
        return planetariumService.createPlanetarium(planetariumDTO, entertainmentType);
    }
}
