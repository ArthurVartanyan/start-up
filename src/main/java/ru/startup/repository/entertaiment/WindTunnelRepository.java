package ru.startup.repository.entertaiment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.startup.model.entertainment.WindTunnel;

@Repository
public interface WindTunnelRepository extends JpaRepository<WindTunnel, Long> {

    WindTunnel getWindTunnelByIdAndDeletedIsFalse(Long id);

    boolean existsByNameAndDeletedIsFalse(String name);
}
