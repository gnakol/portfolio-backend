package fr.kolgna_sec.portfolio_api.langage.mappers;

import fr.kolgna_sec.portfolio_api.langage.bean.Language;
import fr.kolgna_sec.portfolio_api.langage.dto.LanguageDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LanguageMapper {

    LanguageDTO fromLanguage(Language language);

    Language fromLanguageDTO(LanguageDTO languageDTO);
}
