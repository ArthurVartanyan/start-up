package ru.startup.dto.entertainment;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BowlingDTO extends GeneralEntertainmentDTO {

    private byte lanesCount;

    private byte linesLimit;
}
