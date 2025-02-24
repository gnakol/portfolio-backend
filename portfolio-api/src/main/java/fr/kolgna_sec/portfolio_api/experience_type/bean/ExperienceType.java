package fr.kolgna_sec.portfolio_api.experience_type.bean;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "experience_type")
public class ExperienceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_experience_type")
    private Long idExperienceType;

    @Column(name = "ref_experience_type")
    private String refExperienceType;

    @Column(name = "name")
    private String name;
}
