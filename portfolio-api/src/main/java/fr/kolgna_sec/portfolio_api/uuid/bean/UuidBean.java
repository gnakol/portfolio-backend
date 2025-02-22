package fr.kolgna_sec.portfolio_api.uuid.bean;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "uuid")
public class UuidBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_uuid")
    private Long id_uuid;

    @Column(name = "uuid")
    private String generate;
}
