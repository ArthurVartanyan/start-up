package ru.startup.dto.entertainment;

import lombok.Getter;
import lombok.Setter;
import ru.startup.model.entertainment.MassageType;

@Getter
@Setter
public class MassageDTO extends GeneralEntertainmentDTO {

    private MassageType massageType;
}
