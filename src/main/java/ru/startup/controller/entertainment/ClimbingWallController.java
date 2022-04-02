package ru.startup.controller.entertainment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.startup.dto.entertainment.ClimbingWallDTO;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.service.entertainment.ClimbingWallService;

@RestController
public class ClimbingWallController {

    private ClimbingWallService climbingWallService;

    @Autowired
    public void setClimbingWallService(ClimbingWallService climbingWallService) {
        this.climbingWallService = climbingWallService;
    }

    @GetMapping("/api/climbing-wall/{id}")
    public ResponseEntity<ClimbingWallDTO> getClimbingWallById(@PathVariable Long id) {
        if (!climbingWallService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(climbingWallService.getClimbingWallById(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/climbing-wall/{id}")
    public ResponseEntity<Void> deleteClimbingWallById(@PathVariable Long id) {
        if (!climbingWallService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        climbingWallService.deleteClimbingWallById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/climbing-wall")
    public ResponseEntity<ClimbingWallDTO> createClimbingWall(@RequestBody ClimbingWallDTO climbingWallDTO, @RequestParam EntertainmentType entertainmentType) {
        if (climbingWallService.existsByName(climbingWallDTO.getName())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(climbingWallService.createClimbingWall(climbingWallDTO, entertainmentType), HttpStatus.CREATED);
    }
}
