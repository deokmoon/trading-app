package com.trading.domain.appversion;

import com.trading.config.orm.BaseTimeEntity;
import com.trading.domain.appversion.constants.AppType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "AppVersionInfo")
public class AppVersion extends BaseTimeEntity {

    @Id
    private String appVersionId;

    @Enumerated(EnumType.STRING)
    private AppType appType;

    private String appVersion;

    @Column(name = "cret_id")
    private String createdBy;

    @Column(name = "mod_id")
    private String updatedBy;

}
