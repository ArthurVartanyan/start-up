package ru.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.QuestDTO;
import ru.startup.mapper.EntertainmentMapper;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.model.entertainment.Quest;
import ru.startup.repository.QuestRepository;

@Service
public class QuestService {

    private QuestRepository questRepository;

    private EntertainmentMapper entertainmentMapper;

    @Autowired
    public void setEntertainmentMapper(EntertainmentMapper entertainmentMapper) {
        this.entertainmentMapper = entertainmentMapper;
    }

    @Autowired
    public void setQuestRepository(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }

    public QuestDTO getQuestById(Long id) {
        return entertainmentMapper.map(questRepository.getQuestByIdAndDeletedIsFalse(id));
    }

    public void deleteQuestById(Long id) {
        Quest quest = questRepository.getById(id);
        quest.setDeleted(true);
        questRepository.save(quest);
    }

    public boolean existsById(Long id) {
        return questRepository.existsById(id);
    }

    public boolean existsByName(String name) {
        return questRepository.existsByNameAndDeletedIsFalse(name);
    }

    public QuestDTO createQuest(QuestDTO questDTO, EntertainmentType entertainmentType) {
        Quest quest = entertainmentMapper.map(questDTO);
        quest.setEntertainmentType(entertainmentType);
        return entertainmentMapper.map(questRepository.save(quest));
    }
}
