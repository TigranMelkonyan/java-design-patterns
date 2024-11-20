package com.tigran.demo_software_patterns.architectural.eventdriven.domain.base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;

/**
 * Created by Tigran Melkonyan
 * Date: 11/16/24
 * Time: 9:00 PM
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractDomainEntity {

    @Column( name = "id", updatable = false, nullable = false, unique = true, columnDefinition = "VARCHAR(255)")
    @GeneratedValue
    @Id
    @JdbcTypeCode(Types.VARCHAR)
    protected UUID id;
}

