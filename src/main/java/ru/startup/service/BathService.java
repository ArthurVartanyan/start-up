package ru.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.BathDTO;
import ru.startup.mapper.EntertainmentMapper;
import ru.startup.model.entertainment.Bath;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.repository.BathRepository;

@Service
public class BathService {

    private BathRepository bathRepository;

    private EntertainmentMapper entertainmentMapper;

    @Autowired
    public void setBathRepository(BathRepository bathRepository) {
        this.bathRepository = bathRepository;
    }

    @Autowired
    public void setEntertainmentMapper(EntertainmentMapper entertainmentMapper) {
        this.entertainmentMapper = entertainmentMapper;
    }

    public BathDTO getBathById(Long id) {
        return entertainmentMapper.map(bathRepository.getBathByIdAndDeletedIsFalse(id), BathDTO.class);
    }

    public void deleteBathById(Long id) {
        Bath bath = bathRepository.getById(id);
        bath.setDeleted(true);
        bathRepository.save(bath);
    }

    public boolean existsById(Long id){
        return bathRepository.existsById(id);
    }

    public boolean existsByName(String name){
        return bathRepository.existsByNameAndDeletedIsFalse(name);
    }
    public BathDTO createBath(BathDTO bathDTO, EntertainmentType entertainmentType) {
        Bath bath = entertainmentMapper.map(bathDTO, Bath.class);
        bath.setEntertainmentType(entertainmentType);
        return entertainmentMapper.map(bathRepository.save(bath), BathDTO.class);
    }
}
