package ru.startup.model.entertainment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "bowling", schema = "public")
public class Bowling extends GeneralEntertainment {

    private byte lanesCount;

    private byte lanesLimit;
}
