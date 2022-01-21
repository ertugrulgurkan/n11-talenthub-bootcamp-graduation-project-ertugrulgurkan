package com.ertugrul.credit.entity;

import com.ertugrul.credit.enums.CreditApplicationResult;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "CREDIT_APPLICATIONS")
@Getter
@Setter
@RequiredArgsConstructor
public class CreditApplication implements BaseEntity {
    @SequenceGenerator(name = "generator", sequenceName = "CREDIT_APPLICATION_ID_SEQ", allocationSize = 1)
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "nationalIdNumber", foreignKey = @ForeignKey(name = "FK_NATIONAL_ID_NUMBER"))
    private User user;

    @NotNull(message = "Monthly Income is mandatory")
    private Double monthlyIncome;

    private Double assurance;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime applicationDate;

    private Double creditLimitAmount;

    private CreditApplicationResult creditApplicationResult;

    @Transient
    private Long creditScore;

}
