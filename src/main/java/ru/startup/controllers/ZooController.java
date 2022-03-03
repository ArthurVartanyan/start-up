package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.startup.dto.ZooDTO;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.service.ZooService;

@RestController
public class ZooController {

    private ZooService zooService;

    @Autowired
    public void setZooService(ZooService zooService) {
        this.zooService = zooService;
    }

    @GetMapping("/api/zoo/{id}")
    public ZooDTO getZooById(@PathVariable Long id){
        return zooService.getZooById(id);
    }

    @DeleteMapping("/api/zoo/{id}")
    public void deleteZooById(@PathVariable Long id){
        zooService.deleteZooById(id);
    }

    @PostMapping("/api/zoo")
    public ZooDTO createZoo(@RequestBody ZooDTO zooDTO, @RequestParam EntertainmentType entertainmentType){
        return zooService.createZoo(zooDTO, entertainmentType);
    }
}
