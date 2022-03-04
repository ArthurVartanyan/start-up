package ru.startup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.startup.model.entertainment.Museum;
import ru.startup.model.entertainment.Paintball;

@Repository
public interface PaintballRepository extends JpaRepository<Paintball, Long> {

    Paintball getPaintballByIdAndDeletedIsFalse(Long id);
}