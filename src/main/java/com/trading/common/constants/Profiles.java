package com.trading.common.constants;

public enum Profiles {
    LOCAL("local"),
    DEVELOPMENT("dev"),
    PRODUCTION("prod");
    
    private final String profileString;

    Profiles(String profileString) {
        this.profileString = profileString;
    }

    public String getProfileString() {
        return profileString;
    }
}
