package ru.startup.model.entertainment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "museum", schema = "public")
public class Museum extends GeneralEntertainment {

    @Column(name = "theme")
    @Enumerated(EnumType.STRING)
    private MuseumTheme museumTheme;
}
