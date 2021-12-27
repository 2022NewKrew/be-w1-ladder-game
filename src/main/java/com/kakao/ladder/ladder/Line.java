package com.kakao.ladder.ladder;

import java.util.ArrayList;
import java.util.Random;

public class Line {

    private static final String COL = "|";
    private static final String ROW = "-";
    private static final String BLK = " ";

    private final ArrayList<Boolean> arr;

    public Line() {
        arr = new ArrayList<>();
    }

    public void draw(int n) {
        Random r = new Random();
        boolean prev = false;
        for (int i = 0; i < n - 1; i++) {
            boolean odd = r.nextInt() % 2 != 0;
            if (prev && odd) {
                odd = false;
            }
            arr.add(odd);
            prev = odd;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Boolean exist : arr) {
            sb.append(COL);
            sb.append(Boolean.TRUE.equals(exist) ? ROW : BLK);
        }
        sb.append(COL);
        return sb.toString();
    }
}
