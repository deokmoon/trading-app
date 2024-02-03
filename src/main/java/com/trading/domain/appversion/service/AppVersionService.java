package com.trading.domain.appversion.service;

import com.trading.controller.request.AppVersionReq;
import com.trading.controller.response.AppVersionRes;
import com.trading.domain.appversion.constants.AppType;

public interface AppVersionService {

    AppVersionRes getAppVersion(AppType appType);

    String createAppVersion(AppVersionReq appVersionReq);

}
