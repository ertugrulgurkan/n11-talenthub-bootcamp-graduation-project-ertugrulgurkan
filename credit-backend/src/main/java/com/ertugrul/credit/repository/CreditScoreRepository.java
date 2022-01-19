package com.ertugrul.credit.repository;

import com.ertugrul.credit.entity.CreditScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CreditScoreRepository extends JpaRepository<CreditScore, Long> {
}
