package ru.startup.service.entertainment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.entertainment.ZooDTO;
import ru.startup.mapper.EntertainmentMapper;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.model.entertainment.Zoo;
import ru.startup.repository.entertaiment.ZooRepository;

@Service
public class ZooService {

    private ZooRepository zooRepository;

    private EntertainmentMapper entertainmentMapper;

    @Autowired
    public void setEntertainmentMapper(EntertainmentMapper entertainmentMapper) {
        this.entertainmentMapper = entertainmentMapper;
    }

    @Autowired
    public void setZooRepository(ZooRepository zooRepository) {
        this.zooRepository = zooRepository;
    }

    public ZooDTO getZooById(Long id) {
        return entertainmentMapper.map(zooRepository.getZooByIdAndDeletedIsFalse(id));
    }

    public void deleteZooById(Long id) {
        Zoo zoo = zooRepository.getById(id);
        zoo.setDeleted(true);
        zooRepository.save(zoo);
    }

    public boolean existsById(Long id) {
        return zooRepository.existsById(id);
    }

    public boolean existsByName(String name) {
        return zooRepository.existsByNameAndDeletedIsFalse(name);
    }

    public ZooDTO createZoo(ZooDTO zooDTO, EntertainmentType entertainmentType) {
        Zoo zoo = entertainmentMapper.map(zooDTO);
        zoo.setEntertainmentType(entertainmentType);
        return entertainmentMapper.map(zooRepository.save(zoo));
    }
}
