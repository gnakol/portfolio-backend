package fr.kolgna_sec.portfolio_api.training.mappers;

import fr.kolgna_sec.portfolio_api.account.mappers.AccountMapper;
import fr.kolgna_sec.portfolio_api.establishment.mappers.EstablishmentMapper;
import fr.kolgna_sec.portfolio_api.training.bean.Training;
import fr.kolgna_sec.portfolio_api.training.dto.TrainingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AccountMapper.class, EstablishmentMapper.class})
public interface TrainingMapper {

    @Mapping(target = "account_id", source = "account.idAccount")
    @Mapping(target = "establishment_id", source = "establishment.idEstablishment")
    TrainingDTO fromTraining(Training training);

    @Mapping(target = "account.idAccount", source = "account_id")
    @Mapping(target = "establishment.idEstablishment", source = "establishment_id")
    Training fromTrainingDTO(TrainingDTO trainingDTO);
}
