package fr.kolgna_sec.portfolio_api.skill_categori.mappers;

import fr.kolgna_sec.portfolio_api.skill_categori.bean.SkillCategory;
import fr.kolgna_sec.portfolio_api.skill_categori.dto.SkillCategoryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillCategoryMapper {

    SkillCategoryDTO fromSkillCategory(SkillCategory skillCategory);

    SkillCategory fromSkillCategoryDTO(SkillCategoryDTO skillCategoryDTO);
}
