package ru.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.MassageDTO;
import ru.startup.mapper.EntertainmentMapper;
import ru.startup.repository.MassageRepository;

@Service
public class MassageService {

    private MassageRepository massageRepository;

    private EntertainmentMapper entertainmentMapper;

    @Autowired
    public void setKaraokeRepository(MassageRepository massageRepository) {
        this.massageRepository = massageRepository;
    }

    @Autowired
    public void setEntertainmentMapper(EntertainmentMapper entertainmentMapper) {
        this.entertainmentMapper = entertainmentMapper;
    }

    public MassageDTO getMassageById(Long id){
        return entertainmentMapper.map(massageRepository.getById(id), MassageDTO.class);
    }
}
