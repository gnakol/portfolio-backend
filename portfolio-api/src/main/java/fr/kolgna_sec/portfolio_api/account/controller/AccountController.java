package fr.kolgna_sec.portfolio_api.account.controller;

import fr.kolgna_sec.portfolio_api.account.dto.AccountDTO;
import fr.kolgna_sec.portfolio_api.account.service.AccountService;
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
@RequestMapping("account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/all-account")
    public ResponseEntity<Page<AccountDTO>> allAccount(Pageable pageable)
    {
        return ResponseEntity.ok(this.accountService.all(pageable));
    }

    @PostMapping("/add-account")
    public ResponseEntity<AccountDTO> addAccount(@Validated @RequestBody AccountDTO accountDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.accountService.add(accountDTO));
    }

    @PutMapping("/update-account/{idAccount}")
    public ResponseEntity<AccountDTO> updateAccount(@Validated @PathVariable Long idAccount, @RequestBody AccountDTO accountDTO)
    {
        return ResponseEntity.status(202).body(this.accountService.update(idAccount, accountDTO));
    }

    @DeleteMapping("/remove-account/{idAccount}")
    public ResponseEntity<String> removeAccount(@Validated @PathVariable Long idAccount)
    {
        this.accountService.remove(idAccount);
        return ResponseEntity.status(202).body("Role with ID : " +idAccount+ " has been successfully");
    }

    @GetMapping("/get-by-id-account/{idAccount}")
    public ResponseEntity<AccountDTO> getByIdAccount(@Validated @PathVariable Long idAccount)
    {
        return  this.accountService.getById(idAccount)
                .map(accountDTO -> {
                    log.info("Account with ID : " +idAccount+ " has been found");
                    return new ResponseEntity<>(accountDTO, HttpStatus.OK);
                })
                .orElseThrow(() -> {
                    log.error("Account with ID : " +idAccount+ " was not found");
                    return new RuntimeException("Unable to retrieve Account. Please check provide ID");
                });
    }
}
