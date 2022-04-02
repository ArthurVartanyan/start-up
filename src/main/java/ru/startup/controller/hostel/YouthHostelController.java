package ru.startup.controller.hostel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.startup.dto.hostel.YouthHostelDTO;
import ru.startup.service.hostel.YouthHostelService;

@RestController
public class YouthHostelController {

    private YouthHostelService youthHostelService;

    @Autowired
    public void setYouthHostelService(YouthHostelService youthHostelService) {
        this.youthHostelService = youthHostelService;
    }

    @PostMapping("/youth-hostel")
    public ResponseEntity<Long> createYouthHostel(@RequestBody YouthHostelDTO youthHostelDTO) {
        return new ResponseEntity<>(youthHostelService.createYouthHostel(youthHostelDTO), HttpStatus.CREATED);
    }

    @GetMapping("/youth-hostel/{id}")
    public ResponseEntity<YouthHostelDTO> getYouthHostel(@PathVariable Long id) {
        return new ResponseEntity<>(youthHostelService.getYouthHostel(id), HttpStatus.OK);
    }

    @PostMapping("/youth-hostel/{id}")
    public ResponseEntity<Void> deleteYouthHostel(@PathVariable Long id) {
        youthHostelService.deleteYouthHostel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}