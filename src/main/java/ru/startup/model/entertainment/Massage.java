package ru.startup.model.entertainment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "massage", schema = "public")
public class Massage extends GeneralEntertainment {

    private MassageType massageType;
}
