package com.trading.config.orm;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    @Column(name = "cret_dtime")
    @CreatedDate
    private LocalDateTime createdDatetime;

//    @Column(name = "cret_id")
//    private String createdBy;

    @Column(name = "mod_dtime")
    @LastModifiedDate
    private LocalDateTime updateDatetime;

//    @Column(name = "mod_id")
//    private String updatedBy;

//    public LocalDateTime getCreatedDate() {
//        return createdDatetime;
//    }
//
//    public LocalDateTime getModifiedDate() {
//        return updateDatetime;
//    }

}
