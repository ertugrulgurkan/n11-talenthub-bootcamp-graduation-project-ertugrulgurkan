package com.ertugrul.credit.service.entityservice;


import com.ertugrul.credit.entity.CreditApplication;
import com.ertugrul.credit.repository.CreditApplicationRepository;
import org.springframework.stereotype.Service;


@Service
public class CreditApplicationEntityService extends BaseEntityService<CreditApplication, CreditApplicationRepository> {
    public CreditApplicationEntityService(CreditApplicationRepository creditApplicationRepository) {
        super(creditApplicationRepository);
    }
}