package com.trading.domain.appversion.service.impl;

import com.trading.controller.ui.request.AppVersionReq;
import com.trading.controller.ui.response.AppVersionRes;
import com.trading.common.errorcode.AppVersionErrorCode;
import com.trading.common.exception.TradRuntimeException;
import com.trading.common.utils.MvcUtils;
import com.trading.domain.appversion.AppVersion;
import com.trading.domain.appversion.constants.AppType;
import com.trading.domain.appversion.repository.AppVersionRepository;
import com.trading.domain.appversion.service.AppVersionService;
import com.trading.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AppVersionServiceImpl implements AppVersionService {

    private final AppVersionRepository appVersionRepository;

    @Override
    public AppVersionRes getAppVersion(AppType appType) {
        Optional<AppVersion> maybeAppVersion = appVersionRepository.findTopByAppType(appType);
        maybeAppVersion.ifPresent(AppVersionRes::from);
        throw new TradRuntimeException(AppVersionErrorCode.NO_APP_VERSION);
    }

    @Override
    public String createAppVersion(AppVersionReq appVersionReq) {
        User user = MvcUtils.getLoginUser();
        return appVersionRepository.save(appVersionReq.toAppVersion(user));
    }

}
