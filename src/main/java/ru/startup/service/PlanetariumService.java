package ru.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.PlanetariumDTO;
import ru.startup.mapper.EntertainmentMapper;
import ru.startup.repository.PlanetariumRepository;

@Service
public class PlanetariumService {

    private PlanetariumRepository planetariumRepository;

    private EntertainmentMapper entertainmentMapper;

    @Autowired
    public void setEntertainmentMapper(EntertainmentMapper entertainmentMapper) {
        this.entertainmentMapper = entertainmentMapper;
    }

    @Autowired
    public void setPlanetariumRepository(PlanetariumRepository planetariumRepository) {
        this.planetariumRepository = planetariumRepository;
    }

    public PlanetariumDTO getPlanetariumById(Long id){
        return entertainmentMapper.map(planetariumRepository.getById(id), PlanetariumDTO.class);
    }
}
