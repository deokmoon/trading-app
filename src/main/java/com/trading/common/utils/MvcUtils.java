package com.trading.common.utils;

import com.trading.common.errorcode.UserErrorCode;
import com.trading.common.exception.TradRuntimeException;
import com.trading.domain.user.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

public class MvcUtils {

    public static HttpServletRequest getHttpServletRequest() {
        final ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return servletRequestAttributes.getRequest();
    }

    public static HttpServletResponse getHttpServletResponse() {
        final ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return servletRequestAttributes.getResponse();
    }

    public static User getLoginUser() {
        final ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        User user = (User) request.getAttribute("user");
        if (Objects.nonNull(user)) {
            return user;
        }
        throw new TradRuntimeException(UserErrorCode.NO_USER);
    }

}
