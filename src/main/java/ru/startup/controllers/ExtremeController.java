package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.startup.dto.ExtremeDTO;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.service.ExtremeService;

@RestController
public class ExtremeController {

    private ExtremeService extremeService;

    @Autowired
    public void setExtremeService(ExtremeService extremeService) {
        this.extremeService = extremeService;
    }

    @GetMapping("/api/extreme/{id}")
    public ExtremeDTO getExtremeById(@PathVariable Long id){
        return extremeService.getExtremeById(id);
    }

    @DeleteMapping("/api/extreme/{id}")
    public void deleteExtremeById(@PathVariable Long id){
        extremeService.deleteExtremeById(id);
    }

    @PostMapping("/api/extreme")
    public ExtremeDTO createExtreme(@RequestBody ExtremeDTO extremeDTO, @RequestParam EntertainmentType entertainmentType){
        return extremeService.createExtreme(extremeDTO, entertainmentType);
    }
}
