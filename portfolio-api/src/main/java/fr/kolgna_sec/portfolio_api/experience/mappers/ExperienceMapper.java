package fr.kolgna_sec.portfolio_api.experience.mappers;

import fr.kolgna_sec.portfolio_api.account.mappers.AccountMapper;
import fr.kolgna_sec.portfolio_api.experience.bean.Experience;
import fr.kolgna_sec.portfolio_api.experience.dto.ExperienceDTO;
import fr.kolgna_sec.portfolio_api.experience_type.mappers.ExperienceTypeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {AccountMapper.class, ExperienceTypeMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExperienceMapper {

    @Mapping(target = "account_id", source = "account.idAccount")
    @Mapping(target = "experienceType_id", source = "experienceType.idExperienceType")
    ExperienceDTO fromExperience(Experience experience);

    @Mapping(target = "account.idAccount", source = "account_id")
    @Mapping(target = "experienceType.idExperienceType", source = "experienceType_id")
    Experience fromExperienceDTO(ExperienceDTO experienceDTO);
}
