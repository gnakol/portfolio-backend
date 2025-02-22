package fr.kolgna_sec.portfolio_api.establishment.repositories;

import fr.kolgna_sec.portfolio_api.establishment.bean.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {
}
