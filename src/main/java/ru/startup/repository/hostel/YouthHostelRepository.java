package ru.startup.repository.hostel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.startup.model.hostel.YouthHostel;

@Repository
public interface YouthHostelRepository extends JpaRepository<YouthHostel, Long> {
}