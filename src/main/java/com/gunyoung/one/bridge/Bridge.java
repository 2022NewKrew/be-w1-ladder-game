package com.gunyoung.one.bridge;

public class Bridge {
    private boolean isExist;

    private Bridge(boolean isExist) {
        this.isExist = isExist;
    }

    public static Bridge of(boolean isExist) {
        return new Bridge(isExist);
    }

    public boolean isExist() {
        return isExist;
    }
}
