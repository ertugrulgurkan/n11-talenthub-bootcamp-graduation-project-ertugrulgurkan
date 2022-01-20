package com.ertugrul.credit.entity;

import com.ertugrul.credit.enums.CreditApplicationResult;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "CREDIT_APPLICATIONS")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CreditApplication implements BaseEntity {
    @SequenceGenerator(name = "generator", sequenceName = "CREDIT_APPLICATION_ID_SEQ", allocationSize = 1)
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nationalIdNumber", foreignKey = @ForeignKey(name = "FK_NATIONAL_ID_NUMBER"))
    private User user;

    @NotBlank(message = "Monthly Income is mandatory")
    private Double monthlyIncome;

    private Double assurance;

    private LocalDateTime applicationDate;

    private Double creditLimitAmount;

    private CreditApplicationResult creditApplicationResult;

    @Transient
    private Long creditScore;

}
