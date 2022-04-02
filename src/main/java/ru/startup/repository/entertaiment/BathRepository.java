package ru.startup.repository.entertaiment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.startup.model.entertainment.Bath;


@Repository
public interface BathRepository extends JpaRepository<Bath, Long> {

    Bath getBathByIdAndDeletedIsFalse(Long id);

    boolean existsByNameAndDeletedIsFalse(String name);

}
