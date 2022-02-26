package ru.startup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.startup.model.entertainment.Extreme;

@Repository
public interface ExtremeRepository extends JpaRepository<Extreme, Long> {
}