package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.startup.dto.VRClubDTO;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.service.VRClubService;

@RestController
public class VRClub {

    private VRClubService vrClubService;

    @Autowired
    public void setVrClubService(VRClubService vrClubService) {
        this.vrClubService = vrClubService;
    }

    @GetMapping("/api/vr-club/{id}")
    public ResponseEntity<VRClubDTO> getVRClubById(@PathVariable Long id){
        if (!vrClubService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(vrClubService.getVRClubById(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/vr-club/{id}")
    public ResponseEntity<Void> deleteVRClubById(@PathVariable Long id){
        if (!vrClubService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        vrClubService.deleteVRClubById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/vr-club")
    public VRClubDTO createVRClub(@RequestBody VRClubDTO vrClubDTO, @RequestParam EntertainmentType entertainmentType){
        return vrClubService.createVRClub(vrClubDTO, entertainmentType);
    }
}
