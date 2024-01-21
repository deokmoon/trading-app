package com.trading.controller.ui;

import com.trading.controller.ui.request.AppVersionReq;
import com.trading.controller.ui.response.AppVersionRes;
import com.trading.domain.appversion.constants.AppType;
import com.trading.domain.appversion.service.AppVersionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/app-version")
@RequiredArgsConstructor
@RestController
public class AppVersionController {
/*
router.post('/', ctrl.appVersionCreate)
router.get('/:appType', ctrl.appVersionShow)
router.patch('/:appType', ctrl.appVersionUpdate)
router.delete('/:appType', ctrl.appVersionDestroy)
 */

    private final AppVersionService appVersionService;

    @RequestMapping("/{appType}")
    public AppVersionRes getAppVersion(@PathVariable String appType) {
        return appVersionService.getAppVersion(AppType.getByCode(appType));
    }

    @PostMapping
    public String createAppVersion(@RequestBody AppVersionReq req) {
        return appVersionService.createAppVersion(req);
    }

}
