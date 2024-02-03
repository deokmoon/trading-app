package com.trading.domain.appversion.repository;

import com.trading.domain.appversion.AppVersion;
import com.trading.domain.appversion.constants.AppType;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface AppVersionRepository extends Repository<AppVersion, String> {

    Optional<AppVersion> findTopByAppType(AppType appType);

    AppVersion save(AppVersion appVersion);

}
