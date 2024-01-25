package com.trading.domain.user;

import com.trading.config.orm.BaseTimeEntity;
import com.trading.domain.auth.utils.AuthUtils;
import com.trading.common.annotation.Description;
import com.trading.common.constants.YesNo;
import com.trading.domain.user.constants.AuthType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.HashMap;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@DynamicInsert
//@DynamicUpdate
@Entity
@Table(name = "UserBaseInfo")
public class User extends BaseTimeEntity {

    @Description("사용자ID")
    @Id
    private String userId;

    @Description("이메일주소")
    private String email;

    @Description("사용자명")
    private String name;

    @Description("비밀번호")
    private String pw;

    @Description("프로필 문구")
    private String profile;

//    @Description("생성일시")
//    @CreatedDate
//    private LocalDateTime cretDtime;

    @Description("생성자ID")
    private String cretId;

//    @Description("수정일시")
//    @LastModifiedDate
//    private LocalDateTime modDtime;

    @Description("수정자ID")
    private String modId;

    @Description("인증키")
    private String authKey;

    @Description("인증여부")
    private YesNo authYn;

    @Description("프로필 사진 위치")
    private String profilePicUrl;

    @Description(value = "인증 타입", comment = "이메일, 구글, 애플")
    @Enumerated(EnumType.STRING)
    private AuthType authType;

    public void authenticateEmail() {
        this.authYn = YesNo.YES;
        this.authKey = "";
    }

    public void createAuthKey() {
        this.authKey = AuthUtils.generateEmailCode();
    }

    public void resetPassword(String hashedPassword) {
        this.pw = hashedPassword;
    }

    public HashMap<String, Object> toHashMap() {
        final HashMap<String, Object> map = new HashMap();
        map.put("userId", userId);
        map.put("email", email);
        map.put("name", name);
        map.put("profile", profile);
        map.put("profilePicUrl", profilePicUrl);
        map.put("authType", authType);
        return map;
    }

}
