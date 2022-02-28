package ru.startup.dto;

import lombok.Getter;
import lombok.Setter;
import ru.startup.model.entertainment.PaintBallType;

@Getter
@Setter
public class PaintballDTO extends GeneralEntertainmentDTO {

    private PaintBallType paintBallType;
}
