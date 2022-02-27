package ru.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.PotteryDTO;
import ru.startup.mapper.EntertainmentMapper;
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

    public PotteryDTO getPotteryById(Long id){
        return entertainmentMapper.map(potteryRepository.getById(id), PotteryDTO.class);
    }
}
