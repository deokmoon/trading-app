package com.trading.domain.user.service.impl;

import com.trading.client.application.response.GoogleUserRes;
import com.trading.common.constants.YesNo;
import com.trading.common.errorcode.UserErrorCode;
import com.trading.common.exception.TradRuntimeException;
import com.trading.domain.user.User;
import com.trading.domain.user.constants.AuthType;
import com.trading.domain.user.repository.UserRepository;
import com.trading.domain.user.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserByUserId(String userId) {
        Optional<User> maybeUser = userRepository.findByUserId(userId);
        if (maybeUser.isPresent()) {
            User user = maybeUser.get();
            return user;
        } else {
            throw new TradRuntimeException(UserErrorCode.NO_USER);
        }
    }

    @Override
    public Optional<User> findByEmailAndAuthType(String email, AuthType authType) {
        return userRepository.findByEmailAndAuthType(email, authType);
    }

    @Override
    public User getUserByEmailAndAuthTypeAndAuthYn(String email, AuthType authType, YesNo authYn) {
        Optional<User> maybeUser = userRepository.findByEmailAndAuthTypeAndAuthYn(email, authType.getCode(), authYn);
        if (maybeUser.isPresent()) {
            User user = maybeUser.get();
            return user;
        } else {
            throw new TradRuntimeException(UserErrorCode.NO_USER);
        }
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        Optional<User> maybeUser = userRepository.findByUserId(user.getUserId());
        if (maybeUser.isPresent()) {
//            User User = maybeUser.get();
//            User.update(user);
            return user;
        } else {
            throw new TradRuntimeException(UserErrorCode.NO_USER);
        }
    }

    @Override
    public User createUser(User user) {
        User saved = userRepository.save(user);
        return saved;
    }

    @Override
    public User getUserByUserIdAndAuthKey(String userId, String authKey) {
        Optional<User> maybeUser = userRepository.findByUserIdAndAuthKey(userId, authKey);
        if (maybeUser.isPresent()) {
            return maybeUser.get();
        } else {
            throw new TradRuntimeException(UserErrorCode.NO_USER);
        }
    }

    @Override
    public User getUserByEmailAndAuthKey(String email, String authKey) {
        Optional<User> maybeUser = userRepository.findByUserIdAndAuthKey(email, authKey);
        if (maybeUser.isPresent()) {
            return maybeUser.get();
        } else {
            throw new TradRuntimeException(UserErrorCode.NO_USER);
        }
    }

    /**
     * 사용자 정보를 조회하거나 생성한다
     */
    @Override
    public User getOrCreateUser(GoogleUserRes googleUserRes, AuthType authType) {
        Optional<User> maybeUser = findByEmailAndAuthType(googleUserRes.getEmail(), authType);
        return maybeUser
                .orElse(createUser(googleUserRes.toUser()));
    }

}
