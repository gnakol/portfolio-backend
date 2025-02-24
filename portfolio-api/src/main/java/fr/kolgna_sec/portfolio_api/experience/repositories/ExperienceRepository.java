package fr.kolgna_sec.portfolio_api.experience.repositories;

import fr.kolgna_sec.portfolio_api.experience.bean.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
