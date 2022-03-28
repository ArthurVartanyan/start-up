package ru.startup.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.startup.dto.*;
import ru.startup.model.entertainment.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EntertainmentMapper {

    Bath map(BathDTO bathDTO);

    BathDTO map(Bath bath);

    Billiards map(BilliardsDTO billiardsDTO);

    BilliardsDTO map(Billiards billiards);

    Bowling map(BowlingDTO bowlingDTO);

    BowlingDTO map(Bowling bowling);

    ClimbingWall map(ClimbingWallDTO climbingWallDTO);

    ClimbingWallDTO map(ClimbingWall climbingWall);

    Extreme map(ExtremeDTO extremeDTO);

    ExtremeDTO map(Extreme extreme);

    Karaoke map(KaraokeDTO karaokeDTO);

    KaraokeDTO map(Karaoke karaoke);

    Massage map(MassageDTO massageDTO);

    MassageDTO map(Massage massage);

    Museum map(MuseumDTO museumDTO);

    MuseumDTO map(Museum museum);

    Paintball map(PaintballDTO paintballDTO);

    PaintballDTO map(Paintball paintball);

    Planetarium map(PlanetariumDTO planetariumDTO);

    PlanetariumDTO map(Planetarium planetarium);

    Pottery map(PotteryDTO potteryDTO);

    PotteryDTO map(Pottery pottery);

    Quest map(QuestDTO questDTO);

    QuestDTO map(Quest quest);

    ShootingClub map(ShootingClubDTO shootingClubDTO);

    ShootingClubDTO map(ShootingClub shootingClub);

    VRClub map(VRClubDTO vrClubDTO);

    VRClubDTO map(VRClub vrClub);

    WindTunnel map(WindTunnelDTO windTunnelDTO);

    WindTunnelDTO map(WindTunnel windTunnel);

    Zoo map(ZooDTO zooDTO);

    ZooDTO map(Zoo zoo);
}