package ru.startup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.startup.model.entertainment.Bowling;

@Repository
public interface BowlingRepository extends JpaRepository<Bowling, Long> {

    Bowling getBowlingByIdAndDeletedIsFalse(Long id);

    boolean existsByNameAndDeletedIsFalse(String name);
}
