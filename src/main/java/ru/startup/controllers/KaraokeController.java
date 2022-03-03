package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.startup.dto.KaraokeDTO;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.service.KaraokeService;

@RestController
public class KaraokeController {

    private KaraokeService karaokeService;

    @Autowired
    public void setKaraokeService(KaraokeService karaokeService) {
        this.karaokeService = karaokeService;
    }

    @GetMapping("/api/karaoke/{id}")
    public KaraokeDTO getKaraokeById(@PathVariable  Long id){
        return karaokeService.getKaraokeById(id);
    }

    @DeleteMapping("/api/karaoke/{id}")
    public void deleteKaraokeById(@PathVariable Long id){
        karaokeService.deleteKaraokeById(id);
    }

    @PostMapping("/api/karaoke")
    public KaraokeDTO createKaraoke(@RequestBody KaraokeDTO karaokeDTO, @RequestParam EntertainmentType entertainmentType){
        return karaokeService.createKaraoke(karaokeDTO, entertainmentType);
    }
}
