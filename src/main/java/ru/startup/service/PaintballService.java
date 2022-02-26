package ru.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.PaintballDTO;
import ru.startup.mapper.EntertainmentMapper;
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
}
