package com.trading.common.constants;

/**
 * enum 을 쉽게 활용하기 위한 interface
 *
 * 상속한 경우 code 필드를 가져야 한다
 */
public interface BaseEnum {
    String getCode();

    static <S extends BaseEnum> S getEnum(Class<S> cls, Object code) {
        for (BaseEnum e : cls.getEnumConstants()) {
            if (code.equals(e.getCode())) return (S) e;
        }
        return null;
    }
}
