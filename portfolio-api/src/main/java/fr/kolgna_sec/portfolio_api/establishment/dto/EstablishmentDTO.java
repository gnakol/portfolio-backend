package fr.kolgna_sec.portfolio_api.establishment.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class EstablishmentDTO {

    private Long idEstablishment;

    private String refEstablishment;

    private String name;

    private String city;
}
