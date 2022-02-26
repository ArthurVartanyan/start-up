package ru.startup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.startup.model.entertainment.VRClub;

@Repository
public interface VRClubRepository extends JpaRepository<VRClub, Long> {
}