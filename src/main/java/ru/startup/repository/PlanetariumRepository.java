package ru.startup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.startup.model.entertainment.Planetarium;

@Repository
public interface PlanetariumRepository extends JpaRepository<Planetarium, Long> {

    Planetarium getPlanetariumByIdAndDeletedIsFalse(Long id);

    boolean existsByNameAndDeletedIsFalse(String name);
}
