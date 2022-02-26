package ru.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.VRClubDTO;
import ru.startup.mapper.EntertainmentMapper;
import ru.startup.repository.VRClubRepository;

@Service
public class VRClubService {

    private VRClubRepository vrClubRepository;

    private EntertainmentMapper entertainmentMapper;

    @Autowired
    public void setEntertainmentMapper(EntertainmentMapper entertainmentMapper) {
        this.entertainmentMapper = entertainmentMapper;
    }

    @Autowired
    public void setVrClubRepository(VRClubRepository vrClubRepository) {
        this.vrClubRepository = vrClubRepository;
    }

    public VRClubDTO getVRClubById(Long id){
        return entertainmentMapper.map(vrClubRepository.getById(id), VRClubDTO.class);
    }
}
