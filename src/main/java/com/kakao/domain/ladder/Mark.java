package com.kakao.domain.ladder;

public enum Mark {
    COL("|"), ROW("-----"), BLK("     ");

    private final String shape;

    Mark(String shape) {
        this.shape = shape;
    }

    public static Mark of(Boolean connected) {
        if (Boolean.TRUE.equals(connected)) {
            return Mark.ROW;
        }
        return Mark.BLK;
    }

    @Override
    public String toString() {
        return shape;
    }
}
