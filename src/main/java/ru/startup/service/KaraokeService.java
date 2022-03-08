package ru.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.KaraokeDTO;
import ru.startup.mapper.EntertainmentMapper;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.model.entertainment.Karaoke;
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

    public KaraokeDTO getKaraokeById(Long id) {
        return entertainmentMapper.map(karaokeRepository.getKaraokeByIdAndDeletedIsFalse(id), KaraokeDTO.class);
    }

    public void deleteKaraokeById(Long id) {
        Karaoke karaoke = karaokeRepository.getById(id);
        karaoke.setDeleted(true);
        karaokeRepository.save(karaoke);
    }

    public boolean existsById(Long id){
        return karaokeRepository.existsById(id);
    }

    public KaraokeDTO createKaraoke(KaraokeDTO karaokeDTO, EntertainmentType entertainmentType) {
        Karaoke karaoke = entertainmentMapper.map(karaokeDTO, Karaoke.class);
        karaoke.setEntertainmentType(entertainmentType);
        return entertainmentMapper.map(karaokeRepository.save(karaoke), KaraokeDTO.class);
    }
}
