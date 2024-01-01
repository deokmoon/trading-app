package com.trading.board.constants;

public enum BoardType {

    CRYPTO("Crypto"),
    STOCK("Stock");

    private final String displayName;

    BoardType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
