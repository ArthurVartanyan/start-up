package ru.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.ZooDTO;
import ru.startup.mapper.EntertainmentMapper;
import ru.startup.repository.ZooRepository;

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

    public ZooDTO getZooById(Long id){
        return entertainmentMapper.map(zooRepository.getById(id), ZooDTO.class);
    }
}
