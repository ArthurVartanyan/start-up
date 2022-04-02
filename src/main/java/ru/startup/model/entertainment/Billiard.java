package ru.startup.model.entertainment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "billiard", schema = "public")
public class Billiard extends GeneralEntertainment {

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private BilliardType billiardType;

    @Column(name = "table_count")
    private byte tableCount;
}