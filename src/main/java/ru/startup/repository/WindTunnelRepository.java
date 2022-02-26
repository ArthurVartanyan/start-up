package ru.startup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.startup.model.entertainment.WindTunnel;

@Repository
public interface WindTunnelRepository extends JpaRepository<WindTunnel, Long> {
}
