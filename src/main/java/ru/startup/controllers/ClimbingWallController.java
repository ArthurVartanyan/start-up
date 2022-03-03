package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.startup.dto.ClimbingWallDTO;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.service.ClimbingWallService;

@RestController
public class ClimbingWallController {

    private ClimbingWallService climbingWallService;

    @Autowired
    public void setClimbingWallService(ClimbingWallService climbingWallService) {
        this.climbingWallService = climbingWallService;
    }

    @GetMapping("/api/climbing-wall/{id}")
    public ClimbingWallDTO getClimbingWallById(@PathVariable Long id){
        return climbingWallService.getClimbingWallById(id);
    }

    @DeleteMapping("/api/climbing-wall/{id}")
    public void deleteClimbingWallById(@PathVariable Long id){
        climbingWallService.deleteClimbingWallById(id);
    }

    @PostMapping("/api/climbing-wall")
    public ClimbingWallDTO createClimbingWall(@RequestBody ClimbingWallDTO climbingWallDTO, @RequestParam EntertainmentType entertainmentType){
        return climbingWallService.createClimbingWall(climbingWallDTO, entertainmentType);
    }
}
