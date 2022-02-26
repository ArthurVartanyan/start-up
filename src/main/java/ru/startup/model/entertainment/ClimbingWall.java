package ru.startup.model.entertainment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "climbing_wall", schema = "public")
public class ClimbingWall extends GeneralEntertainment {
}
