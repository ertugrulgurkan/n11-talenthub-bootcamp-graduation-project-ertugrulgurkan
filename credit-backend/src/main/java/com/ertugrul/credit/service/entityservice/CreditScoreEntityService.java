package com.ertugrul.credit.service.entityservice;


import com.ertugrul.credit.entity.CreditScore;
import com.ertugrul.credit.repository.CreditScoreRepository;
import org.springframework.stereotype.Service;


@Service
public class CreditScoreEntityService extends BaseEntityService<CreditScore, CreditScoreRepository> {
    public CreditScoreEntityService(CreditScoreRepository CreditScoreRepository) {
        super(CreditScoreRepository);
    }
}