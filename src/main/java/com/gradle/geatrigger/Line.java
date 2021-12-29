package com.gradle.geatrigger;

import java.util.ArrayList;

public class Line {
    int width;
    ArrayList<Boolean> point;
    StringBuilder sb;

    public Line(int width) {
        this.width = width;
        sb = new StringBuilder();
        point = new ArrayList<Boolean>();
        for (int i = 0; i < width; i++)
            point.add(Math.random() > 0.5 ? true : false);
    }

    public String writeLine() {
        sb.setLength(0);
        sb.append(" ".repeat(LadderConstant.INTERVAL / 2));
        for (int j = 0; j < width; j++) {
            sb.append(makeVerticals());
            sb.append(makeHorizons(point.get(j)));
        }
        sb.append(makeVerticals());
        sb.append("\n");

        return sb.toString();
    }

    private String makeHorizons(Boolean isExist) {
        return isExist ? "-".repeat(LadderConstant.INTERVAL) : " ".repeat(LadderConstant.INTERVAL);
    }

    private String makeVerticals() {
        return "|";
    }
}
