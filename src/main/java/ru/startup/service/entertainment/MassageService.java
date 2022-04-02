package ru.startup.service.entertainment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.entertainment.MassageDTO;
import ru.startup.mapper.EntertainmentMapper;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.model.entertainment.Massage;
import ru.startup.repository.entertaiment.MassageRepository;

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

    public MassageDTO getMassageById(Long id) {
        return entertainmentMapper.map(massageRepository.getMassageByIdAndDeletedIsFalse(id));
    }

    public void deleteMassageById(Long id) {
        Massage massage = massageRepository.getById(id);
        massage.setDeleted(true);
        massageRepository.save(massage);
    }

    public boolean existsById(Long id) {
        return massageRepository.existsById(id);
    }

    public boolean existsByName(String name) {
        return massageRepository.existsByNameAndDeletedIsFalse(name);
    }

    public MassageDTO createMassage(MassageDTO massageDTO, EntertainmentType entertainmentType) {
        Massage massage = entertainmentMapper.map(massageDTO);
        massage.setEntertainmentType(entertainmentType);
        return entertainmentMapper.map(massageRepository.save(massage));
    }
}
