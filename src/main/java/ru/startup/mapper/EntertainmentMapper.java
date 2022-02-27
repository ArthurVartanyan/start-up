package ru.startup.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import ru.startup.dto.*;
import ru.startup.model.entertainment.*;

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

        mapperFactory.classMap(BowlingDTO.class, Bowling.class)
                .byDefault()
                .register();

        mapperFactory.classMap(Bowling.class, BowlingDTO.class)
                .byDefault()
                .register();

        mapperFactory.classMap(ExtremeDTO.class, Extreme.class)
                .byDefault()
                .register();

        mapperFactory.classMap(Extreme.class, ExtremeDTO.class)
                .byDefault()
                .register();

        mapperFactory.classMap(KaraokeDTO.class, Karaoke.class)
                .byDefault()
                .register();

        mapperFactory.classMap(Karaoke.class, KaraokeDTO.class)
                .byDefault()
                .register();

        mapperFactory.classMap(MassageDTO.class, Massage.class)
                .byDefault()
                .register();

        mapperFactory.classMap(Massage.class, MassageDTO.class)
                .byDefault()
                .register();

        mapperFactory.classMap(Museum.class, MuseumDTO.class)
                .byDefault()
                .register();

        mapperFactory.classMap(MuseumDTO.class, Museum.class)
                .byDefault()
                .register();

        mapperFactory.classMap(Paintball.class, PaintballDTO.class)
                .byDefault()
                .register();

        mapperFactory.classMap(PaintballDTO.class, Paintball.class)
                .byDefault()
                .register();

        mapperFactory.classMap(Planetarium.class, PlanetariumDTO.class)
                .byDefault()
                .register();

        mapperFactory.classMap(PlanetariumDTO.class, Planetarium.class)
                .byDefault()
                .register();

        mapperFactory.classMap(Pottery.class, PotteryDTO.class)
                .byDefault()
                .register();

        mapperFactory.classMap(PotteryDTO.class, Pottery.class)
                .byDefault()
                .register();

        mapperFactory.classMap(Quest.class, QuestDTO.class)
                .byDefault()
                .register();

        mapperFactory.classMap(QuestDTO.class, Quest.class)
                .byDefault()
                .register();

        mapperFactory.classMap(ShootingClub.class, ShootingClubDTO.class)
                .byDefault()
                .register();

        mapperFactory.classMap(ShootingClubDTO.class, ShootingClub.class)
                .byDefault()
                .register();

        mapperFactory.classMap(VRClub.class, VRClubDTO.class)
                .byDefault()
                .register();

        mapperFactory.classMap(VRClubDTO.class, VRClub.class)
                .byDefault()
                .register();

        mapperFactory.classMap(WindTunnel.class, WindTunnelDTO.class)
                .byDefault()
                .register();

        mapperFactory.classMap(WindTunnelDTO.class, WindTunnel.class)
                .byDefault()
                .register();

        mapperFactory.classMap(Zoo.class, ZooDTO.class)
                .byDefault()
                .register();

        mapperFactory.classMap(ZooDTO.class, Zoo.class)
                .byDefault()
                .register();

    }

}
