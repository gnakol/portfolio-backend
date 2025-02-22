package fr.kolgna_sec.portfolio_api.training.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.kolgna_sec.portfolio_api.account.bean.Account;
import fr.kolgna_sec.portfolio_api.establishment.bean.Establishment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_training")
    private Long idTraining;

    @Column(name = "ref_training")
    private String refTraining;

    @Column(name = "label")
    private String label;

    @Column(name = "diploma")
    private String diploma;

    @Column(name = "year_of_obtaining")
    private Date yearOfObtaining;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JsonIgnoreProperties({"training"})
    @JoinColumn(name = "id_establishment", nullable = true)
    private Establishment establishment;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_account", nullable = true)
    @JsonIgnoreProperties({"trainings"})
    private Account account;
}
