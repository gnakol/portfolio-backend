package fr.kolgna_sec.portfolio_api.skill.repositories;

import fr.kolgna_sec.portfolio_api.skill.bean.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
}
