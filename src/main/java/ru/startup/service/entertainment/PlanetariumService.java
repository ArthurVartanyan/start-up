package ru.startup.service.entertainment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.entertainment.PlanetariumDTO;
import ru.startup.mapper.EntertainmentMapper;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.model.entertainment.Planetarium;
import ru.startup.repository.entertaiment.PlanetariumRepository;

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

    public PlanetariumDTO getPlanetariumById(Long id) {
        return entertainmentMapper.map(planetariumRepository.getPlanetariumByIdAndDeletedIsFalse(id));
    }

    public void deletePlanetariumById(Long id) {
        Planetarium planetarium = planetariumRepository.getById(id);
        planetarium.setDeleted(true);
        planetariumRepository.save(planetarium);
    }

    public boolean existsById(Long id) {
        return planetariumRepository.existsById(id);
    }

    public boolean existsByName(String name) {
        return planetariumRepository.existsByNameAndDeletedIsFalse(name);
    }

    public PlanetariumDTO createPlanetarium(PlanetariumDTO planetariumDTO, EntertainmentType entertainmentType) {
        Planetarium planetarium = entertainmentMapper.map(planetariumDTO);
        planetarium.setEntertainmentType(entertainmentType);
        return entertainmentMapper.map(planetariumRepository.save(planetarium));
    }
}
