package com.kakao.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final int width;
    private final int height;
    private final List<Line> lines;

    private Ladder(int width, int height) {
        validateParams(width, height);
        this.width = width;
        this.height = height;
        lines = new ArrayList<>();
    }

    public static Ladder create(int width, int height) {
        return new Ladder(width, height);
    }

    private void validateParams(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("너비와 높이 모두 1 이상이어야 합니다.");
        }
    }

    public void drawLines() {
        for (int i = 0; i < height; i++) {
            Line line = new Line();
            line.draw(width);
            lines.add(line);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Line line : lines) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }
}
