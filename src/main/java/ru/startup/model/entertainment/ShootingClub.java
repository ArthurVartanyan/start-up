package ru.startup.model.entertainment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "shooting_club", schema = "public")
public class ShootingClub extends GeneralEntertainment {

    @Column(name = "firearms")
    private boolean fireArms;

    @Column(name = "airguns")
    private boolean airGuns;

    @ManyToMany
    @JoinTable(name = "shooting_club_weapon",
            joinColumns = @JoinColumn(name = "shooting_club_id"),
            inverseJoinColumns = @JoinColumn(name = "weapon_id"))
    private Set<Weapon> weaponSet;
}
