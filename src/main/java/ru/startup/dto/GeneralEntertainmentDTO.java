package ru.startup.dto;

import lombok.Getter;
import lombok.Setter;
import ru.startup.model.entertainment.EntertainmentType;

import java.time.LocalDateTime;

@Getter
@Setter
public class GeneralEntertainmentDTO {

    private String phoneNumber;

    private String shiftName;

    private LocalDateTime startAt;

    private LocalDateTime endAt;

    private EntertainmentType entertainmentType;

    private String price;

    private String name; //добавить в базу
}
