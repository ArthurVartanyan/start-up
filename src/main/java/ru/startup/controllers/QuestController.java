package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    public QuestDTO getQuestById(@PathVariable Long id){
        return questService.getQuestById(id);
    }

    @DeleteMapping("/api/quest/{id}")
    public void deleteQuestById(@PathVariable Long id){
        questService.deleteQuestById(id);
    }

    @PostMapping("/api/quest")
    public QuestDTO createPottery(@RequestBody QuestDTO questDTO, @RequestParam EntertainmentType entertainmentType){
        return questService.createQuest(questDTO, entertainmentType);
    }
}
