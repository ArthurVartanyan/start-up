package ru.startup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.startup.model.entertainment.ShootingClub;

@Repository
public interface ShootingClubRepository extends JpaRepository<ShootingClub, Long> {

    ShootingClub getShootingClubByIdAndDeletedIsFalse(Long id);

    boolean existsByNameAndDeletedIsFalse(String name);
}