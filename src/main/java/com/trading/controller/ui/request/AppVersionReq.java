package com.trading.controller.ui.request;

import com.trading.domain.appversion.AppVersion;
import com.trading.domain.appversion.constants.AppType;
import com.trading.domain.user.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter
public class AppVersionReq {

    @NotNull
    private AppType appType;

    @NotBlank
    private String version;

    public AppVersion toAppVersion(User user) {
        String appVersionId = UUID.randomUUID().toString();
        return AppVersion.builder()
                .appVersionId(appVersionId)
                .appType(appType)
                .appVersion(version)
                .build();
    }

}
