package com.trading.domain.user.repository;

import com.trading.common.constants.YesNo;
import com.trading.domain.user.User;
import com.trading.domain.user.constants.AuthType;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UserRepository extends Repository<User, String> {

    Optional<User> findByUserId(String userId);

    Optional<User> findByEmailAndAuthType(String email, AuthType authType);

    Optional<User> findByEmailAndAuthTypeAndAuthYn(String email, String authType, YesNo authYn);

    User save(User User);

    Optional<User> findByUserIdAndAuthKey(String userId, String authKey);

    Optional<User> findByEmailAndAuthKey(String email, String authKey);

}
