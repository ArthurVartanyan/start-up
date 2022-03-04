package ru.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.BowlingDTO;
import ru.startup.mapper.EntertainmentMapper;
import ru.startup.model.entertainment.Bowling;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.repository.BowlingRepository;

@Service
public class BowlingService {

    private BowlingRepository bowlingRepository;

    private EntertainmentMapper entertainmentMapper;

    @Autowired
    public void setBowlingRepository(BowlingRepository bowlingRepository) {
        this.bowlingRepository = bowlingRepository;
    }

    @Autowired
    public void setEntertainmentMapper(EntertainmentMapper entertainmentMapper) {
        this.entertainmentMapper = entertainmentMapper;
    }

    public BowlingDTO getBowlingById(Long id) {
        return entertainmentMapper.map(bowlingRepository.getBowlingByIdAndDeletedIsFalse(id), BowlingDTO.class);
    }

    public void deleteBowlingById(Long id) {
        Bowling bowling = bowlingRepository.getById(id);
        bowling.setDeleted(true);
        bowlingRepository.save(bowling);
    }

    public BowlingDTO createBowling(BowlingDTO bowlingDTO, EntertainmentType entertainmentType) {
        Bowling bowling = entertainmentMapper.map(bowlingDTO, Bowling.class);
        bowling.setEntertainmentType(entertainmentType);
        return entertainmentMapper.map(bowlingRepository.save(bowling), BowlingDTO.class);
    }
}
