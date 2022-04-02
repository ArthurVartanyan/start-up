package ru.startup.service.entertainment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.entertainment.BilliardDTO;
import ru.startup.mapper.EntertainmentMapper;
import ru.startup.model.entertainment.Billiard;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.repository.entertaiment.BilliardRepository;

@Service
public class BilliardService {

    private BilliardRepository billiardRepository;

    private EntertainmentMapper entertainmentMapper;

    @Autowired
    public void setBilliardsRepository(BilliardRepository billiardRepository) {
        this.billiardRepository = billiardRepository;
    }

    @Autowired
    public void setEntertainmentMapper(EntertainmentMapper entertainmentMapper) {
        this.entertainmentMapper = entertainmentMapper;
    }

    public BilliardDTO getBilliardsById(Long id) {
        return entertainmentMapper.map(billiardRepository.getBilliardsByIdAndDeletedIsFalse(id));
    }

    public void deleteBilliardsById(Long id) {
        Billiard billiard = billiardRepository.getById(id);
        billiard.setDeleted(true);
        billiardRepository.save(billiard);
    }

    public boolean existsById(Long id) {
        return billiardRepository.existsById(id);
    }

    public boolean existsByName(String name) {
        return billiardRepository.existsByNameAndDeletedIsFalse(name);
    }

    public BilliardDTO createBilliards(BilliardDTO billiardDTO, EntertainmentType entertainmentType) {
        Billiard billiard = entertainmentMapper.map(billiardDTO);
        billiard.setEntertainmentType(entertainmentType);
        return entertainmentMapper.map(billiardRepository.save(billiard));
    }
}
