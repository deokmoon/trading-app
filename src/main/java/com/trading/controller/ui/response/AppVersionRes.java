package com.trading.controller.ui.response;

import com.trading.domain.appversion.AppVersion;
import com.trading.domain.appversion.constants.AppType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class AppVersionRes {

    private String appVersionId;

    private AppType appType;

    private String appVersion;

    private LocalDateTime createdDatetime;

    private String createdBy;

    private LocalDateTime updateDatetime;

    private String updatedBy;

    public static AppVersionRes from(AppVersion appVersion) {
        return AppVersionRes.builder()
                .appVersionId(appVersion.getAppVersionId())
                .appType(appVersion.getAppType())
                .appVersion(appVersion.getAppVersion())
                .createdDatetime(appVersion.getCreatedDatetime())
                .createdBy(appVersion.getCreatedBy())
                .updateDatetime(appVersion.getUpdateDatetime())
                .updatedBy(appVersion.getUpdatedBy())
                .build();
    }

}
