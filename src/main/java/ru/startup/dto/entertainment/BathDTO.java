package ru.startup.dto.entertainment;

import lombok.Getter;
import lombok.Setter;
import ru.startup.model.entertainment.BathType;

@Getter
@Setter
public class BathDTO extends GeneralEntertainmentDTO {

    private BathType bathType;
}
