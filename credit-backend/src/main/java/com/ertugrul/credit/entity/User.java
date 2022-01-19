package com.ertugrul.credit.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class User implements BaseEntity {
    @SequenceGenerator(name = "generator", sequenceName = "USER_ID_SEQ", allocationSize = 1)
    @Id
    @GeneratedValue(generator = "generator")
    private Long id;

    @Column(unique = true, nullable=false)
    private String nationalIdNumber;

    private Double monthlyIncome;

    private LocalDate birthDate;

    private String name;

    private String surname;

    private String phone;

    @OneToOne(mappedBy = "user")
    private CreditScore creditScore;

    @OneToMany(mappedBy = "user")
    private List<CreditApplication> creditApplications;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}