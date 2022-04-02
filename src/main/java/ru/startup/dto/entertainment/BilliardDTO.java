package ru.startup.dto.entertainment;

import lombok.Getter;
import lombok.Setter;
import ru.startup.model.entertainment.BilliardType;

@Getter
@Setter
public class BilliardDTO extends GeneralEntertainmentDTO {

    private BilliardType billiardType;

    private byte tableCount;
}
