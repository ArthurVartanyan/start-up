package ru.startup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.startup.dto.QuestDTO;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.service.QuestService;

@RestController
public class QuestController {

    private QuestService questService;

    @Autowired
    public void setQuestService(QuestService questService) {
        this.questService = questService;
    }

    @GetMapping("/api/quest/{id}")
    public ResponseEntity<QuestDTO> getQuestById(@PathVariable Long id) {
        if (!questService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(questService.getQuestById(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/quest/{id}")
    public ResponseEntity<Void> deleteQuestById(@PathVariable Long id) {
        if (!questService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        questService.deleteQuestById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/quest")
    public ResponseEntity<QuestDTO> createPottery(@RequestBody QuestDTO questDTO, @RequestParam EntertainmentType entertainmentType) {
        if (questService.existsByName(questDTO.getName())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(questService.createQuest(questDTO, entertainmentType), HttpStatus.CREATED);
    }
}
