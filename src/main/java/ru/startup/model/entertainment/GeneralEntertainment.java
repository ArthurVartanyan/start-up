package ru.startup.model.entertainment;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "general_entertainment", schema = "public")
@Inheritance(strategy = InheritanceType.JOINED)
public class GeneralEntertainment {

    @Id
    private Long id;

    private String phoneNumber;

    private String shiftName;

    private LocalDateTime startAt;

    private LocalDateTime endAt;

    private EntertainmentType entertainmentType;

    private String price;

    private Boolean deleted;
}
