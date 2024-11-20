package com.tigran.demo_software_patterns.common.model.audit;

import com.tigran.demo_software_patterns.common.model.base.AbstractDomainEntity;
import com.tigran.demo_software_patterns.common.model.base.ModelStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

/**
 * Created by Tigran Melkonyan
 * Date: 11/16/24
 * Time: 12:38 PM
 */
@EntityListeners(AuditListener.class)
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public  class AuditableBaseEntity extends AbstractDomainEntity {
  
    @CreatedDate
    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    @LastModifiedDate
    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @Column(name = "deleted_on")
    private LocalDateTime deletedOn;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ModelStatus status = ModelStatus.ACTIVE;

}
