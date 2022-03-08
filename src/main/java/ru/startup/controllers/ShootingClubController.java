package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.startup.dto.ShootingClubDTO;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.service.ShootingClubService;

@RestController
public class ShootingClubController {

    private ShootingClubService shootingClubService;

    @Autowired
    public void setShootingClubService(ShootingClubService shootingClubService) {
        this.shootingClubService = shootingClubService;
    }

    @GetMapping("/api/shooting-club/{id}")
    public ResponseEntity<ShootingClubDTO> getShootingClubById(@PathVariable Long id){
        if (!shootingClubService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(shootingClubService.getShootingClubById(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/shooting-club/{id}")
    public ResponseEntity<Void> deleteShootingClubById(@PathVariable Long id){
        if (!shootingClubService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        shootingClubService.deleteShootingClubById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/shooting-club")
    public ShootingClubDTO createShootingClub(@RequestBody ShootingClubDTO shootingClubDTO, @RequestParam EntertainmentType entertainmentType){
        return shootingClubService.createShootingClub(shootingClubDTO, entertainmentType);
    }
}
