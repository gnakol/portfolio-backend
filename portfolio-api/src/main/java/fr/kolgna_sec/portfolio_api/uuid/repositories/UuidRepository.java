package fr.kolgna_sec.portfolio_api.uuid.repositories;

import fr.kolgna_sec.portfolio_api.uuid.bean.UuidBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UuidRepository extends JpaRepository<UuidBean, Long> {

    boolean existsByGenerate(String uuid);
}
