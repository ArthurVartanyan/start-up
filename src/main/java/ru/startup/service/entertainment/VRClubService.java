package ru.startup.service.entertainment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.entertainment.VRClubDTO;
import ru.startup.mapper.EntertainmentMapper;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.model.entertainment.VRClub;
import ru.startup.repository.entertaiment.VRClubRepository;

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

    public VRClubDTO getVRClubById(Long id) {
        return entertainmentMapper.map(vrClubRepository.getVRClubByIdAndDeletedIsFalse(id));
    }

    public void deleteVRClubById(Long id) {
        VRClub vrClub = vrClubRepository.getById(id);
        vrClub.setDeleted(true);
        vrClubRepository.save(vrClub);
    }

    public boolean existsById(Long id) {
        return vrClubRepository.existsById(id);
    }

    public boolean existsByName(String name) {
        return vrClubRepository.existsByNameAndDeletedIsFalse(name);
    }

    public VRClubDTO createVRClub(VRClubDTO questDTO, EntertainmentType entertainmentType) {
        VRClub vrClub = entertainmentMapper.map(questDTO);
        vrClub.setEntertainmentType(entertainmentType);
        return entertainmentMapper.map(vrClubRepository.save(vrClub));
    }
}
