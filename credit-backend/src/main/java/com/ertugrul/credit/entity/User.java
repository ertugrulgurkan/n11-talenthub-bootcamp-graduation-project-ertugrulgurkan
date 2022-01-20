package com.ertugrul.credit.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
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

    @NotBlank(message = "National Id Number is mandatory")
    @Size(min = 11, max = 11, message = "National Id Number should be 11 characters.")
    @Column(unique = true, nullable = false, length = 11)
    private String nationalIdNumber;

    @Past()
    private LocalDate birthDate;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Surname is mandatory")
    private String surname;

    @NotBlank(message = "Phone is mandatory")
    private String phone;

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