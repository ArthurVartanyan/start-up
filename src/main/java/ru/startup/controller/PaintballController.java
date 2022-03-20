package ru.startup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.startup.dto.PaintballDTO;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.service.PaintballService;

@RestController
public class PaintballController {

    private PaintballService paintballService;

    @Autowired
    public void setPaintballService(PaintballService paintballService) {
        this.paintballService = paintballService;
    }

    @GetMapping("/api/paintball/{id}")
    public ResponseEntity<PaintballDTO> getPaintballById(@PathVariable Long id) {
        if (!paintballService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paintballService.getPaintballById(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/paintball/{id}")
    public ResponseEntity<Void> deletePaintballById(@PathVariable Long id) {
        if (!paintballService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        paintballService.deletePaintballById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/paintball")
    public ResponseEntity<PaintballDTO> createMuseum(@RequestBody PaintballDTO paintballDTO, @RequestParam EntertainmentType entertainmentType) {
        if (paintballService.existsByName(paintballDTO.getName())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(paintballService.createPaintball(paintballDTO, entertainmentType), HttpStatus.CREATED);
    }
}
