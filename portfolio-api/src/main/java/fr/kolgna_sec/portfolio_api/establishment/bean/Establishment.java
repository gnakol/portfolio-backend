package fr.kolgna_sec.portfolio_api.establishment.bean;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "establishment")
public class Establishment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_establishment")
    private Long idEstablishment;

    @Column(name = "ref_establishment")
    private String refEstablishment;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;
}
