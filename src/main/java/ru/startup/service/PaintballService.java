package ru.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.PaintballDTO;
import ru.startup.mapper.EntertainmentMapper;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.model.entertainment.Paintball;
import ru.startup.repository.PaintballRepository;

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

    public PaintballDTO getPaintballById(Long id){
        return entertainmentMapper.map(paintballRepository.getById(id), PaintballDTO.class);
    }

    public PaintballDTO createPaintball(PaintballDTO paintballDTO, EntertainmentType entertainmentType){
        Paintball paintball = entertainmentMapper.map(paintballDTO, Paintball.class);
        paintball.setEntertainmentType(entertainmentType);
        return entertainmentMapper.map(paintballRepository.save(paintball), PaintballDTO.class);
    }
}
