package ru.startup.controller.entertainment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.startup.dto.entertainment.BilliardDTO;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.service.entertainment.BilliardService;

@RestController
public class BilliardController {

    private BilliardService billiardService;

    @Autowired
    public void setBilliardsService(BilliardService billiardService) {
        this.billiardService = billiardService;
    }

    @GetMapping("/api/billiard/{id}")
    public ResponseEntity<BilliardDTO> getBilliardsById(@PathVariable Long id) {
        if (!billiardService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(billiardService.getBilliardsById(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/billiard/{id}")
    public ResponseEntity<Void> deleteBilliardsById(@PathVariable Long id) {
        if (!billiardService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        billiardService.deleteBilliardsById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/billiard")
    public ResponseEntity<BilliardDTO> createBilliards(@RequestBody BilliardDTO billiardDTO, @RequestParam EntertainmentType entertainmentType) {
        if (billiardService.existsByName(billiardDTO.getName())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(billiardService.createBilliards(billiardDTO, entertainmentType), HttpStatus.CREATED);
    }
}
