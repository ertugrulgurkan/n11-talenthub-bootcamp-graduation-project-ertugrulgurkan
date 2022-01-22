package com.ertugrul.credit.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@RequiredArgsConstructor
public class User implements BaseEntity {
    @SequenceGenerator(name = "generator", sequenceName = "USER_ID_SEQ", allocationSize = 1)
    @Id
    @GeneratedValue(generator = "generator")
    private Long id;

    @NotBlank(message = "National Id Number is mandatory")
    @Column(unique = true, nullable = false, length = 11)
    @Pattern(regexp = "[\\d]{11}", message = "National Id Number should contain 11 digits!")
    private String nationalIdNumber;

    @Past(message = "BirthDate must be a past date")
    private LocalDate birthDate;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Surname is mandatory")
    private String surname;

    @NotBlank(message = "Phone is mandatory")
    private String phone;


    @OneToOne(cascade = CascadeType.ALL)
    private CreditApplication creditApplication;

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