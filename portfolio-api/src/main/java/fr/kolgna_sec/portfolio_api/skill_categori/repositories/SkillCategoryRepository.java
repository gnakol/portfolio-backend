package fr.kolgna_sec.portfolio_api.skill_categori.repositories;

import fr.kolgna_sec.portfolio_api.skill_categori.bean.SkillCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillCategoryRepository extends JpaRepository<SkillCategory, Long> {
}
