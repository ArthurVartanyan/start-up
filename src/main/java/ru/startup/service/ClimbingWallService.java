package ru.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.ClimbingWallDTO;
import ru.startup.mapper.EntertainmentMapper;
import ru.startup.model.entertainment.ClimbingWall;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.repository.ClimbingWallRepository;

@Service
public class ClimbingWallService {

    private ClimbingWallRepository climbingWallRepository;

    private EntertainmentMapper entertainmentMapper;

    @Autowired
    public void setEntertainmentMapper(EntertainmentMapper entertainmentMapper) {
        this.entertainmentMapper = entertainmentMapper;
    }

    @Autowired
    public void setClimbingWallRepository(ClimbingWallRepository climbingWallRepository) {
        this.climbingWallRepository = climbingWallRepository;
    }

    public ClimbingWallDTO getClimbingWallById(Long id) {
        return entertainmentMapper.map(climbingWallRepository.getClimbingWallByIdAndDeletedIsFalse(id), ClimbingWallDTO.class);
    }

    public void deleteClimbingWallById(Long id) {
        ClimbingWall climbingWall = climbingWallRepository.getById(id);
        climbingWall.setDeleted(true);
        climbingWallRepository.save(climbingWall);
    }

    public boolean existsById(Long id){
        return climbingWallRepository.existsById(id);
    }

    public boolean existsByName(String name){
        return climbingWallRepository.existsByNameAndDeletedIsFalse(name);
    }

    public ClimbingWallDTO createClimbingWall(ClimbingWallDTO climbingWallDTO, EntertainmentType entertainmentType) {
        ClimbingWall climbingWall = entertainmentMapper.map(climbingWallDTO, ClimbingWall.class);
        climbingWall.setEntertainmentType(entertainmentType);
        return entertainmentMapper.map(climbingWallRepository.save(climbingWall), ClimbingWallDTO.class);
    }
}
