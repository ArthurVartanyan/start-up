package ru.startup.model.entertainment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "vr_club", schema = "public")
public class VRClub extends GeneralEntertainment {

    private byte maxPlayersCount;

    @ManyToMany
    @JoinTable(name = "vr_club_game",
            joinColumns = @JoinColumn(name = "vr_club_id"),
            inverseJoinColumns = @JoinColumn(name = "vr_game_id"))
    private Set<VRGame> vrGameSet;
}
