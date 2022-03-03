package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    public PotteryDTO getPotteryById(@PathVariable Long id){
        return potteryService.getPotteryById(id);
    }

    @DeleteMapping("/api/pottery/{id}")
    public void deletePotteryById(@PathVariable Long id){
        potteryService.deletePotteryById(id);
    }

    @PostMapping("/api/pottery")
    public PotteryDTO createPottery(@RequestBody PotteryDTO potteryDTO, @RequestParam EntertainmentType entertainmentType){
        return potteryService.createPottery(potteryDTO, entertainmentType);
    }
}
