package ru.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.ClimbingWallDTO;
import ru.startup.mapper.EntertainmentMapper;
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

    public ClimbingWallDTO getBilliardsById(Long id) {
        return entertainmentMapper.map(climbingWallRepository.getById(id), ClimbingWallDTO.class);
    }
}
