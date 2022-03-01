package ru.startup.model.entertainment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "paintball", schema = "public")
public class Paintball extends GeneralEntertainment {

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PaintBallType paintBallType;
}
