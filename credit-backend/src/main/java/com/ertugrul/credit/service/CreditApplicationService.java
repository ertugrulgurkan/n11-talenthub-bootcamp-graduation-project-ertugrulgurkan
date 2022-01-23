package com.ertugrul.credit.service;

import com.ertugrul.credit.dto.CreditApplicationRequestDto;
import com.ertugrul.credit.dto.CreditApplicationResultDto;

import java.time.LocalDate;

public interface CreditApplicationService {

    CreditApplicationResultDto saveCreditApplication(CreditApplicationRequestDto creditApplicationRequestDto);

    CreditApplicationResultDto findCreditApplicationByNationalIdNumberAndBirthDate(String nationalIdNumber, LocalDate birthDate);

}