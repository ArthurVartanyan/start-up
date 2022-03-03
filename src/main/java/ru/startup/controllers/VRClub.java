package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    public VRClubDTO getVRClubById(@PathVariable Long id){
        return vrClubService.getVRClubById(id);
    }

    @DeleteMapping("/api/vr-club/{id}")
    public void deleteVRClubById(@PathVariable Long id){
        vrClubService.deleteVRClubById(id);
    }

    @PostMapping("/api/vr-club")
    public VRClubDTO createVRClub(@RequestBody VRClubDTO vrClubDTO, @RequestParam EntertainmentType entertainmentType){
        return vrClubService.createVRClub(vrClubDTO, entertainmentType);
    }
}
