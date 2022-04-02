package ru.startup.service.hostel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.startup.dto.hostel.YouthHostelDTO;
import ru.startup.mapper.YouthHostelMapper;
import ru.startup.model.hostel.YouthHostel;
import ru.startup.repository.hostel.YouthHostelRepository;

@Service
public class YouthHostelService {

    private YouthHostelRepository youthHostelRepository;

    private YouthHostelMapper youthHostelMapper;

    @Autowired
    public void setYouthHostelMapper(YouthHostelMapper youthHostelMapper) {
        this.youthHostelMapper = youthHostelMapper;
    }

    @Autowired
    public void setYouthHostelRepository(YouthHostelRepository youthHostelRepository) {
        this.youthHostelRepository = youthHostelRepository;
    }

    public Long createYouthHostel(YouthHostelDTO youthHostelDTO) {
        YouthHostel youthHostel = youthHostelMapper.youthHostelDTOToYouthHostel(youthHostelDTO);
        youthHostel.setDeleted(false);
        return youthHostelRepository.save(youthHostel).getId();
    }

    public YouthHostelDTO getYouthHostel(Long id) {
        return youthHostelMapper.youthHostelToYouthHostelDTO(youthHostelRepository.getById(id));
    }

    public void deleteYouthHostel(Long id) {
        YouthHostel youthHostel = youthHostelRepository.getById(id);
        youthHostel.setDeleted(true);
        youthHostelRepository.save(youthHostel);
    }
}