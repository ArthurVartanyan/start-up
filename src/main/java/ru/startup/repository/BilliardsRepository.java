package ru.startup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.startup.model.entertainment.Billiards;

@Repository
public interface BilliardsRepository extends JpaRepository<Billiards, Long> {

    Billiards getBilliardsByIdAndDeletedIsFalse(Long id);
}
