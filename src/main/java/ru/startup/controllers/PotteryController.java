package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.startup.dto.PotteryDTO;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.service.PotteryService;

@RestController
public class PotteryController {

    private PotteryService potteryService;

    @Autowired
    public void setPotteryService(PotteryService potteryService) {
        this.potteryService = potteryService;
    }

    @GetMapping("/api/pottery/{id}")
    public ResponseEntity<PotteryDTO> getPotteryById(@PathVariable Long id){
        if (!potteryService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(potteryService.getPotteryById(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/pottery/{id}")
    public ResponseEntity<Void> deletePotteryById(@PathVariable Long id){
        if (!potteryService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        potteryService.deletePotteryById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/pottery")
    public PotteryDTO createPottery(@RequestBody PotteryDTO potteryDTO, @RequestParam EntertainmentType entertainmentType){
        return potteryService.createPottery(potteryDTO, entertainmentType);
    }
}
