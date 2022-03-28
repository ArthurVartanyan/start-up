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
        return entertainmentMapper.map(potteryRepository.getPotteryByIdAndDeletedIsFalse(id));
    }

    public void deletePotteryById(Long id) {
        Pottery pottery = potteryRepository.getById(id);
        pottery.setDeleted(true);
        potteryRepository.save(pottery);
    }

    public boolean existsById(Long id) {
        return potteryRepository.existsById(id);
    }

    public boolean existsByName(String name) {
        return potteryRepository.existsByNameAndDeletedIsFalse(name);
    }

    public PotteryDTO createPottery(PotteryDTO potteryDTO, EntertainmentType entertainmentType) {
        Pottery pottery = entertainmentMapper.map(potteryDTO);
        pottery.setEntertainmentType(entertainmentType);
        return entertainmentMapper.map(potteryRepository.save(pottery));
    }
}
