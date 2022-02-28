package ru.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.WindTunnelDTO;
import ru.startup.mapper.EntertainmentMapper;
import ru.startup.repository.WindTunnelRepository;

@Service
public class WindTunnelService {

    private WindTunnelRepository windTunnelRepository;

    private EntertainmentMapper entertainmentMapper;

    @Autowired
    public void setEntertainmentMapper(EntertainmentMapper entertainmentMapper) {
        this.entertainmentMapper = entertainmentMapper;
    }

    @Autowired
    public void setWindTunnelRepository(WindTunnelRepository windTunnelRepository) {
        this.windTunnelRepository = windTunnelRepository;
    }

    public WindTunnelDTO getWindTunnelById(Long id){
        return entertainmentMapper.map(windTunnelRepository.getById(id), WindTunnelDTO.class);
    }
}
