package fr.kolgna_sec.portfolio_api.experience_type.service;

import fr.kolgna_sec.portfolio_api.experience_type.bean.ExperienceType;
import fr.kolgna_sec.portfolio_api.experience_type.dto.ExperienceTypeDTO;
import fr.kolgna_sec.portfolio_api.experience_type.mappers.ExperienceTypeMapper;
import fr.kolgna_sec.portfolio_api.experience_type.repositories.ExperienceTypeRepository;
import fr.kolgna_sec.portfolio_api.uuid.service.UuidService;
import fr.kolgna_sec.portfolio_api.webservices.Webservices;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExperienceTypeService implements Webservices<ExperienceTypeDTO> {

    private final ExperienceTypeRepository experienceTypeRepository;

    private final ExperienceTypeMapper experienceTypeMapper;

    private final UuidService uuidService;

    @Override
    public Page<ExperienceTypeDTO> all(Pageable pageable) {
        return this.experienceTypeRepository.findAll(pageable)
                .map(this.experienceTypeMapper::fromExperienceType);
    }

    @Override
    public ExperienceTypeDTO add(ExperienceTypeDTO e) {
        e.setRefExperienceType(this.uuidService.generateUuid());
        return this.experienceTypeMapper.fromExperienceType(this.experienceTypeRepository
                .save(this.experienceTypeMapper.fromExperienceTypeDTO(e)));
    }

    @Override
    public ExperienceTypeDTO update(Long id, ExperienceTypeDTO e) {
        return this.experienceTypeMapper.fromExperienceType(this.experienceTypeRepository.findById(id)
                .map(experienceType -> {
                    if (experienceType.getRefExperienceType() == null)
                        experienceType.setRefExperienceType(this.uuidService.generateUuid());
                    if (experienceType.getName() != null)
                        experienceType.setName(e.getName());

                    return this.experienceTypeRepository.save(experienceType);
                })
                .orElseThrow(() -> new RuntimeException("Experience Type with ID : " +id+ " was not found")));
    }

    @Override
    public void remove(Long id) {
        Optional<ExperienceType> experienceType = this.experienceTypeRepository.findById(id);

        if (experienceType.isEmpty())
            throw new RuntimeException("Unable to retrieve Experience type. Please check the provide ID");

        this.experienceTypeRepository.delete(experienceType.get());
    }

    @Override
    public Optional<ExperienceTypeDTO> getById(Long id) {
        return this.experienceTypeRepository.findById(id)
                .map(this.experienceTypeMapper::fromExperienceType);
    }
}
