package fr.kolgna_sec.portfolio_api.account.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AccountDTO {

    private Long idAccount;

    private String refAccount;

    private String name;

    private String firstName;

    private String email;

    private String password;

    private Long phoneNumber;

    private String civility;

    private String github;

    private String linkedin;

    private String address;
}
