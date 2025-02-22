package fr.kolgna_sec.portfolio_api.establishment.mappers;

import fr.kolgna_sec.portfolio_api.establishment.bean.Establishment;
import fr.kolgna_sec.portfolio_api.establishment.dto.EstablishmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EstablishmentMapper {

    EstablishmentDTO fromEstablishment(Establishment establishment);

    Establishment fromEstablishmentDTO(EstablishmentDTO establishmentDTO);
}
