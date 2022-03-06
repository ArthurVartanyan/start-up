package ru.startup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.WindTunnelDTO;
import ru.startup.mapper.EntertainmentMapper;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.model.entertainment.WindTunnel;
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

    public WindTunnelDTO getWindTunnelById(Long id) {
        return entertainmentMapper.map(windTunnelRepository.getWindTunnelByIdAndDeletedIsFalse(id), WindTunnelDTO.class);
    }

    public void deleteWindTunnelById(Long id) {
        WindTunnel windTunnel = windTunnelRepository.getById(id);
        windTunnel.setDeleted(true);
        windTunnelRepository.save(windTunnel);
    }

    public WindTunnelDTO createWindTunnel(WindTunnelDTO windTunnelDTO, EntertainmentType entertainmentType) {
        WindTunnel windTunnel = entertainmentMapper.map(windTunnelDTO, WindTunnel.class);
        windTunnel.setEntertainmentType(entertainmentType);
        return entertainmentMapper.map(windTunnelRepository.save(windTunnel), WindTunnelDTO.class);
    }
}
