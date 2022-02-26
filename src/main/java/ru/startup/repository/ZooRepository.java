package ru.startup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.startup.model.entertainment.Zoo;

@Repository
public interface ZooRepository extends JpaRepository<Zoo, Long> {
}
