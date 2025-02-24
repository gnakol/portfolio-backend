package fr.kolgna_sec.portfolio_api.skill_categori.bean;

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
@Table(name = "skill_category")
public class SkillCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_skill_category")
    private Long idSkillCategory;

    @Column(name = "ref_skill_category")
    private String refSkillCategory;

    @Column(name = "name")
    private String name;
}
