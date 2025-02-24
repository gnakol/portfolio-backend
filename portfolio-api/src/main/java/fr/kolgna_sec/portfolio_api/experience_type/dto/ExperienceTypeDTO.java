package fr.kolgna_sec.portfolio_api.experience_type.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExperienceTypeDTO {

    private Long idExperienceType;

    private String refExperienceType;

    private String name;
}
