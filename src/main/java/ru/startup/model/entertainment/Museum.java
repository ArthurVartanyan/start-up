package ru.startup.model.entertainment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "museum", schema = "public")
public class Museum extends GeneralEntertainment {

    private MuseumTheme museumTheme;
}
