package com.ertugrul.credit.service.entityservice;

import com.ertugrul.credit.entity.CreditApplication;

import java.time.LocalDate;
import java.util.Optional;

public interface CreditApplicationEntityService extends CrudEntityService<CreditApplication, Long> {
    Optional<CreditApplication> findCreditApplicationByNationalIdNumberAndBirthDate(String nationalIdNumber, LocalDate birthDate);
}
