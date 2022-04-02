package ru.startup.dto.entertainment;

import lombok.Getter;
import lombok.Setter;
import ru.startup.model.entertainment.MuseumTheme;

@Getter
@Setter
public class MuseumDTO extends GeneralEntertainmentDTO {

    private MuseumTheme museumTheme;
}
