package com.kakao.ladder.step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Boolean> points = new ArrayList<>();

    public Line() { }

    // 값을 추가
    protected void addLine(boolean isBridge) {
        points.add(isBridge);
    }

    // 해당 인덱스의 bridge를 제공
    protected boolean getBridge(int index) {
        return points.get(index);
    }

    // toString에 쓰이는 method. boolean 값에 맞게 bridge를 string으로 만들어준다.
    private String makeBridge(boolean isBridge) {
        if(isBridge)
            return "-----";
        return "     ";
    }

    // Line을 String으로 변환해준다.
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < points.size(); i++) {
            sb.append('|');
            sb.append(makeBridge(points.get(i)));
        }
        sb.append('|');
        return sb.toString();
    }
}
