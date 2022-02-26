package ru.startup.model.entertainment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "wind_tunnel", schema = "public")
public class WindTunnel extends GeneralEntertainment {
}
