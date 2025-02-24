package fr.kolgna_sec.portfolio_api.skill_categori.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SkillCategoryDTO {

    private Long idSkillCategory;

    private String refSkillCategory;

    private String name;
}
