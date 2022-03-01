package ru.startup.model.entertainment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "bath", schema = "public")
public class Bath extends GeneralEntertainment {

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private BathType bathType;
}
