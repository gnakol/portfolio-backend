package fr.kolgna_sec.portfolio_api.experience_type.repositories;

import fr.kolgna_sec.portfolio_api.experience_type.bean.ExperienceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceTypeRepository  extends JpaRepository<ExperienceType, Long> {
}
