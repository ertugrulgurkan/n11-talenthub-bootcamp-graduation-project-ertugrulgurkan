package com.ertugrul.credit.repository;

import com.ertugrul.credit.entity.CreditApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface CreditApplicationRepository extends JpaRepository<CreditApplication, Long> {
    Optional<CreditApplication> findCreditApplicationByUserNationalIdNumberAndUserBirthDate(String nationalIdNumber, LocalDate birthDate);
}
