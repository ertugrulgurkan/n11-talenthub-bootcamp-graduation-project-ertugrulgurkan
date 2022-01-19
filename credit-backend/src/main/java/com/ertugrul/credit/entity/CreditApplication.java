package com.ertugrul.credit.entity;

import com.ertugrul.credit.enums.CreditApplicationResult;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CREDIT_APPLICATIONS")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CreditApplication implements BaseEntity{
    @SequenceGenerator(name = "generator", sequenceName = "CREDIT_APPLICATION_ID_SEQ", allocationSize = 1)
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="nationalIdNumber")
    private User user;

    private LocalDateTime applicationDate;

    private CreditApplicationResult creditApplicationResult;

}
