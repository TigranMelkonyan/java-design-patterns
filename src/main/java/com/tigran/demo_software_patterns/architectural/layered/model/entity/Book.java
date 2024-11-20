package com.tigran.demo_software_patterns.architectural.layered.model.entity;

import com.tigran.demo_software_patterns.common.model.audit.AuditableBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Tigran Melkonyan
 * Date: 11/20/24
 * Time: 4:28 PM
 */


@Entity
@Data
@NoArgsConstructor
public class Book extends AuditableBaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String publisher;

    @Column(columnDefinition = "TEXT")
    private String content;

}

