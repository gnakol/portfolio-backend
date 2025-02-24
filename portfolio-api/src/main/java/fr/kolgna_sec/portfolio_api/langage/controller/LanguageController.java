package fr.kolgna_sec.portfolio_api.langage.controller;

import fr.kolgna_sec.portfolio_api.langage.dto.LanguageDTO;
import fr.kolgna_sec.portfolio_api.langage.service.LanguageService;
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
@RequestMapping("language")
public class LanguageController {

    private final LanguageService languageService;

    @GetMapping("/all-language")
    public ResponseEntity<Page<LanguageDTO>> allLanguage(Pageable pageable)
    {
        return ResponseEntity.ok(this.languageService.all(pageable));
    }

    @PostMapping("/add-language")
    public ResponseEntity<LanguageDTO> addLanguage(@Validated @RequestBody LanguageDTO languageDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.languageService.add(languageDTO));
    }

    @PutMapping("/update-language/{idLanguage}")
    public ResponseEntity<LanguageDTO> updateLanguage(@Validated @PathVariable Long idLanguage, @RequestBody LanguageDTO languageDTO)
    {
        return ResponseEntity.status(202).body(this.languageService.update(idLanguage, languageDTO));
    }

    @DeleteMapping("/remove-language/{idLanguage}")
    public ResponseEntity<String> removeLanguage(@Validated @PathVariable Long idLanguage)
    {
        this.languageService.remove(idLanguage);

        return ResponseEntity.status(202).body("Langage with ID : " +idLanguage+ " has been successfully remove");
    }

    @GetMapping("/get-by-id-language/{idLanguage}")
    public ResponseEntity<LanguageDTO> getByIdLanguage(@Validated @PathVariable Long idLanguage)
    {
        return this.languageService.getById(idLanguage)
                .map(languageDTO -> {
                    log.info("Language with ID : " +idLanguage+ " has been found");
                    return new ResponseEntity<>(languageDTO, HttpStatus.OK);
                })
                .orElseThrow(() -> {
                    log.error("Language with ID : " +idLanguage+ " was not found");
                    throw new RuntimeException("Unable retrieve Language. Please check the provide ID");
                });
    }
}
