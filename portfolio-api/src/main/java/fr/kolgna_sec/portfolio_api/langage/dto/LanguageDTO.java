package fr.kolgna_sec.portfolio_api.langage.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LanguageDTO {

    private Long idLanguage;

    private String refLanguage;

    private String name;

    private String proficiencyLevel;
}
