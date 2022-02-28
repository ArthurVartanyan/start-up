package ru.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.KaraokeDTO;
import ru.startup.mapper.EntertainmentMapper;
import ru.startup.repository.KaraokeRepository;

@Service
public class KaraokeService {

    private KaraokeRepository karaokeRepository;

    private EntertainmentMapper entertainmentMapper;

    @Autowired
    public void setEntertainmentMapper(EntertainmentMapper entertainmentMapper) {
        this.entertainmentMapper = entertainmentMapper;
    }

    @Autowired
    public void setKaraokeRepository(KaraokeRepository karaokeRepository) {
        this.karaokeRepository = karaokeRepository;
    }

    public KaraokeDTO getKaraokeById(Long id){
        return entertainmentMapper.map(karaokeRepository.getById(id), KaraokeDTO.class);
    }
}
