package fr.kolgna_sec.portfolio_api.experience_type.controller;

import fr.kolgna_sec.portfolio_api.experience_type.dto.ExperienceTypeDTO;
import fr.kolgna_sec.portfolio_api.experience_type.service.ExperienceTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("experience-type")
public class ExperienceTypeController {

    private final ExperienceTypeService experienceTypeService;

    @GetMapping("/all-experience-type")
    public ResponseEntity<Page<ExperienceTypeDTO>> allExperienceType(Pageable pageable)
    {
        return ResponseEntity.ok(this.experienceTypeService.all(pageable));
    }

    @PostMapping("/add-experience-type")
    public ResponseEntity<ExperienceTypeDTO> addExperienceType(@Validated @RequestBody ExperienceTypeDTO experienceTypeDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.experienceTypeService.add(experienceTypeDTO));
    }

    @PutMapping("/update-experience-type/{idExperienceType}")
    public ResponseEntity<ExperienceTypeDTO> updateExperienceType(@Validated @PathVariable Long idExperienceType, @RequestBody ExperienceTypeDTO experienceTypeDTO)
    {
        return ResponseEntity.status(202).body(this.experienceTypeService.update(idExperienceType, experienceTypeDTO));
    }

    @DeleteMapping("/remove-experience-type/{idExperienceType}")
    public ResponseEntity<String> removeExperienceType(@Validated @PathVariable Long idExperienceType)
    {
        this.experienceTypeService.remove(idExperienceType);

        return ResponseEntity.status(202).body("Experience type with ID : " +idExperienceType+ " has been successfully remove");
    }

    @GetMapping("/get-by-id-experience-type/{idExperienceType}")
    public ResponseEntity<ExperienceTypeDTO> getByIdExperienceType(@Validated @PathVariable Long idExperienceType)
    {
        return this.experienceTypeService.getById(idExperienceType)
                .map(experienceTypeDTO -> {
                    log.info("Experience type with ID : " +idExperienceType+ " has been found");
                    return new ResponseEntity<>(experienceTypeDTO, HttpStatus.OK);
                })
                .orElseThrow(() -> {
                    log.error("Experience type with ID : " +idExperienceType+ " was not found");
                    throw  new RuntimeException("Unable to retrieve Experience type. Please check the provider ID");
                });
    }
}
