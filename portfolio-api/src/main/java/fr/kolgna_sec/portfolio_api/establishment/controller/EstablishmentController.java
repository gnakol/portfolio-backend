package fr.kolgna_sec.portfolio_api.establishment.controller;

import fr.kolgna_sec.portfolio_api.establishment.dto.EstablishmentDTO;
import fr.kolgna_sec.portfolio_api.establishment.service.EstablishmentService;
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
@RequestMapping("establishment")
public class EstablishmentController {

    private final EstablishmentService establishmentService;

    @GetMapping("all-establishment")
    public ResponseEntity<Page<EstablishmentDTO>> allEstablishment(Pageable pageable)
    {
        return ResponseEntity.ok(this.establishmentService.all(pageable));
    }

    @PostMapping("add-establishment")
    public ResponseEntity<EstablishmentDTO> addEstablishment(@Validated @RequestBody EstablishmentDTO establishmentDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.establishmentService.add(establishmentDTO));
    }

    @PutMapping("update-establishment/{idEstablishment}")
    public ResponseEntity<EstablishmentDTO> updateEstablishment(@Validated @PathVariable Long idEstablishment, @RequestBody EstablishmentDTO establishmentDTO)
    {
        return ResponseEntity.status(202).body(this.establishmentService.update(idEstablishment, establishmentDTO));
    }

    @DeleteMapping("remove-establishment/{idEstablishment}")
    public ResponseEntity<String> removeEstablishment(@Validated @PathVariable Long idEstablishment)
    {
        this.establishmentService.remove(idEstablishment);

        return ResponseEntity.status(202).body("Establishment with ID : " +idEstablishment+ "has been successfully");
    }

    @GetMapping("get-by-id-establishment/{idEstablishment}")
    public ResponseEntity<EstablishmentDTO> getByIdEstablishment(@Validated @PathVariable Long idEstablishment)
    {
        return this.establishmentService.getById(idEstablishment)
                .map(establishmentDTO -> {
                    log.info("Establishment with ID " +idEstablishment+ "has been successfully");
                    return new ResponseEntity<>(establishmentDTO, HttpStatus.OK);
                })
                .orElseThrow(() -> {
                    log.error("Establishment with ID :" +idEstablishment+ " was not found");
                    throw new RuntimeException("Unable to retrieve Establishment. Please check the provide ID");
                });
    }
}
