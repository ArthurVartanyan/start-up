package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.startup.dto.BilliardsDTO;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.service.BilliardsService;

@RestController
public class BilliardsController {

    private BilliardsService billiardsService;

    @Autowired
    public void setBilliardsService(BilliardsService billiardsService) {
        this.billiardsService = billiardsService;
    }

    @GetMapping("/api/billiards/{id}")
    public BilliardsDTO getBilliardsById(@PathVariable Long id){
        return billiardsService.getBilliardsById(id);
    }

    @DeleteMapping("/api/billiards/{id}")
    public void deleteBilliardsById(@PathVariable Long id){
        billiardsService.deleteBilliardsById(id);
    }

    @PostMapping("/api/billiards")
    public BilliardsDTO createBilliards(@RequestBody BilliardsDTO billiardsDTO,@RequestParam EntertainmentType entertainmentType){
        return billiardsService.createBilliards(billiardsDTO, entertainmentType);
    }
}
