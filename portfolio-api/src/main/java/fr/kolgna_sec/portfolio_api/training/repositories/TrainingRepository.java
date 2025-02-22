package fr.kolgna_sec.portfolio_api.training.repositories;

import fr.kolgna_sec.portfolio_api.training.bean.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
}
