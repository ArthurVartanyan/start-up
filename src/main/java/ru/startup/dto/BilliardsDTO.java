package ru.startup.dto;

import lombok.Getter;
import lombok.Setter;
import ru.startup.model.entertainment.BilliardsType;

@Getter
@Setter
public class BilliardsDTO extends GeneralEntertainmentDTO {

    private BilliardsType billiardsType;

    private byte tableCount;
}
