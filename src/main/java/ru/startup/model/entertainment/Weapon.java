package ru.startup.model.entertainment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "weapon", schema = "public")
public class Weapon extends GeneralEntertainment {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "weaponSet")
    private Set<ShootingClub> shootingClubSet;
}
