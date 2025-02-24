package fr.kolgna_sec.portfolio_api.skill.mappers;

import fr.kolgna_sec.portfolio_api.account.mappers.AccountMapper;
import fr.kolgna_sec.portfolio_api.skill.bean.Skill;
import fr.kolgna_sec.portfolio_api.skill.dto.SkillDTO;
import fr.kolgna_sec.portfolio_api.skill_categori.mappers.SkillCategoryMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {AccountMapper.class, SkillCategoryMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SkillMapper {

    @Mapping(target = "account_id", source = "account.idAccount")
    @Mapping(target = "skillCategory_id", source = "skillCategory.idSkillCategory")
    SkillDTO fromSkill(Skill skill);

    @Mapping(target = "account.idAccount", source = "account_id")
    @Mapping(target = "skillCategory.idSkillCategory", source = "skillCategory_id")
    Skill fromSkillDTO(SkillDTO skillDTO);
}
