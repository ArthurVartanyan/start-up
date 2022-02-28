package ru.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.QuestDTO;
import ru.startup.mapper.EntertainmentMapper;
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

    public QuestDTO getQuestById(Long id){
        return entertainmentMapper.map(questRepository.getById(id), QuestDTO.class);
    }
}
