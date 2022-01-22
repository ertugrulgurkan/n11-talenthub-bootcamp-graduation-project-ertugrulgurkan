package com.ertugrul.credit.service.entityservice;


import com.ertugrul.credit.entity.CreditApplication;
import com.ertugrul.credit.repository.CreditApplicationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class CreditApplicationEntityService extends BaseEntityService<CreditApplication, CreditApplicationRepository> {
    public CreditApplicationEntityService(CreditApplicationRepository creditApplicationRepository) {
        super(creditApplicationRepository);
    }

    public Optional<CreditApplication> findCreditApplicationByNationalIdNumberAndBirthDate(String nationalIdNumber, LocalDate birthDate) {
        return getRepository().findCreditApplicationByUserNationalIdNumberAndUserBirthDate(nationalIdNumber, birthDate);
    }
}