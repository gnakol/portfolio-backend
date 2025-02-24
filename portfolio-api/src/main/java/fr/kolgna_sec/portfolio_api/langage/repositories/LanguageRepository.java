package fr.kolgna_sec.portfolio_api.langage.repositories;

import fr.kolgna_sec.portfolio_api.langage.bean.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
}
