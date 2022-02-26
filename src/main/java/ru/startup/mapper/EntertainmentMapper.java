package ru.startup.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import ru.startup.dto.BathDTO;
import ru.startup.dto.BilliardsDTO;
import ru.startup.model.entertainment.Bath;
import ru.startup.model.entertainment.Billiards;

@Component
public class EntertainmentMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory mapperFactory) {

        mapperFactory.classMap(Bath.class, BathDTO.class)
                .byDefault()
                .register();

        mapperFactory.classMap(BathDTO.class, Bath.class)
                .byDefault()
                .register();

        mapperFactory.classMap(Billiards.class, BilliardsDTO.class)
                .byDefault()
                .register();

        mapperFactory.classMap(BilliardsDTO.class, Billiards.class)
                .byDefault()
                .register();

    }

}
