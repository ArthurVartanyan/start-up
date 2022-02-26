package ru.startup.model.entertainment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "bowling", schema = "public")
public class Bowling extends GeneralEntertainment {

    @Column(name = "lanes_count")
    private byte lanesCount;

    @Column(name = "lanes_limit")
    private byte lanesLimit;
}
