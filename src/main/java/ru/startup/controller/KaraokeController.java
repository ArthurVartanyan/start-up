package ru.startup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<KaraokeDTO> getKaraokeById(@PathVariable Long id) {
        if (!karaokeService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(karaokeService.getKaraokeById(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/karaoke/{id}")
    public ResponseEntity<Void> deleteKaraokeById(@PathVariable Long id) {
        if (!karaokeService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        karaokeService.deleteKaraokeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/karaoke")
    public ResponseEntity<KaraokeDTO> createKaraoke(@RequestBody KaraokeDTO karaokeDTO, @RequestParam EntertainmentType entertainmentType) {
        if (karaokeService.existsByName(karaokeDTO.getName())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(karaokeService.createKaraoke(karaokeDTO, entertainmentType), HttpStatus.CREATED);
    }
}
