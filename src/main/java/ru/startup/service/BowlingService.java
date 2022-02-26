package ru.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.BowlingDTO;
import ru.startup.mapper.EntertainmentMapper;
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

    public BowlingDTO getBowlingsById(Long id){
        return entertainmentMapper.map(bowlingRepository.getById(id), BowlingDTO.class);
    }
}
