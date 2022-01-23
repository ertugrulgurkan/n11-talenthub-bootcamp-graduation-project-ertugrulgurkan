package com.ertugrul.credit.service.entityservice.impl;


import com.ertugrul.credit.entity.CreditApplication;
import com.ertugrul.credit.repository.CreditApplicationRepository;
import com.ertugrul.credit.service.entityservice.CreditApplicationEntityService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;


@Service
public class CreditApplicationEntityServiceImpl extends BaseEntityService<CreditApplication, CreditApplicationRepository> implements CreditApplicationEntityService {

    public CreditApplicationEntityServiceImpl(CreditApplicationRepository creditApplicationRepository) {
        super(creditApplicationRepository);
    }

    @Override
    public Optional<CreditApplication> findCreditApplicationByNationalIdNumberAndBirthDate(String nationalIdNumber, LocalDate birthDate) {
        return getRepository().findCreditApplicationByUserNationalIdNumberAndUserBirthDate(nationalIdNumber, birthDate);
    }

}