package ru.startup.dto.entertainment;

import lombok.Getter;
import lombok.Setter;
import ru.startup.model.entertainment.PaintBallType;

@Getter
@Setter
public class PaintballDTO extends GeneralEntertainmentDTO {

    private PaintBallType paintBallType;
}
