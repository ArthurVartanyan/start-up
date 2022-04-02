package ru.startup.repository.entertaiment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.startup.model.entertainment.Massage;

@Repository
public interface MassageRepository extends JpaRepository<Massage, Long> {

    Massage getMassageByIdAndDeletedIsFalse(Long id);

    boolean existsByNameAndDeletedIsFalse(String name);
}
