package fr.kolgna_sec.portfolio_api.experience_type.mappers;

import fr.kolgna_sec.portfolio_api.experience_type.bean.ExperienceType;
import fr.kolgna_sec.portfolio_api.experience_type.dto.ExperienceTypeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExperienceTypeMapper {

    ExperienceTypeDTO fromExperienceType(ExperienceType experienceType);

    ExperienceType fromExperienceTypeDTO(ExperienceTypeDTO experienceTypeDTO);
}
