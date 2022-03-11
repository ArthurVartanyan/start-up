package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ExtremeDTO> getExtremeById(@PathVariable Long id){
        if (!extremeService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(extremeService.getExtremeById(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/extreme/{id}")
    public ResponseEntity<Void> deleteExtremeById(@PathVariable Long id){
        if (!extremeService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        extremeService.deleteExtremeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/extreme")
    public ExtremeDTO createExtreme(@RequestBody ExtremeDTO extremeDTO, @RequestParam EntertainmentType entertainmentType){
        return extremeService.createExtreme(extremeDTO, entertainmentType);
    }
}
