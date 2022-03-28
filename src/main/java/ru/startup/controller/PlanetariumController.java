package ru.startup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<PlanetariumDTO> getPaintballById(@PathVariable Long id) {
        if (!planetariumService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(planetariumService.getPlanetariumById(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/planetarium/{id}")
    public ResponseEntity<Void> deletePlanetariumById(@PathVariable Long id) {
        if (!planetariumService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        planetariumService.deletePlanetariumById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/planetarium")
    public ResponseEntity<PlanetariumDTO> createPlanetarium(@RequestBody PlanetariumDTO planetariumDTO, @RequestParam EntertainmentType entertainmentType) {
        if (planetariumService.existsByName(planetariumDTO.getName())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(planetariumService.createPlanetarium(planetariumDTO, entertainmentType), HttpStatus.CREATED);
    }
}
