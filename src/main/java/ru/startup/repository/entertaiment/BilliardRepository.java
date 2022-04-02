package ru.startup.repository.entertaiment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.startup.model.entertainment.Billiard;

@Repository
public interface BilliardRepository extends JpaRepository<Billiard, Long> {

    Billiard getBilliardsByIdAndDeletedIsFalse(Long id);

    boolean existsByNameAndDeletedIsFalse(String name);
}
