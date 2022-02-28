package ru.startup.dto;

import lombok.Getter;
import lombok.Setter;
import ru.startup.model.entertainment.MassageType;

@Getter
@Setter
public class MassageDTO extends GeneralEntertainmentDTO {

    private MassageType massageType;
}
