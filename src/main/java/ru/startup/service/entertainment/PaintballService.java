package ru.startup.service.entertainment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.entertainment.PaintballDTO;
import ru.startup.mapper.EntertainmentMapper;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.model.entertainment.Paintball;
import ru.startup.repository.entertaiment.PaintballRepository;

@Service
public class PaintballService {

    private PaintballRepository paintballRepository;

    private EntertainmentMapper entertainmentMapper;

    @Autowired
    public void setEntertainmentMapper(EntertainmentMapper entertainmentMapper) {
        this.entertainmentMapper = entertainmentMapper;
    }

    @Autowired
    public void setPaintballRepository(PaintballRepository paintballRepository) {
        this.paintballRepository = paintballRepository;
    }

    public PaintballDTO getPaintballById(Long id) {
        return entertainmentMapper.map(paintballRepository.getPaintballByIdAndDeletedIsFalse(id));
    }

    public void deletePaintballById(Long id) {
        Paintball paintball = paintballRepository.getById(id);
        paintball.setDeleted(true);
        paintballRepository.save(paintball);
    }

    public boolean existsById(Long id) {
        return paintballRepository.existsById(id);
    }

    public boolean existsByName(String name) {
        return paintballRepository.existsByNameAndDeletedIsFalse(name);
    }

    public PaintballDTO createPaintball(PaintballDTO paintballDTO, EntertainmentType entertainmentType) {
        Paintball paintball = entertainmentMapper.map(paintballDTO);
        paintball.setEntertainmentType(entertainmentType);
        return entertainmentMapper.map(paintballRepository.save(paintball));
    }
}
