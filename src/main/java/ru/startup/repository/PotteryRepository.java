package ru.startup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.startup.model.entertainment.Pottery;

@Repository
public interface PotteryRepository extends JpaRepository<Pottery, Long> {

    Pottery getPotteryByIdAndDeletedIsFalse(Long id);

    boolean existsByNameAndDeletedIsFalse(String name);
}
