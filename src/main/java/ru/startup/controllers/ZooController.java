package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ZooDTO> getZooById(@PathVariable Long id){
        if (!zooService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(zooService.getZooById(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/zoo/{id}")
    public ResponseEntity<Void> deleteZooById(@PathVariable Long id){
        if (!zooService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        zooService.deleteZooById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/zoo")
    public ZooDTO createZoo(@RequestBody ZooDTO zooDTO, @RequestParam EntertainmentType entertainmentType){
        return zooService.createZoo(zooDTO, entertainmentType);
    }
}
