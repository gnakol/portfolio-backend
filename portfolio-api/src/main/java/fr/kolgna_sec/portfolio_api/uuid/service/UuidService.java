package fr.kolgna_sec.portfolio_api.uuid.service;

import fr.kolgna_sec.portfolio_api.uuid.bean.UuidBean;
import fr.kolgna_sec.portfolio_api.uuid.repositories.UuidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UuidService {

    private final UuidRepository uuidRepository;

    public String generateUuid()
    {
        String string = UUID.randomUUID().toString();

        if (this.uuidRepository.existsByGenerate(string))
            return this.generateUuid();
        else
        {
            UuidBean uuidBean = new UuidBean();

            uuidBean.setGenerate(string);
            this.uuidRepository.save(uuidBean);

            return string;
        }
    }
}
