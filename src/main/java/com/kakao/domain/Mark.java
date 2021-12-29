package com.kakao.domain;

public enum Mark {
    COL("|"), ROW("-----"), BLK("     ");

    private final String shape;

    Mark(String shape) {
        this.shape = shape;
    }

    public static Mark getMark(Boolean connected) {
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
