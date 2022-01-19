package com.ertugrul.credit.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "CREDIT_SCORE")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CreditScore implements BaseEntity {

    @SequenceGenerator(name = "generator", sequenceName = "CREDIT_SCORE_ID_SEQ", allocationSize = 1)
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    private String nationalIdNumber;

    private Long score;
}
