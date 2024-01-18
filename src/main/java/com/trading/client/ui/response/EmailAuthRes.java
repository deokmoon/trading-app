package com.trading.client.ui.response;

import com.trading.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmailAuthRes {

    private String userId;

    public static EmailAuthRes from(User user) {
        return new EmailAuthRes(user.getUserId());
    }

}
