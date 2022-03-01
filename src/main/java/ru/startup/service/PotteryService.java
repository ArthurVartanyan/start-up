package ru.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.PotteryDTO;
import ru.startup.mapper.EntertainmentMapper;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.model.entertainment.Pottery;
import ru.startup.repository.PotteryRepository;

@Service
public class PotteryService {

    private PotteryRepository potteryRepository;

    private EntertainmentMapper entertainmentMapper;

    @Autowired
    public void setEntertainmentMapper(EntertainmentMapper entertainmentMapper) {
        this.entertainmentMapper = entertainmentMapper;
    }

    @Autowired
    public void setPotteryRepository(PotteryRepository potteryRepository) {
        this.potteryRepository = potteryRepository;
    }

    public PotteryDTO getPotteryById(Long id) {
        return entertainmentMapper.map(potteryRepository.getById(id), PotteryDTO.class);
    }

    public PotteryDTO createPottery(PotteryDTO potteryDTO, EntertainmentType entertainmentType) {
        Pottery pottery = entertainmentMapper.map(potteryDTO, Pottery.class);
        pottery.setEntertainmentType(entertainmentType);
        return entertainmentMapper.map(potteryRepository.save(pottery), PotteryDTO.class);
    }
}
