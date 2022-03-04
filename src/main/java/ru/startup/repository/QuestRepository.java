package ru.startup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.startup.model.entertainment.Quest;

@Repository
public interface QuestRepository extends JpaRepository<Quest, Long> {

    Quest getQuestByIdAndDeletedIsFalse(Long id);
}
