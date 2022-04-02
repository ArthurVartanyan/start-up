package ru.startup.mapper;

import org.mapstruct.*;
import ru.startup.dto.hostel.YouthHostelDTO;
import ru.startup.model.hostel.YouthHostel;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface YouthHostelMapper {
    
    YouthHostel youthHostelDTOToYouthHostel(YouthHostelDTO youthHostelDTO);

    YouthHostelDTO youthHostelToYouthHostelDTO(YouthHostel youthHostel);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateYouthHostelFromYouthHostelDTO(YouthHostelDTO youthHostelDTO, @MappingTarget YouthHostel youthHostel);
}
