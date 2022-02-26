package ru.startup.model.entertainment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "vr_game", schema = "public")
public class VRGame extends GeneralEntertainment {

    private String name;

    @ManyToMany(mappedBy = "vrGameSet")
    private Set<VRClub> vrClubSet;
}
