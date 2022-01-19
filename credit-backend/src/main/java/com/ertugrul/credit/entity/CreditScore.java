package com.ertugrul.credit.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "CREDIT_SCORES")
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private Long score;
}
