package fr.kolgna_sec.portfolio_api.account.mappers;

import fr.kolgna_sec.portfolio_api.account.bean.Account;
import fr.kolgna_sec.portfolio_api.account.dto.AccountDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDTO fromAccount(Account account);

    Account fromAccountDTO(AccountDTO accountDTO);
}
