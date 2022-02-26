package ru.startup.model.entertainment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "massage", schema = "public")
public class Massage extends GeneralEntertainment {

    @Column(name = "type")
    private MassageType massageType;
}
