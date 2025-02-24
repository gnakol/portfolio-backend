package fr.kolgna_sec.portfolio_api.skill_categori.service;

import fr.kolgna_sec.portfolio_api.skill_categori.bean.SkillCategory;
import fr.kolgna_sec.portfolio_api.skill_categori.dto.SkillCategoryDTO;
import fr.kolgna_sec.portfolio_api.skill_categori.mappers.SkillCategoryMapper;
import fr.kolgna_sec.portfolio_api.skill_categori.repositories.SkillCategoryRepository;
import fr.kolgna_sec.portfolio_api.uuid.service.UuidService;
import fr.kolgna_sec.portfolio_api.webservices.Webservices;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkillCategoryService implements Webservices<SkillCategoryDTO> {

    private final SkillCategoryRepository skillCategoryRepository;

    private final SkillCategoryMapper skillCategoryMapper;

    private final UuidService uuidService;

    @Override
    public Page<SkillCategoryDTO> all(Pageable pageable) {
        return this.skillCategoryRepository.findAll(pageable)
                .map(this.skillCategoryMapper::fromSkillCategory);
    }

    @Override
    public SkillCategoryDTO add(SkillCategoryDTO e) {

        e.setRefSkillCategory(this.uuidService.generateUuid());

        return this.skillCategoryMapper.fromSkillCategory(this.skillCategoryRepository
                .save(this.skillCategoryMapper.fromSkillCategoryDTO(e)));
    }

    @Override
    public SkillCategoryDTO update(Long id, SkillCategoryDTO e) {
        return this.skillCategoryMapper.fromSkillCategory(this.skillCategoryRepository.findById(id)
                .map(skillCategory -> {
                    if (skillCategory.getRefSkillCategory() == null)
                        skillCategory.setRefSkillCategory(this.uuidService.generateUuid());
                    if (skillCategory.getName() != null)
                        skillCategory.setName(e.getName());

                    return this.skillCategoryRepository.save(skillCategory);
                })
                .orElseThrow(() -> new RuntimeException("Unable to retrieve Skill Category; Please check provide ID")));
    }

    @Override
    public void remove(Long id) {

        Optional<SkillCategory> skillCategory = this.skillCategoryRepository.findById(id);

        if (skillCategory.isEmpty())
            throw new RuntimeException("SkillCategory with ID : " +id+ " was not found");

        this.skillCategoryRepository.delete(skillCategory.get());

    }

    @Override
    public Optional<SkillCategoryDTO> getById(Long id) {
        return skillCategoryRepository.findById(id)
                .map(this.skillCategoryMapper::fromSkillCategory);
    }
}
