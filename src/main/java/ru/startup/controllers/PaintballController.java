package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    public PaintballDTO getPaintballById(@PathVariable Long id){
        return paintballService.getPaintballById(id);
    }

    @DeleteMapping("/api/paintball/{id}")
    public void deletePaintballById(@PathVariable Long id){
        paintballService.deletePaintballById(id);
    }

    @PostMapping("/api/paintball")
    public PaintballDTO createMuseum(@RequestBody PaintballDTO paintballDTO, @RequestParam EntertainmentType entertainmentType){
        return paintballService.createPaintball(paintballDTO, entertainmentType);
    }
}
