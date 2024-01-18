package com.trading.domain.user.service;

import com.trading.client.application.response.GoogleUserRes;
import com.trading.common.constants.YesNo;
import com.trading.domain.user.User;
import com.trading.domain.user.constants.AuthType;

import java.util.Optional;

public interface UserService {

    User getUserByUserId(String userId);

    Optional<User> findByEmailAndAuthType(String email, AuthType authType);

    User getUserByEmailAndAuthTypeAndAuthYn(String email, AuthType authType, YesNo authKey);

    User updateUser(User user);

    User createUser(User user);

    User getUserByUserIdAndAuthKey(String userId, String authKey);

    User findByEmailAndAuthKey(String email, String authKey);

    User getOrCreateUser(GoogleUserRes googleUserRes, AuthType authType);

}
