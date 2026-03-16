package com.tai.code.entity.identity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@PrimaryKeyJoinColumn(name="user_id")
@FieldDefaults(level = AccessLevel.PRIVATE)

@Table(name="employee")
public class Employee extends UserDtls{
    @Column(name="hire_date")
    LocalDate hireDate;

    @Column(name="position", length = 100)
    String position;

    @Column(name="salary", precision = 10, scale = 2)
    BigDecimal salary;

}
