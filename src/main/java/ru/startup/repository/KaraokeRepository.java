package ru.startup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.startup.model.entertainment.Karaoke;

@Repository
public interface KaraokeRepository extends JpaRepository<Karaoke, Long> {

    Karaoke getKaraokeByIdAndDeletedIsFalse(Long id);
}
