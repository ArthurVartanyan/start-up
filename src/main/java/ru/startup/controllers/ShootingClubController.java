package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ShootingClubDTO getShootingClubById(@PathVariable Long id){
        return shootingClubService.getShootingClubById(id);
    }

    @DeleteMapping("/api/shooting-club/{id}")
    public void deleteShootingClubById(@PathVariable Long id){
        shootingClubService.deleteShootingClubById(id);
    }

    @PostMapping("/api/shooting-club")
    public ShootingClubDTO createShootingClub(@RequestBody ShootingClubDTO shootingClubDTO, @RequestParam EntertainmentType entertainmentType){
        return shootingClubService.createShootingClub(shootingClubDTO, entertainmentType);
    }
}
