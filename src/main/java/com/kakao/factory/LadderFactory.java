package com.kakao.factory;

import com.kakao.domain.Ladder;
import com.kakao.domain.Line;
import com.kakao.util.RandomUtil;
import java.util.ArrayList;
import java.util.List;

public class LadderFactory {

    public LadderFactory() {}

    public Ladder create(int width, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(drawLine(width));
        }
        return new Ladder(lines);
    }

    private Line drawLine(int width) {
        List<Boolean> points = new ArrayList<>();
        Boolean prev = Boolean.FALSE;
        for (int i = 0; i < width - 1; i++) {
            Boolean point = RandomUtil.nextBoolean();
            points.add(avoidOverlapping(prev, point));
            prev = point;
        }
        return new Line(points);
    }

    private Boolean avoidOverlapping(Boolean prev, Boolean point) {
        return !prev && point;
    }
}