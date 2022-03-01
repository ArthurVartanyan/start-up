package ru.startup.model.entertainment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "massage", schema = "public")
public class Massage extends GeneralEntertainment {

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private MassageType massageType;
}
