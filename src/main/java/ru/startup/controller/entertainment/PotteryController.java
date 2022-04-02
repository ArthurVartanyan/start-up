package ru.startup.controller.entertainment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.startup.dto.entertainment.PotteryDTO;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.service.entertainment.PotteryService;

@RestController
public class PotteryController {

    private PotteryService potteryService;

    @Autowired
    public void setPotteryService(PotteryService potteryService) {
        this.potteryService = potteryService;
    }

    @GetMapping("/api/pottery/{id}")
    public ResponseEntity<PotteryDTO> getPotteryById(@PathVariable Long id) {
        if (!potteryService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(potteryService.getPotteryById(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/pottery/{id}")
    public ResponseEntity<Void> deletePotteryById(@PathVariable Long id) {
        if (!potteryService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        potteryService.deletePotteryById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/pottery")
    public ResponseEntity<PotteryDTO> createPottery(@RequestBody PotteryDTO potteryDTO, @RequestParam EntertainmentType entertainmentType) {
        if (potteryService.existsByName(potteryDTO.getName())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(potteryService.createPottery(potteryDTO, entertainmentType), HttpStatus.CREATED);
    }
}
