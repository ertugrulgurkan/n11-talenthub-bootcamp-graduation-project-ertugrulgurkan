package com.ertugrul.credit.repository;

import com.ertugrul.credit.entity.CreditApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CreditApplicationRepository extends JpaRepository<CreditApplication, Long> {
}
