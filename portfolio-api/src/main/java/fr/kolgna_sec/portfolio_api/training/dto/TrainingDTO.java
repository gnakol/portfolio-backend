package fr.kolgna_sec.portfolio_api.training.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class TrainingDTO {

    private Long idTraining;

    private String refTraining;

    private String label;

    private String diploma;

    private Date yearOfObtaining;

    private Long establishment_id;

    private Long account_id;
}
